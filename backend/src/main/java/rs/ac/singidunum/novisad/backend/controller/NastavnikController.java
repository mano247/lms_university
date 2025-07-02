package rs.ac.singidunum.novisad.backend.controller;

import java.util.Set;
import java.util.ArrayList;
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

import rs.ac.singidunum.novisad.backend.dto.NastavniMaterijalDTO;
import rs.ac.singidunum.novisad.backend.dto.NastavnikDTO;
import rs.ac.singidunum.novisad.backend.dto.PredmetProfesoraDTO;
import rs.ac.singidunum.novisad.backend.dto.StudentDTO;
import rs.ac.singidunum.novisad.backend.model.academic.Predmet;
import rs.ac.singidunum.novisad.backend.model.user.Nastavnik;
import rs.ac.singidunum.novisad.backend.security.services.UserDetailsImpl;
import rs.ac.singidunum.novisad.backend.service.NastavnikService;

@Controller
@RequestMapping(path = "/api/nastavnici")
@CrossOrigin(origins = "http://localhost:4200")
public class NastavnikController {
	@Autowired
	private NastavnikService service;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<NastavnikDTO>> getAll(){
		ArrayList<NastavnikDTO> profesori = new ArrayList<NastavnikDTO>();
		for (Nastavnik p : service.findAll()) {
			profesori.add(new NastavnikDTO(p.getClass().getSimpleName(), p.getId(), p.getKorisnickoIme(),  p.getEmail(), p.getLozinka(),p.getIme(), p.getPrezime()));
		}
		return new ResponseEntity<Iterable<NastavnikDTO>>(profesori, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<NastavnikDTO> get(@PathVariable("id") Long id){
		Optional<Nastavnik> p = service.findOne(id);
		if(p.isPresent()) {
			NastavnikDTO profesor = new NastavnikDTO(p.get().getClass().getSimpleName(), p.get().getId() ,p.get().getKorisnickoIme(), p.get().getEmail(), p.get().getLozinka(), p.get().getIme(), p.get().getPrezime());
			return new ResponseEntity<NastavnikDTO>(profesor, HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Nastavnik> create(@RequestBody Nastavnik r){
		try {
			service.save(r);
			return new ResponseEntity<Nastavnik>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Nastavnik>(HttpStatus.BAD_REQUEST);
	}

	@PreAuthorize("hasAnyAuthority('NASTAVNIK_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Nastavnik> update(@PathVariable("id") Long id, @RequestBody Nastavnik profesor, Authentication authentication){
		if(authentication.isAuthenticated()) {
		
				Nastavnik u = service.findOne(id).orElse(null);
				if(u != null && u.getUniverzitet()!= null) {
					profesor.setId(id);
					profesor.setUniverzitet(u.getUniverzitet());
					profesor.setLozinka(u.getLozinka());
					profesor.setPermissions(u.getPermissions());
					profesor = service.save(profesor);
					return new ResponseEntity<Nastavnik>(HttpStatus.OK);
				}else if (u != null) {
					profesor.setId(id);
					profesor.setLozinka(u.getLozinka());
					profesor.setPermissions(u.getPermissions());
					profesor = service.save(profesor);
					return new ResponseEntity<Nastavnik>(HttpStatus.OK);
				}

		}
		return  new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Nastavnik> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<Nastavnik>(HttpStatus.OK);
		}
		return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('NASTAVNIK_PERMISSION')")
	@RequestMapping(path = "/{id}/mojiPredmeti", method = RequestMethod.GET)
	public ResponseEntity<Set<PredmetProfesoraDTO>> getMojiPredmeti(@PathVariable("id") Long id, Authentication authentication){
		if (authentication.isAuthenticated()) {
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			Long userId = userDetails.getId();

			if(id.equals(userId)) {
				Optional<Nastavnik> p = service.findOne(id);
				Set<Predmet> predmeti = p.get().getPredmeti();
				
				if(p.isPresent()) {
					Set<PredmetProfesoraDTO> profPredmeti = predmeti.stream().map(pr -> new PredmetProfesoraDTO(
							pr.getId(),
							pr.getSifraPredmeta(),  
							pr.getSilabus(), 
							pr.getNaziv(),
							pr.getEspb(),
							new NastavnikDTO(pr.getNastavnik().getId(),pr.getNastavnik().getIme(),pr.getNastavnik().getPrezime()),
							pr.getVremePocetka(),
							pr.getVremeKraja(),
							pr.getOpis(),
							pr.getStudijskiProgram().getNaziv(),
							pr.getNastavniMaterijal().stream().map(nm -> new NastavniMaterijalDTO(nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getBrojStrana(), nm.getIzdavac(), nm.getOpis(),nm.getKolicina(),nm.getIzdato())).collect(Collectors.toSet()),
							pr.getStudenti().stream().map(st -> new StudentDTO(st.getId(),st.getEmail(),st.getKorisnickoIme(),st.getBrojIndeksa(),st.getIme(),st.getPrezime(),st.getFakultet())).collect(Collectors.toSet())
					)).collect(Collectors.toSet());


					return new ResponseEntity<Set<PredmetProfesoraDTO>>(profPredmeti, HttpStatus.OK);
				}
			}

		}
		return new ResponseEntity<Set<PredmetProfesoraDTO>>(HttpStatus.NOT_FOUND);
	}
}
