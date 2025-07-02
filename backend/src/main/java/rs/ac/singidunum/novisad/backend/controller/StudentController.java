package rs.ac.singidunum.novisad.backend .controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.singidunum.novisad.backend.dto.MojiPredmetiDTO;
import rs.ac.singidunum.novisad.backend.dto.NastavniMaterijalDTO;
import rs.ac.singidunum.novisad.backend.dto.NastavnikDTO;
import rs.ac.singidunum.novisad.backend.dto.PredmetDTO;
import rs.ac.singidunum.novisad.backend.dto.StudentDTO;
import rs.ac.singidunum.novisad.backend.dto.StudentIzmenaDTO;
import rs.ac.singidunum.novisad.backend.dto.StudijskiProgramDTO;
import rs.ac.singidunum.novisad.backend.model.Polaganje;
import rs.ac.singidunum.novisad.backend.model.academic.Predmet;
import rs.ac.singidunum.novisad.backend.model.academic.StudijskiProgram;
import rs.ac.singidunum.novisad.backend.model.user.Student;
import rs.ac.singidunum.novisad.backend.security.services.UserDetailsImpl;
import rs.ac.singidunum.novisad.backend.service.PolaganjeService;
import rs.ac.singidunum.novisad.backend.service.StudentService;
import rs.ac.singidunum.novisad.backend.service.StudijskiProgramService;

