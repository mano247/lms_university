package rs.ac.singidunum.novisad.backend.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;

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
import rs.ac.singidunum.novisad.backend.model.Rektorat;
import rs.ac.singidunum.novisad.backend.service.RektoratService;

@Controller
@RequestMapping(path = "/api/rektorati")
@CrossOrigin(origins = "http://localhost:4200")
public class RektoratController {
	@Autowired
	private RektoratService service;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<RektoratDTO>> getAll(){
		HashSet<RektoratDTO> rektorat = new HashSet<RektoratDTO>();
		for (Rektorat r : service.findAll()) {
			Set<UniverzitetDTO> univerziteti = r.getUniverziteti().stream().
					map(univerzitet -> new UniverzitetDTO(univerzitet.getId(), univerzitet.getNaziv(), univerzitet.getDatumOsnivanja(), univerzitet.getKontakt(), univerzitet.getAdresa() , univerzitet.getOpis(), univerzitet.getSlika())).
					collect(Collectors.toSet());
			rektorat.add(new RektoratDTO(r.getId(), r.getNaziv(), r.getKontakt(), r.getSlika(), r.getAdresa(),r.getIme_rektora(), univerziteti));
		}
		return new ResponseEntity<Iterable<RektoratDTO>>(rektorat, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RektoratDTO> get(@PathVariable("id") Long id){
		Optional<Rektorat> r = service.findOne(id);
		if(r.isPresent()) {
			Set<UniverzitetDTO> univerziteti = r.get().getUniverziteti().stream().
					map(univerzitet -> new UniverzitetDTO(univerzitet.getId(), univerzitet.getNaziv(), univerzitet.getDatumOsnivanja(), univerzitet.getKontakt(), univerzitet.getAdresa() , univerzitet.getOpis(), univerzitet.getSlika())).
					collect(Collectors.toSet());
			RektoratDTO dto = new RektoratDTO(r.get().getId(), r.get().getNaziv(), r.get().getKontakt(), r.get().getSlika(), r.get().getAdresa(),r.get().getIme_rektora(), univerziteti);
			return new ResponseEntity<RektoratDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<RektoratDTO>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Rektorat> create(@RequestBody Rektorat r){
		try {
			service.save(r);
			return new ResponseEntity<Rektorat>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Rektorat>(HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Rektorat> update(@PathVariable("id") Long id, @RequestBody Rektorat rektorat){
		Rektorat r = service.findOne(id).orElse(null);
		if(r != null) {
			rektorat.setId(id);
			rektorat = service.save(rektorat);
			return new ResponseEntity<Rektorat>(rektorat, HttpStatus.OK);
		}
		return new ResponseEntity<Rektorat>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Rektorat> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<Rektorat>(HttpStatus.OK);
		}
		return new ResponseEntity<Rektorat>(HttpStatus.NOT_FOUND);
	}
}
