package rs.ac.singidunum.novisad.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.singidunum.novisad.backend.dto.DodajOcenuDTO;
import rs.ac.singidunum.novisad.backend.dto.NastavniMaterijalDTO;
import rs.ac.singidunum.novisad.backend.dto.NastavnikDTO;
import rs.ac.singidunum.novisad.backend.dto.PolaganjeDTO;
import rs.ac.singidunum.novisad.backend.dto.PredmetDTO;
import rs.ac.singidunum.novisad.backend.dto.StudentDTO;
import rs.ac.singidunum.novisad.backend.dto.StudijskiProgramDTO;
import rs.ac.singidunum.novisad.backend.dto.SviStudentiNastavnikaDTO;
import rs.ac.singidunum.novisad.backend.model.Polaganje;
import rs.ac.singidunum.novisad.backend.model.academic.Predmet;
import rs.ac.singidunum.novisad.backend.model.user.Nastavnik;
import rs.ac.singidunum.novisad.backend.model.user.Student;
import rs.ac.singidunum.novisad.backend.security.services.UserDetailsImpl;
import rs.ac.singidunum.novisad.backend.service.NastavnikService;
import rs.ac.singidunum.novisad.backend.service.PolaganjeService;

@Controller
@RequestMapping(path = "/api/polaganja")
@CrossOrigin(origins = "http://localhost:4200")
public class PolaganjeController {

	@Autowired
	private PolaganjeService service;

	@Autowired
	private NastavnikService profesorService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PolaganjeDTO>> getAll() {
		ArrayList<PolaganjeDTO> pokusaji = new ArrayList<PolaganjeDTO>();
		for (Polaganje pp : service.findAll()) {
			Predmet p = pp.getPredmet();
			Student s = pp.getStudent();
			Nastavnik n = pp.getNastavnik();
			
			Set<NastavniMaterijalDTO> nastavniMaterijal = p.getNastavniMaterijal().stream().map(nm -> new NastavniMaterijalDTO(
					nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getBrojStrana(), nm.getIzdavac(), nm.getOpis(),
					nm.getKolicina(),
					nm.getIzdato()
			)).collect(Collectors.toSet());
			PredmetDTO predmet = new PredmetDTO(p.getId(),p.getSifraPredmeta(), new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()),new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()), p.getNaziv(), p.getEspb(), p.getOpis(), p.getSilabus(), nastavniMaterijal);
			StudentDTO student = new StudentDTO(s.getId(), s.getClass().getSimpleName(), s.getIme(), s.getPrezime(), s.getEmail(), s.getLozinka(), s.getPermissions(), s.getBrojIndeksa(), s.getKorisnickoIme());
			NastavnikDTO nastavnik = new NastavnikDTO(n.getId(), n.getClass().getSimpleName(), n.getIme(), n.getPrezime(), n.getEmail(), n.getLozinka());