@Controller
@RequestMapping(path = "/api/studenti")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
		@Autowired
		private StudentService service;
		
		@Autowired
		private StudijskiProgramService spService;

		@Autowired
		private PolaganjeService polaganjaService;

		@Autowired
		PasswordEncoder encoder;


		@RequestMapping(path = "", method = RequestMethod.GET)
		public ResponseEntity<Iterable<StudentDTO>> getAll() {
			ArrayList<StudentDTO> student = new ArrayList<StudentDTO>();
			for (Student s : service.findAll()) {
				student.add(new StudentDTO(s.getId(), s.getClass().getSimpleName(), s.getIme(), s.getPrezime(), s.getEmail(), s.getLozinka(), s.getPermissions(), s.getBrojIndeksa(), s.getKorisnickoIme()));
			}
			return new ResponseEntity<Iterable<StudentDTO>>(student, HttpStatus.OK);
		}

		@RequestMapping(path = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<StudentDTO> get(@PathVariable("id") Long id) {
			Optional<Student> s = service.findOne(id);
			if (s.isPresent()) {
				StudentDTO dto = new StudentDTO(s.get().getId(), s.get().getClass().getSimpleName(), s.get().getIme(), s.get().getPrezime(), s.get().getEmail(), s.get().getLozinka(), s.get().getPermissions(), s.get().getBrojIndeksa(), s.get().getKorisnickoIme());
				return new ResponseEntity<StudentDTO>(dto, HttpStatus.OK);
			}
			return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
		}

		@RequestMapping(path = "", method = RequestMethod.POST)
		public ResponseEntity<Student> create(@RequestBody Student r) {
			try {
				service.save(r);
				return new ResponseEntity<Student>(r, HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}

		@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION')")
		@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Student> update(@PathVariable("id") Long id, @RequestBody StudentIzmenaDTO student, Authentication authentication) {
			if (authentication.isAuthenticated()) {
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				Long userId = userDetails.getId();

				if (id.equals(userId)) {
					Student studentZaIzmenu = service.findOne(id).orElse(null);
					if (studentZaIzmenu != null) {
						studentZaIzmenu.setId(id);
						studentZaIzmenu.setIme(student.getIme());
						studentZaIzmenu.setPrezime(student.getPrezime());
						studentZaIzmenu.setEmail(student.getEmail());
						studentZaIzmenu.setLozinka(studentZaIzmenu.getLozinka());
						studentZaIzmenu.setPermissions(studentZaIzmenu.getPermissions());

						service.save(studentZaIzmenu);
						return new ResponseEntity<Student>(HttpStatus.OK);
					}
				}
			}

			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
		@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION', 'NASTAVNIK_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
		@RequestMapping(path = "/{id}/polozeniIspiti", method = RequestMethod.GET)
		public ResponseEntity<List<MojiPredmetiDTO>> getPolozeniIspiti(@PathVariable("id") Long id, Authentication authentication) {
			if (authentication.isAuthenticated()) {
					Set<Predmet> praviPredmeti = service.findOne(id).get().getPredmet();
					service.findOne(id).get().getPredmet()
							.stream().map(p -> new PredmetDTO(
									p.getId(),
									p.getSifraPredmeta(),
									new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()),
									new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()),
									p.getNaziv(),
									p.getEspb(),
									p.getOpis(),
									p.getSilabus(),
									p.getNastavniMaterijal().stream().map(nm ->
											new NastavniMaterijalDTO(
													nm.getId(),
													nm.getNaslov(),
													nm.getAutori(),
													nm.getBrojStrana(),
													nm.getIzdavac(),
													nm.getOpis(),
													nm.getKolicina(),
													nm.getIzdato()
											)).collect(Collectors.toSet()))).collect(Collectors.toSet());

					List<MojiPredmetiDTO> prikaz = new ArrayList<>();
					Iterable<Polaganje> polaganja = polaganjaService.findAll();
					for (Predmet p : praviPredmeti) {
						for (Polaganje pp : polaganja) {
							if (pp.getStudent().getId() == id && pp.getPredmet().getId() == p.getId() && pp.getKonacnaOcena() > 5 && pp.getKonacnaOcena() <=10) {
								prikaz.add(new MojiPredmetiDTO(p.getId(), p.getNaziv(), p.getOpis(), p.getSilabus(),new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()),
										pp.getBodovi(), p.getEspb(), pp.getKonacnaOcena()));
							}
						}
					}


					return new ResponseEntity<List<MojiPredmetiDTO>>(prikaz, HttpStatus.OK);
				}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION', 'NASTAVNIK_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
		@RequestMapping(path = "/{id}/nepolozeniIspiti", method = RequestMethod.GET)
		public ResponseEntity<List<MojiPredmetiDTO>> getNPIspiti(@PathVariable("id") Long id, Authentication authentication) {
			if (authentication.isAuthenticated()) {
					Set<Predmet> praviPredmeti = service.findOne(id).get().getPredmet();
					service.findOne(id).get().getPredmet()
							.stream().map(p -> new PredmetDTO(
									p.getId(),
									p.getSifraPredmeta(),
									new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()),
									new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()),
									p.getNaziv(),
									p.getEspb(),
									p.getOpis(),
									p.getSilabus(),
									p.getNastavniMaterijal().stream().map(nm ->
											new NastavniMaterijalDTO(
													nm.getId(),
													nm.getNaslov(),
													nm.getAutori(),
													nm.getBrojStrana(),
													nm.getIzdavac(),
													nm.getOpis(),
													nm.getKolicina(),
													nm.getIzdato()
											)).collect(Collectors.toSet()))).collect(Collectors.toSet());

					List<MojiPredmetiDTO> prikaz = new ArrayList<>();
					Iterable<Polaganje> polaganja = polaganjaService.findAll();
					for (Predmet p : praviPredmeti) {
						for (Polaganje pp : polaganja) {
							if (pp.getStudent().getId() == id && pp.getPredmet().getId() == p.getId() && pp.getKonacnaOcena() ==5) {
								prikaz.add(new MojiPredmetiDTO(p.getId(),p.getNaziv(), p.getOpis(), p.getSilabus(),new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()),
										pp.getBodovi(), p.getEspb(), pp.getKonacnaOcena()));
							}
						}
					}


					return new ResponseEntity<List<MojiPredmetiDTO>>(prikaz, HttpStatus.OK);
				}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION', 'NASTAVNIK_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
		@RequestMapping(path = "/{id}/sviIspiti", method = RequestMethod.GET)
		public ResponseEntity<Set<PredmetDTO>> getSviPredmeti(@PathVariable("id") Long id, Authentication authentication) {
			if (authentication.isAuthenticated()) {
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				Long userId = userDetails.getId();

				if (id.equals(userId)) {
					service.findOne(id).get().getPredmet();
					Set<PredmetDTO> predmeti = service.findOne(id).get().getPredmet()
							.stream().map(p -> new PredmetDTO(
									p.getId(),
									p.getSifraPredmeta(),
									new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()),
									p.getSilabus(),
									p.getNaziv(),
									p.getEspb(),
									new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()),
									p.getVremePocetka(),
									p.getVremeKraja(),
									p.getOpis(),
									p.getNastavniMaterijal().stream().map(nm ->
											new NastavniMaterijalDTO(
													nm.getId(),
													nm.getNaslov(),
													nm.getAutori(),
													nm.getBrojStrana(),
													nm.getIzdavac(),
													nm.getOpis(),
													nm.getKolicina(),
													nm.getIzdato(),
													nm.getGodinaIzdavanja()
											)).collect(Collectors.toSet()))).collect(Collectors.toSet());

					return new ResponseEntity<Set<PredmetDTO>>(predmeti, HttpStatus.OK);
				}
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION', 'NASTAVNIK_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
		@RequestMapping(path = "/{id}/sviAPredmeti", method = RequestMethod.GET)
		public ResponseEntity<Set<PredmetDTO>> getSviAktivniPredmeti(@PathVariable("id") Long id, Authentication authentication) {
			if (authentication.isAuthenticated()) {
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				Long userId = userDetails.getId();

				if (id.equals(userId)) {
					service.findOne(id).get().getPredmet();
					Set<PredmetDTO> predmeti = service.findOne(id).get().getPredmet()
							.stream().filter(p -> p.getVremeKraja().after(new Date())).filter(p -> p.getVremePocetka().before(new Date())).map(p -> new PredmetDTO(
									p.getId(),
									p.getSifraPredmeta(),
									new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()),
									p.getSilabus(),
									p.getNaziv(),
									p.getEspb(),
									new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()),
									p.getVremePocetka(),
									p.getVremeKraja(),
									p.getOpis(),
									p.getNastavniMaterijal().stream().map(nm ->
											new NastavniMaterijalDTO(
													nm.getId(),
													nm.getNaslov(),
													nm.getAutori(),
													nm.getBrojStrana(),
													nm.getIzdavac(),
													nm.getOpis(),
													nm.getKolicina(),
													nm.getIzdato(),
													nm.getGodinaIzdavanja()
											)).collect(Collectors.toSet()))).collect(Collectors.toSet());

					return new ResponseEntity<Set<PredmetDTO>>(predmeti, HttpStatus.OK);
				}
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION', 'NASTAVNIK_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
		@RequestMapping(path = "/{id}/nepolozeniIspiti/{id_predmeta}", method = RequestMethod.GET)
		public ResponseEntity<List<MojiPredmetiDTO>> getNepolozeniIspitiPoPredmetu(@PathVariable("id") Long id,@PathVariable("id_predmeta") Long id_predmta, Authentication authentication) {
			if (authentication.isAuthenticated()) {
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				Long userId = userDetails.getId();

				if (id.equals(userId)) {
					Set<Predmet> praviPredmeti = service.findOne(id).get().getPredmet();
					service.findOne(id).get().getPredmet()
							.stream().map(p -> new PredmetDTO(
									p.getId(),
									p.getSifraPredmeta(),
									new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()),
									new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()),
									p.getNaziv(),
									p.getEspb(),
									p.getOpis(),
									p.getSilabus(),
									p.getNastavniMaterijal().stream().map(nm ->
											new NastavniMaterijalDTO(
													nm.getId(),
													nm.getNaslov(),
													nm.getAutori(),
													nm.getBrojStrana(),
													nm.getIzdavac(),
													nm.getOpis(),
													nm.getKolicina(),
													nm.getIzdato()
											)).collect(Collectors.toSet()))).collect(Collectors.toSet());

					List<MojiPredmetiDTO> prikaz = new ArrayList<>();
					
					Iterable<Polaganje> polaganja = polaganjaService.findAll();
					for (Predmet p : praviPredmeti) {
						for (Polaganje pp : polaganja) {
							if (pp.getStudent().getId() == id && pp.getPredmet().getId() == p.getId() && pp.getPredmet().getId().equals(id_predmta) && pp.getKonacnaOcena() ==5) {
								prikaz.add(new MojiPredmetiDTO(p.getId(),p.getNaziv(), p.getOpis(), p.getSilabus(), new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()),
										pp.getBodovi(), p.getEspb(), pp.getKonacnaOcena()));
							}
						}
					}


					return new ResponseEntity<List<MojiPredmetiDTO>>(prikaz, HttpStatus.OK);
				}
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		@PreAuthorize("hasAnyAuthority('STUDENTSKASLUZBA_PERMISSION','ADMINISTRATOR_PERMISSION')")
		@RequestMapping(path = "/dsp/{smer_id}", method = RequestMethod.PUT)
			public ResponseEntity<Student> DodaliStudentuPredmete(@PathVariable("smer_id") Long smer_id, @RequestBody Student student, Authentication authentication) {

			if (authentication.isAuthenticated()) {	
				Student s = service.findOne(student.getId()).orElse(null);
					Optional<StudijskiProgram> optionalStudijskiProgram = spService.findOne(smer_id);
				    StudijskiProgram studijskiProgram = optionalStudijskiProgram.get();
				    Set<Predmet> predmeti = new HashSet<>();
				    for (Predmet p : studijskiProgram.getPredmeti()) {
					    predmeti.add(p);
				    }
					
					if (s != null) {
							s.setId(student.getId());
							s.setPredmet(predmeti);
		
							service.save(s);
							return new ResponseEntity<Student>(s,HttpStatus.OK);
							}
					return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
					}
			return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
			}

		
		@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION')")
		@RequestMapping(path = "/{id}/ispitiZaPrijavu", method = RequestMethod.GET)
		public ResponseEntity<List<PredmetDTO>> getIspitiZaPrijavu(@PathVariable("id") Long id, Authentication authentication) {
			if (authentication.isAuthenticated()) {
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				Long userId = userDetails.getId();

				if (id.equals(userId)) {
					Set<Predmet> predmetiStudenta = service.findOne(id).get().getPredmet();
					
					service.findOne(id).get().getPredmet()
							.stream().map(p -> new PredmetDTO(
									p.getId(),
									p.getSifraPredmeta(),
									new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()),
									new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()),
									p.getNaziv(),
									p.getEspb(),
									p.getOpis(),
									p.getSilabus(),
									p.getNastavniMaterijal().stream().map(nm ->
											new NastavniMaterijalDTO(
													nm.getId(),
													nm.getNaslov(),
													nm.getAutori(),
													nm.getBrojStrana(),
													nm.getIzdavac(),
													nm.getOpis(),
													nm.getKolicina(),
													nm.getIzdato()
											)).collect(Collectors.toSet()))).collect(Collectors.toSet());

					List<PredmetDTO> prikaz = new ArrayList<>();

					Iterable<Polaganje> polaganja = polaganjaService.findAll();

					for (Predmet p : predmetiStudenta) {
					    boolean polozenPredmet = false;

					    for (Polaganje pp : polaganja) {
					        if (pp.getStudent().getId() == id && pp.getPredmet().getId() == p.getId()) {
					            if (pp.getKonacnaOcena() > 5) {
					                polozenPredmet = true;
					                break;
					            }
					        }
					    }
					    if (!polozenPredmet) {
					        prikaz.add(new PredmetDTO(p.getId(), p.getSifraPredmeta(),
					                new NastavnikDTO(p.getNastavnik().getId(), p.getNastavnik().getIme(), p.getNastavnik().getPrezime()),
					                new StudijskiProgramDTO(p.getStudijskiProgram().getId(), p.getStudijskiProgram().getSifraSP(), p.getStudijskiProgram().getNaziv()),
					                p.getNaziv(), p.getEspb(), p.getOpis(), p.getSilabus()));
					    }
					}


					return new ResponseEntity<List<PredmetDTO>>(prikaz, HttpStatus.OK);
				}
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
}
