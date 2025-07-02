package rs.ac.singidunum.novisad.backend.controller;

import java.util.HashSet;
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

import rs.ac.singidunum.novisad.backend.dto.FakultetDTO;
import rs.ac.singidunum.novisad.backend.dto.UniverzitetDTO;
import rs.ac.singidunum.novisad.backend.model.academic.Fakultet;
import rs.ac.singidunum.novisad.backend.service.FakultetService;


@Controller
@RequestMapping(path = "/api/fakulteti")
@CrossOrigin(origins = "http://localhost:4200")
public class FakultetController {
	@Autowired
	private FakultetService service;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<FakultetDTO>> getAll(){
		HashSet<FakultetDTO> fakultet = new HashSet<FakultetDTO>();
		for (Fakultet f : service.findAll()) {
			fakultet.add(new FakultetDTO(f.getId(), f.getSifraFakulteta(), f.getNaziv(), f.getKontakt(), f.getTekstualniOpis(), f.getDekan(), f.getSlika(), f.getAdresa(), new UniverzitetDTO(f.getUniverzitet().getId(),f.getUniverzitet().getNaziv())));
		}
		return new ResponseEntity<Iterable<FakultetDTO>>(fakultet, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FakultetDTO> get(@PathVariable("id") Long id){
		Optional<Fakultet> f = service.findOne(id);
		if(f.isPresent()) {
			FakultetDTO dto = new FakultetDTO(f.get().getId(),f.get().getSifraFakulteta(),  f.get().getNaziv(), f.get().getKontakt(), f.get().getTekstualniOpis(), f.get().getDekan(), f.get().getSlika(), f.get().getAdresa(), new UniverzitetDTO(f.get().getUniverzitet().getId(),f.get().getUniverzitet().getNaziv()));
			return new ResponseEntity<FakultetDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<FakultetDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/s/{sifraFakulteta}", method = RequestMethod.GET)
	public ResponseEntity<FakultetDTO> get(@PathVariable("sifraFakulteta") String sifraFakulteta){
		Optional<Fakultet> f = service.findBySifra(sifraFakulteta);
		if(f.isPresent()) {
			FakultetDTO dto = new FakultetDTO(f.get().getId(),f.get().getSifraFakulteta(),  f.get().getNaziv(), f.get().getKontakt(), f.get().getTekstualniOpis(), f.get().getDekan(), f.get().getSlika(), f.get().getAdresa(), new UniverzitetDTO(f.get().getUniverzitet().getId(),f.get().getUniverzitet().getNaziv()));
			return new ResponseEntity<FakultetDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<FakultetDTO>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Fakultet> create(@RequestBody Fakultet r){
		try {
			service.save(r);
			return new ResponseEntity<Fakultet>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Fakultet>(HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Fakultet> update(@PathVariable("id") Long id, @RequestBody Fakultet fakultet){
		Fakultet u = service.findOne(id).orElse(null);
		
		if(u != null) {
			fakultet.setId(id);
			fakultet = service.save(fakultet);
			
			return new ResponseEntity<Fakultet>(HttpStatus.OK);
		}
		return new ResponseEntity<Fakultet>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Fakultet> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<Fakultet>(HttpStatus.OK);
		}
		return new ResponseEntity<Fakultet>(HttpStatus.NOT_FOUND);
	}
}

