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

import rs.ac.singidunum.novisad.backend.dto.KancelariskiMaterijalDTO;
import rs.ac.singidunum.novisad.backend.model.KancelariskiMaterijal;
import rs.ac.singidunum.novisad.backend.service.KancelariskiMaterialService;

@Controller
@RequestMapping(path = "/api/kancelariskiMaterial")
@CrossOrigin(origins = "http://localhost:4200")
public class KancelariskiMaterijalController {
	@Autowired
	private KancelariskiMaterialService service;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<KancelariskiMaterijalDTO>> getAll(){
		HashSet<KancelariskiMaterijalDTO> kancelariskiaMaterial = new HashSet<KancelariskiMaterijalDTO>();
		for (KancelariskiMaterijal k : service.findAll()) {
			kancelariskiaMaterial.add(new KancelariskiMaterijalDTO(k.getId(),k.getNaziv(),k.getKolicina(),k.getIzdato()));
		}
		return new ResponseEntity<Iterable<KancelariskiMaterijalDTO>>(kancelariskiaMaterial, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<KancelariskiMaterijalDTO> get(@PathVariable("id") Long id){
		Optional<KancelariskiMaterijal> k = service.findOne(id);
		if(k.isPresent()) {
			KancelariskiMaterijalDTO dto = new KancelariskiMaterijalDTO(k.get().getId(),k.get().getNaziv(),k.get().getKolicina(),k.get().getIzdato());
			return new ResponseEntity<KancelariskiMaterijalDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<KancelariskiMaterijalDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<KancelariskiMaterijal> create(@RequestBody KancelariskiMaterijal kr){
		try {
			service.save(kr);
			return new ResponseEntity<KancelariskiMaterijal>(kr, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<KancelariskiMaterijal>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<KancelariskiMaterijal> update(@PathVariable("id") Long id, @RequestBody KancelariskiMaterijal kancelariskiMaterijal){
		KancelariskiMaterijal u = service.findOne(id).orElse(null);
		
		if(u != null) {
			kancelariskiMaterijal.setId(id);
			kancelariskiMaterijal = service.save(kancelariskiMaterijal);
			return new ResponseEntity<KancelariskiMaterijal>(kancelariskiMaterijal, HttpStatus.OK);
		}
		return new ResponseEntity<KancelariskiMaterijal>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<KancelariskiMaterijal> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<KancelariskiMaterijal>(HttpStatus.OK);
		}
		return new ResponseEntity<KancelariskiMaterijal>(HttpStatus.NOT_FOUND);
	}
}
