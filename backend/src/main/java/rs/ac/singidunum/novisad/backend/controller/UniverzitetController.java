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

import rs.ac.singidunum.novisad.backend.dto.RektoratDTO;
import rs.ac.singidunum.novisad.backend.dto.UniverzitetDTO;
import rs.ac.singidunum.novisad.backend.model.academic.Univerzitet;
import rs.ac.singidunum.novisad.backend.service.UniverzitetService;

@Controller
@RequestMapping(path = "/api/univerziteti")
@CrossOrigin(origins = "http://localhost:4200")
public class UniverzitetController {

	@Autowired
	private UniverzitetService service;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<UniverzitetDTO>> getAll(){
		HashSet<UniverzitetDTO> univerzitet = new HashSet<UniverzitetDTO>();
		for (Univerzitet u : service.findAll()) {
			RektoratDTO rektorat = new RektoratDTO(u.getRektorat().getId(), u.getRektorat().getNaziv(),
					u.getRektorat().getKontakt(), u.getRektorat().getSlika(), u.getRektorat().getAdresa(),
					u.getRektorat().getIme_rektora());
			univerzitet.add(new UniverzitetDTO(u.getId(), u.getNaziv(), u.getDatumOsnivanja(), u.getOpis() , u.getKontakt(),  u.getSlika(), u.getAdresa(), rektorat));
		}
		return new ResponseEntity<Iterable<UniverzitetDTO>>(univerzitet, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UniverzitetDTO> get(@PathVariable("id") Long id){
		Optional<Univerzitet> u = service.findOne(id);
		if(u.isPresent()) {
			RektoratDTO rektorat = new RektoratDTO(u.get().getRektorat().getId(), u.get().getRektorat().getNaziv(),
					u.get().getRektorat().getKontakt(), u.get().getRektorat().getSlika(), u.get().getRektorat().getAdresa(),
					u.get().getRektorat().getIme_rektora());
			UniverzitetDTO dto = new UniverzitetDTO(u.get().getId(), u.get().getNaziv(), u.get().getDatumOsnivanja(), u.get().getKontakt(), u.get().getOpis(),  u.get().getSlika(), u.get().getAdresa(), rektorat);
			return new ResponseEntity<UniverzitetDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<UniverzitetDTO>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Univerzitet> create(@RequestBody Univerzitet r){
		try {
			service.save(r);
			return new ResponseEntity<Univerzitet>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Univerzitet>(HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Univerzitet> update(@PathVariable("id") Long id, @RequestBody Univerzitet univerzitet){
		Univerzitet u = service.findOne(id).orElse(null);
		if(u != null) {
			univerzitet.setId(id);
			univerzitet.setRektorat(u.getRektorat());
			univerzitet = service.save(univerzitet);
			return new ResponseEntity<Univerzitet>(univerzitet, HttpStatus.OK);
		}
		return new ResponseEntity<Univerzitet>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Univerzitet> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<Univerzitet>(HttpStatus.OK);
		}
		return new ResponseEntity<Univerzitet>(HttpStatus.NOT_FOUND);
	}
}
