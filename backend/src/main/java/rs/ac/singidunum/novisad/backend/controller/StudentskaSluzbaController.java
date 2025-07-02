package rs.ac.singidunum.novisad.backend.controller;

import java.util.HashSet;
import java.util.Optional;

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

import rs.ac.singidunum.novisad.backend.model.user.StudentskaSluzba;
import rs.ac.singidunum.novisad.backend.service.StudentskaSluzbaService;

@Controller
@RequestMapping(path = "/api/studentskaSluzba")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentskaSluzbaController {
	@Autowired
	private StudentskaSluzbaService service;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<StudentskaSluzba>> getAll(){
		HashSet<StudentskaSluzba> ss = new HashSet<StudentskaSluzba>();
		for (StudentskaSluzba s : service.findAll()) {
			ss.add(new StudentskaSluzba(s.getId(),s.getIme(),s.getPrezime(),s.getKorisnickoIme(),s.getEmail(), s.getLozinka(),s.getPermissions()));
		}
		return new ResponseEntity<Iterable<StudentskaSluzba>>(ss, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentskaSluzba> get(@PathVariable("id") Long id){
		Optional<StudentskaSluzba> s = service.findOne(id);
		if(s.isPresent()) {
			StudentskaSluzba studentskaSluzba = new StudentskaSluzba(
					s.get().getId(),
					s.get().getIme(),
					s.get().getPrezime(),
					s.get().getKorisnickoIme(),
					s.get().getEmail(), 
					s.get().getLozinka(),
					s.get().getPermissions());
			return new ResponseEntity<StudentskaSluzba>(studentskaSluzba, HttpStatus.OK);
		}
		return new ResponseEntity<StudentskaSluzba>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<StudentskaSluzba> create(@RequestBody StudentskaSluzba r){
		try {
			service.save(r);
			return new ResponseEntity<StudentskaSluzba>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<StudentskaSluzba>(HttpStatus.BAD_REQUEST);
	}

	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION','STUDENTSKASLUZBA_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StudentskaSluzba> update(@PathVariable("id") Long id, @RequestBody StudentskaSluzba studentskaSluzba, Authentication authentication){
		if (authentication.isAuthenticated()) {
				StudentskaSluzba u = service.findOne(id).orElse(null);
				if(u != null) {
					studentskaSluzba.setId(id);
					studentskaSluzba.setPermissions(u.getPermissions());
					studentskaSluzba.setLozinka(u.getLozinka());
					studentskaSluzba = service.save(studentskaSluzba);
					return new ResponseEntity<StudentskaSluzba>(studentskaSluzba, HttpStatus.OK);
				}
		}
		return new ResponseEntity<StudentskaSluzba>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentskaSluzba> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<StudentskaSluzba>(HttpStatus.OK);
		}
		return new ResponseEntity<StudentskaSluzba>(HttpStatus.NOT_FOUND);
	}
}
