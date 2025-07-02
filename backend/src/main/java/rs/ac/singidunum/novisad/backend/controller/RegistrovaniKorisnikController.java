package rs.ac.singidunum.novisad.backend.controller;

import java.util.HashSet;
import java.util.Set;

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

import rs.ac.singidunum.novisad.backend.dto.AdministratorDTO;
import rs.ac.singidunum.novisad.backend.dto.NastavnikDTO;
import rs.ac.singidunum.novisad.backend.dto.RegistrovaniKorisnikDTO;
import rs.ac.singidunum.novisad.backend.dto.StudentDTO;
import rs.ac.singidunum.novisad.backend.dto.StudentskaSluzbaDTO;
import rs.ac.singidunum.novisad.backend.model.user.Administrator;
import rs.ac.singidunum.novisad.backend.model.user.Nastavnik;
import rs.ac.singidunum.novisad.backend.model.user.RegistrovaniKorisnik;
import rs.ac.singidunum.novisad.backend.model.user.Student;
import rs.ac.singidunum.novisad.backend.model.user.StudentskaSluzba;
import rs.ac.singidunum.novisad.backend.repository.PermissionRepository;
import rs.ac.singidunum.novisad.backend.security.services.UserDetailsImpl;
import rs.ac.singidunum.novisad.backend.service.RegistrovaniKorisnikService;

@Controller
@RequestMapping(path = "/api/registrovaniKorisnici")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrovaniKorisnikController {

	@Autowired
	private RegistrovaniKorisnikService service;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	PermissionRepository permisionRepository;
	
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Set<RegistrovaniKorisnikDTO>> getAll() {
		HashSet<RegistrovaniKorisnik> korisnici = new HashSet<RegistrovaniKorisnik>();
		HashSet<RegistrovaniKorisnikDTO> response = new HashSet<>();
		for (RegistrovaniKorisnik k : service.findAll()) {
			korisnici.add(new RegistrovaniKorisnik(k.getKorisnickoIme(),k.getIme(),k.getPrezime(), k.getEmail(), k.getLozinka()));
			response.add(new RegistrovaniKorisnikDTO(k.getClass().getSimpleName(), k.getId(), k.getKorisnickoIme(), k.getEmail(), k.getLozinka(), k.getPermissions(),k.getIme(),k.getPrezime()));
		}
		return new ResponseEntity<Set<RegistrovaniKorisnikDTO>>(response, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'STUDENT_PERMISSION', 'NASTAVNIK_PERMISSION', 'KORISNIK_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
		RegistrovaniKorisnik k = service.findOne(id).orElse(null);
				if (k != null) {

					if (k instanceof Student) {
						String brojIndeksa = ((Student) k).getBrojIndeksa();
						StudentDTO student = new StudentDTO(k.getId(), k.getClass().getSimpleName(), k.getIme(), k.getPrezime(), k.getEmail(), k.getLozinka(), k.getPermissions(), brojIndeksa, k.getKorisnickoIme());
						return new ResponseEntity<StudentDTO>(student, HttpStatus.OK);
					} else if (k instanceof Nastavnik) {
						NastavnikDTO nastavnik = new NastavnikDTO(k.getClass().getSimpleName(), k.getId(), k.getKorisnickoIme(), k.getEmail(), k.getLozinka(),k.getIme(),k.getPrezime());
						return new ResponseEntity<NastavnikDTO>(nastavnik, HttpStatus.OK);
					} else if (k instanceof Administrator) {
						AdministratorDTO admin = new AdministratorDTO(k.getClass().getSimpleName(), k.getId(), k.getKorisnickoIme(), k.getLozinka(), k.getEmail(),k.getIme(),k.getPrezime());
						return new ResponseEntity<AdministratorDTO>(admin, HttpStatus.OK);
					}
					else if (k instanceof StudentskaSluzba) {
						StudentskaSluzbaDTO ss = new StudentskaSluzbaDTO(k.getId(), k.getClass().getSimpleName(), k.getKorisnickoIme(), k.getEmail(), k.getLozinka(),k.getIme(),k.getPrezime());
						return new ResponseEntity<StudentskaSluzbaDTO>(ss, HttpStatus.OK);
					}
					RegistrovaniKorisnikDTO korisnik = new RegistrovaniKorisnikDTO(k.getClass().getSimpleName(), k.getId(), k.getKorisnickoIme(), k.getEmail(), k.getLozinka(), k.getPermissions(),k.getIme(),k.getPrezime());
					return new ResponseEntity<RegistrovaniKorisnikDTO>(korisnik, HttpStatus.OK);

		}
		return new ResponseEntity<RegistrovaniKorisnikDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<RegistrovaniKorisnik> create(@RequestBody RegistrovaniKorisnik r) {
		try {
			service.save(r);
			return new ResponseEntity<RegistrovaniKorisnik>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<RegistrovaniKorisnik>(HttpStatus.BAD_REQUEST);
	}

	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'STUDENT_PERMISSION', 'NASTAVNIK_PERMISSION', 'KORISNIK_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RegistrovaniKorisnik> update(@PathVariable("id") Long id, @RequestBody RegistrovaniKorisnik korisnik, Authentication authentication) {
		if (authentication.isAuthenticated()) {
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			Long userId = userDetails.getId();

			if (id.equals(userId)) {
				RegistrovaniKorisnik u = service.findOne(id).orElse(null);
				if (u != null) {
					korisnik.setId(id);
					korisnik.setLozinka(korisnik.getLozinka());
					korisnik.setPermissions(u.getPermissions());
					korisnik = service.save(korisnik);
					return new ResponseEntity<RegistrovaniKorisnik>(korisnik, HttpStatus.OK);
				}
				return new ResponseEntity<RegistrovaniKorisnik>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<RegistrovaniKorisnik>(HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<RegistrovaniKorisnik> delete(@PathVariable("id") Long id) {
		if (service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<RegistrovaniKorisnik>(HttpStatus.OK);
		}
		return new ResponseEntity<RegistrovaniKorisnik>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path="/izmeniTip/{tip}", method = RequestMethod.PUT)
	public ResponseEntity<String> dodelaStatusa(@RequestBody Student Studnet,
			@PathVariable("tip") String tip) {
		boolean uspesno = service.promeniTipKorisnika(Studnet.getId(), tip);
		
		if (uspesno) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(tip,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasAnyAuthority('STUDENTSKASLUZBA_PERMISSION')")
	@RequestMapping(path="/{id}/dodeliStudenta", method = RequestMethod.PUT)
	public ResponseEntity<String> dodelaStudenta(@PathVariable("id") long korisnikId, @RequestBody StudentDTO noveInfStudneta) {
		boolean uspesno = false; 
		
		RegistrovaniKorisnik k = service.findOne(korisnikId).orElse(null);
		if (k != null) {
			if (k instanceof RegistrovaniKorisnik) {
				uspesno = service.upisStudenta(korisnikId, noveInfStudneta);
			}}
		if (uspesno) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	
}
