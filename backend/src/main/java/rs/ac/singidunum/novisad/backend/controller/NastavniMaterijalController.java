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

import rs.ac.singidunum.novisad.backend.dto.NastavniMaterijalDTO;
import rs.ac.singidunum.novisad.backend.model.academic.NastavniMaterijal;
import rs.ac.singidunum.novisad.backend.service.NastavniMaterijalService;

@Controller
@RequestMapping(path = "/api/nastavnimaterijal")
@CrossOrigin(origins = "http://localhost:4200")
public class NastavniMaterijalController {
	@Autowired
	private NastavniMaterijalService service;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<NastavniMaterijalDTO>> getAll(){
		HashSet<NastavniMaterijalDTO> nastavniMaterijal = new HashSet<NastavniMaterijalDTO>();
		for (NastavniMaterijal nm : service.findAll()) {
			nastavniMaterijal.add(new NastavniMaterijalDTO(
					nm.getId(), 
					nm.getNaslov(), 
					nm.getAutori(), 
					nm.getGodinaIzdavanja(), 
					nm.getIzdavac(), 
					nm.getOpis(), 
					nm.getUrl(), 
					nm.getIshod(),
					nm.getKolicina(),
					nm.getIzdato()));
			
		}
		return new ResponseEntity<Iterable<NastavniMaterijalDTO>>(nastavniMaterijal, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<NastavniMaterijalDTO> get(@PathVariable("id") Long id){
		Optional<NastavniMaterijal> nm = service.findOne(id);
		if(nm.isPresent()) {
			NastavniMaterijalDTO dto = new  NastavniMaterijalDTO(
					nm.get().getId(), 
					nm.get().getNaslov(), 
					nm.get().getAutori(), 
					nm.get().getGodinaIzdavanja(), 
					nm.get().getIzdavac(), 
					nm.get().getOpis(), 
					nm.get().getUrl(), 
					nm.get().getIshod(),
					nm.get().getKolicina(),
					nm.get().getIzdato());
			return new ResponseEntity<NastavniMaterijalDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<NastavniMaterijalDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<NastavniMaterijal> create(@RequestBody NastavniMaterijal r){
		try {
			service.save(r);
			return new ResponseEntity<NastavniMaterijal>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<NastavniMaterijal>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<NastavniMaterijal> update(@PathVariable("id") Long id, @RequestBody NastavniMaterijal NastavniMaterijal){
		NastavniMaterijal u = service.findOne(id).orElse(null);
		if(u != null) {
			NastavniMaterijal.setId(id);
			NastavniMaterijal = service.save(NastavniMaterijal);
			return new ResponseEntity<NastavniMaterijal>(NastavniMaterijal, HttpStatus.OK);
		}
		return new ResponseEntity<NastavniMaterijal>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<NastavniMaterijal> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<NastavniMaterijal>(HttpStatus.OK);
		}
		return new ResponseEntity<NastavniMaterijal>(HttpStatus.NOT_FOUND);
	}
}