			pokusaji.add(new PolaganjeDTO(pp.getId(), pp.getBodovi(), pp.getKonacnaOcena(), pp.getPocetak(), pp.getKraj(), pp.getNapomena(),student, predmet, nastavnik));
		}
		return new ResponseEntity<Iterable<PolaganjeDTO>>(pokusaji, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PolaganjeDTO> get(@PathVariable("id") Long id) {
		Optional<Polaganje> pp = service.findOne(id);
		if (pp.isPresent()) {
			Predmet p = pp.get().getPredmet();
			Student s = pp.get().getStudent();
			Nastavnik n = pp.get().getNastavnik();
			Set<NastavniMaterijalDTO> nastavniMaterijal = p.getNastavniMaterijal().stream().map(nm -> new NastavniMaterijalDTO(
					nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getBrojStrana(), nm.getIzdavac(), nm.getOpis(),
					nm.getKolicina(),
					nm.getIzdato()
			)).collect(Collectors.toSet());
			PredmetDTO predmet = new PredmetDTO(p.getId(),p.getSifraPredmeta(),  new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()), new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()), p.getNaziv(), p.getEspb(), p.getOpis(), p.getSilabus(), nastavniMaterijal);
			StudentDTO student = new StudentDTO(s.getId(), s.getClass().getSimpleName(), s.getIme(), s.getPrezime(), s.getEmail(), s.getLozinka(), s.getPermissions(), s.getBrojIndeksa(), s.getKorisnickoIme());
			NastavnikDTO nastavnik = new NastavnikDTO(n.getId(), n.getClass().getSimpleName(), n.getIme(), n.getPrezime(), n.getEmail(), n.getLozinka());
			
			PolaganjeDTO pokusaj = new PolaganjeDTO(pp.get().getId(), pp.get().getBodovi(), pp.get().getKonacnaOcena(),pp.get().getPocetak(),pp.get().getKraj(),pp.get().getNapomena(),student, predmet,  nastavnik);
			return new ResponseEntity<PolaganjeDTO>(pokusaj, HttpStatus.OK);
		}
		return new ResponseEntity<PolaganjeDTO>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION')")
	@RequestMapping(path = "/c", method = RequestMethod.POST)
	public ResponseEntity<Polaganje> create(@RequestBody Polaganje p){
		try {
			service.save(p);
			return new ResponseEntity<Polaganje>(p, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Polaganje>(HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasAnyAuthority('NASTAVNIK_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Polaganje> update(@PathVariable("id") Long id, @RequestBody Polaganje pokusajPolaganja) {

		Polaganje u = service.findOne(id).orElse(null);
		if (u != null) {

			pokusajPolaganja.setId(id);
			if (pokusajPolaganja.getBodovi() == 0) {
				pokusajPolaganja.setBodovi(u.getBodovi());
			}
			if(pokusajPolaganja.getKonacnaOcena() == 0) {
				pokusajPolaganja.setKonacnaOcena(u.getKonacnaOcena());
			}
			pokusajPolaganja.setPredmet(u.getPredmet());
			pokusajPolaganja.setStudent(u.getStudent());
			pokusajPolaganja.setNastavnik(u.getNastavnik());
			service.save(pokusajPolaganja);

			return new ResponseEntity<Polaganje> (HttpStatus.OK);
				}

		return new ResponseEntity<Polaganje>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasAnyAuthority('STUDENTSKASLUZBA_PERMISSION','ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Polaganje> delete(@PathVariable("id") Long id) {
		if (service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<Polaganje>(HttpStatus.OK);
		}
		return new ResponseEntity<Polaganje>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasAnyAuthority('NASTAVNIK_PERMISSION')")
	@RequestMapping(path = "/dobaviNastavniku/{idNastavnika}", method = RequestMethod.GET)
	public ResponseEntity<List<DodajOcenuDTO>> getPredmeteProfesora(
			@PathVariable("idNastavnika") Long idProfesora,
			Authentication authentication
	) {
		if(authentication.isAuthenticated()) {
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		Long userId = userDetails.getId();

			if (idProfesora.equals(userId)) {

				Set<Predmet> profesoroviPredmeti = profesorService.findOne(idProfesora).get().getPredmeti();

				List<DodajOcenuDTO> response = new ArrayList<>();
				for(Predmet p : profesoroviPredmeti) {

					List<SviStudentiNastavnikaDTO>  studenti = new ArrayList<SviStudentiNastavnikaDTO>();
					for(Student s : p.getStudenti()) {

						for(Polaganje pp : service.findAll()) {

							if(pp.getPredmet().getId().equals(p.getId()) && pp.getStudent().getId() == s.getId()) {

								SviStudentiNastavnikaDTO student = new SviStudentiNastavnikaDTO(s.getId(), pp.getId(), s.getIme(), s.getPrezime(), s.getBrojIndeksa(), pp.getBodovi(), pp.getKonacnaOcena());
								studenti.add(student);
								break;

							}
						}


					}
					if(studenti.size() > 0 ) {
						response.add(new DodajOcenuDTO(
								p.getId(), p.getNaziv(), p.getEspb(), p.getSilabus(), studenti));
					}
				}
				return new ResponseEntity<List<DodajOcenuDTO>>(response, HttpStatus.OK);

			}
		}

		return new ResponseEntity<List<DodajOcenuDTO>>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "prijavljeni/{id}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PolaganjeDTO>> getPrijavljeniIspiti(@PathVariable("id") Long id) {
		ArrayList<PolaganjeDTO> pokusaji = new ArrayList<PolaganjeDTO>();
		for (Polaganje pp : service.findAll()) {
			if(pp.getKonacnaOcena()==0 && pp.getBodovi()==0.0 && pp.getStudent().getId()==id) {
				Predmet p = pp.getPredmet();
				Student s = pp.getStudent();
				Nastavnik n = pp.getNastavnik();
				
				Set<NastavniMaterijalDTO> nastavniMaterijal = p.getNastavniMaterijal().stream().map(nm -> new NastavniMaterijalDTO(
						nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getBrojStrana(), nm.getIzdavac(), nm.getOpis(),
						nm.getKolicina(),
						nm.getIzdato()
				)).collect(Collectors.toSet());
				PredmetDTO predmet = new PredmetDTO(p.getId(),p.getSifraPredmeta(),  new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()), new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()), p.getNaziv(), p.getEspb(), p.getOpis(), p.getSilabus(), nastavniMaterijal);
				StudentDTO student = new StudentDTO(s.getId(), s.getClass().getSimpleName(), s.getIme(), s.getPrezime(), s.getEmail(), s.getLozinka(), s.getPermissions(), s.getBrojIndeksa(), s.getKorisnickoIme());
				NastavnikDTO nastavnik = new NastavnikDTO(n.getId(), n.getClass().getSimpleName(), n.getIme(), n.getPrezime(), n.getEmail(), n.getLozinka());
	
	
				pokusaji.add(new PolaganjeDTO(pp.getId(), pp.getBodovi(), pp.getKonacnaOcena(), pp.getPocetak(), pp.getKraj(), pp.getNapomena(),student, predmet, nastavnik));
		}}
		return new ResponseEntity<Iterable<PolaganjeDTO>>(pokusaji, HttpStatus.OK);
	}
	
	@RequestMapping(path = "prijavljeniPoPredmetu/{id}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PolaganjeDTO>> getPrijavljeniIspitiPoPredmetu(@PathVariable("id") Long id) {
		ArrayList<PolaganjeDTO> pokusaji = new ArrayList<PolaganjeDTO>();
		for (Polaganje pp : service.findAll()) {
			if(pp.getKonacnaOcena()==0 && pp.getBodovi()==0.0 && pp.getPredmet().getId().equals(id)) {
				Predmet p = pp.getPredmet();
				Student s = pp.getStudent();
				Nastavnik n = pp.getNastavnik();
				
				Set<NastavniMaterijalDTO> nastavniMaterijal = p.getNastavniMaterijal().stream().map(nm -> new NastavniMaterijalDTO(
						nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getBrojStrana(), nm.getIzdavac(), nm.getOpis(),
						nm.getKolicina(),
						nm.getIzdato()
				)).collect(Collectors.toSet());
				PredmetDTO predmet = new PredmetDTO(p.getId(),p.getSifraPredmeta(),  new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime()), new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()), p.getNaziv(), p.getEspb(), p.getOpis(), p.getSilabus(), nastavniMaterijal);
				StudentDTO student = new StudentDTO(s.getId(), s.getClass().getSimpleName(), s.getIme(), s.getPrezime(), s.getEmail(), s.getLozinka(), s.getPermissions(), s.getBrojIndeksa(), s.getKorisnickoIme());
				NastavnikDTO nastavnik = new NastavnikDTO(n.getId(), n.getClass().getSimpleName(), n.getIme(), n.getPrezime(), n.getEmail(), n.getLozinka());
	
	
				pokusaji.add(new PolaganjeDTO(pp.getId(), pp.getBodovi(), pp.getKonacnaOcena(), pp.getPocetak(), pp.getKraj(), pp.getNapomena(),student, predmet, nastavnik));
		}}
		return new ResponseEntity<Iterable<PolaganjeDTO>>(pokusaji, HttpStatus.OK);
	}
	
}
