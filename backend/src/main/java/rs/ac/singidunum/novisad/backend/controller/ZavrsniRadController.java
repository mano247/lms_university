package rs.ac.singidunum.novisad.backend.controller;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.singidunum.novisad.backend.dto.NastavnikDTO;
import rs.ac.singidunum.novisad.backend.dto.StudentDTO;
import rs.ac.singidunum.novisad.backend.dto.ZavrsniRadDTO;
import rs.ac.singidunum.novisad.backend.model.ZavrsniRad;
import rs.ac.singidunum.novisad.backend.model.user.Nastavnik;
import rs.ac.singidunum.novisad.backend.model.user.Student;
import rs.ac.singidunum.novisad.backend.service.ZavrsniRadService;

@Controller
@RequestMapping(path = "/api/zavrsniRad")
@CrossOrigin(origins = "http://localhost:4200")
public class ZavrsniRadController {
	@Autowired
	private ZavrsniRadService service;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<ZavrsniRadDTO>> getAll(){
		HashSet<ZavrsniRadDTO> zavrsniRad = new HashSet<ZavrsniRadDTO>();
		for (ZavrsniRad z : service.findAll()) {
			Student st = z.getStudent();
			Nastavnik n = z.getMentor();
			
			StudentDTO student = new StudentDTO(st.getId(),st.getIme(),st.getPrezime(),st.getEmail(),st.getLozinka(),st.getBrojIndeksa(),st.getKorisnickoIme());
			NastavnikDTO mentor = new NastavnikDTO(n.getId(),null,n.getIme(),n.getPrezime(),n.getEmail(),n.getLozinka());	
			
			zavrsniRad.add(new ZavrsniRadDTO(z.getId(),z.getTema(),z.getLink(),student,mentor));
		}
		return new ResponseEntity<Iterable<ZavrsniRadDTO>>(zavrsniRad, HttpStatus.OK);
		}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ZavrsniRadDTO> get(@PathVariable("id") Long id) {
		Optional<ZavrsniRad> z = service.findOne(id);
		if(z.isPresent()) {
			Student st = z.get().getStudent();
			Nastavnik n = z.get().getMentor();
			
			StudentDTO student = new StudentDTO(st.getId(),st.getIme(),st.getPrezime(),st.getEmail(),st.getLozinka(),st.getBrojIndeksa(),st.getKorisnickoIme());
			NastavnikDTO mentor = new NastavnikDTO(n.getId(),null,n.getIme(),n.getPrezime(),n.getEmail(),n.getLozinka());	


			ZavrsniRadDTO zavrsniRad = new ZavrsniRadDTO(z.get().getId(),z.get().getTema(),z.get().getLink(),student,mentor);
			return new ResponseEntity<ZavrsniRadDTO>(zavrsniRad, HttpStatus.OK);
		}
		return new ResponseEntity<ZavrsniRadDTO>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(path = "/fbs/{id}", method = RequestMethod.GET)
	public ResponseEntity<ZavrsniRadDTO> findByStundet(@PathVariable("id") Long id){
		for (ZavrsniRad z : service.findAll()) {
			Student st = z.getStudent();
			if (id == st.getId()) {
				Nastavnik n = z.getMentor();
				
				StudentDTO student = new StudentDTO(st.getId(),st.getIme(),st.getPrezime(),st.getEmail(),st.getLozinka(),st.getBrojIndeksa(),st.getKorisnickoIme());
				NastavnikDTO mentor = new NastavnikDTO(n.getId(),null,n.getIme(),n.getPrezime(),n.getEmail(),n.getLozinka());	
				
				ZavrsniRadDTO zr = new ZavrsniRadDTO(z.getId(),z.getTema(),z.getLink(),student,mentor);
				return new ResponseEntity<ZavrsniRadDTO>(zr, HttpStatus.OK);
		}
			}
		return new ResponseEntity<ZavrsniRadDTO>(HttpStatus.NOT_FOUND);
		}
	
	@RequestMapping(path = "/fbm/{id}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<ZavrsniRadDTO>> findByMentor(@PathVariable("id") Long id){
		HashSet<ZavrsniRadDTO> zavrsniRad = new HashSet<ZavrsniRadDTO>();
		for (ZavrsniRad z : service.findAll()) {
			Nastavnik n = z.getMentor();
			if (id == n.getId()) {
				Student st = z.getStudent();
				
				StudentDTO student = new StudentDTO(st.getId(),st.getIme(),st.getPrezime(),st.getEmail(),st.getLozinka(),st.getBrojIndeksa(),st.getKorisnickoIme());
				NastavnikDTO mentor = new NastavnikDTO(n.getId(),null,n.getIme(),n.getPrezime(),n.getEmail(),n.getLozinka());	
				
				zavrsniRad.add(new ZavrsniRadDTO(z.getId(),z.getTema(),z.getLink(),student,mentor));
		}
			}
		return new ResponseEntity<Iterable<ZavrsniRadDTO>>(zavrsniRad, HttpStatus.OK);
		}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ZavrsniRad> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<ZavrsniRad>(HttpStatus.OK);
		}
		return new ResponseEntity<ZavrsniRad>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ZavrsniRad> update(@PathVariable("id") Long id, @RequestBody ZavrsniRad zavrsniRad){
		ZavrsniRad sng = service.findOne(id).orElse(null);

		if(sng != null) {
			zavrsniRad.setId(id);
			zavrsniRad = service.save(zavrsniRad);
			return new ResponseEntity<ZavrsniRad>(zavrsniRad, HttpStatus.OK);
				}
		return new ResponseEntity<ZavrsniRad>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<ZavrsniRad> create(@RequestBody ZavrsniRad zavrsniRad){
		for (ZavrsniRad z : service.findAll()) {
			if(z.getStudent().getId().equals(zavrsniRad.getStudent().getId())) {
				return new ResponseEntity<ZavrsniRad>(HttpStatus.CONFLICT);
			}
		}
		
		try {
			service.save(zavrsniRad);
			return new ResponseEntity<ZavrsniRad>(zavrsniRad, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ZavrsniRad>(HttpStatus.BAD_REQUEST);
	}

}
