package rs.ac.singidunum.novisad.backend.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.singidunum.novisad.backend.model.Obavestenje;
import rs.ac.singidunum.novisad.backend.model.PredmetnaObavestenja;
import rs.ac.singidunum.novisad.backend.service.ObavestenjaService;

@Controller
@RequestMapping(path = "/api/obavestenja")
@CrossOrigin(origins = "http://localhost:4200")
public class ObavestenjeController {

	@Autowired
	private ObavestenjaService service;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Obavestenje>> getAll(){
		ArrayList<Obavestenje> obavestenja = new ArrayList<Obavestenje>();
		for (Obavestenje o : service.findAll()) {

			if(!(o instanceof PredmetnaObavestenja)) {
				obavestenja.add(new Obavestenje(o.getId(), o.getNaslov(), o.getSadrzaj(), o.getDatum(), o.getSlika(), o.getVremePocetka(), o.getVremeKraja()));
			}
		}
		return new ResponseEntity<Iterable<Obavestenje>>(obavestenja, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Obavestenje> get(@PathVariable("id") Long id){
		Optional<Obavestenje> o = service.findOne(id);
		if(o.isPresent()) {
			
			Obavestenje obavestenje = new Obavestenje(o.get().getId(), o.get().getNaslov(), o.get().getSadrzaj(), o.get().getDatum(), o.get().getSlika(), o.get().getVremePocetka(), o.get().getVremeKraja());
			return new ResponseEntity<Obavestenje>(obavestenje, HttpStatus.OK);
		}
		return new ResponseEntity<Obavestenje>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasAnyAuthority('STUDENTSKASLUZBA_PERMISSION')")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Obavestenje> create(@RequestBody Obavestenje r){
		try {
			r.setDatum(LocalDateTime.now());
			service.save(r);
			return new ResponseEntity<Obavestenje>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Obavestenje>(HttpStatus.BAD_REQUEST);
	}

	@PreAuthorize("hasAnyAuthority('STUDENTSKASLUZBA_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Obavestenje> update(@PathVariable("id") Long id, @RequestBody Obavestenje obavestenja){
		Obavestenje r = service.findOne(id).orElse(null);
		if(r != null) {
			obavestenja.setId(id);
			if(obavestenja.getSlika() == null || obavestenja.getSlika() == "") {
				obavestenja.setSlika(r.getSlika());
			}
			obavestenja.setDatum(LocalDateTime.now());
			obavestenja = service.save(obavestenja);
			return new ResponseEntity<Obavestenje>(obavestenja, HttpStatus.OK);
		}
		return new ResponseEntity<Obavestenje>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasAnyAuthority('STUDENTSKASLUZBA_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Obavestenje> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<Obavestenje>(HttpStatus.OK);
		}
		return new ResponseEntity<Obavestenje>(HttpStatus.NOT_FOUND);
	}
}
