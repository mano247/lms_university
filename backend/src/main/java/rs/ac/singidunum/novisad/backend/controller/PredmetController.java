package rs.ac.singidunum.novisad.backend.controller;

import java.util.ArrayList;
import java.util.Set;
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
import rs.ac.singidunum.novisad.backend.dto.PredmetDTO;
import rs.ac.singidunum.novisad.backend.dto.StudijskiProgramDTO;
import rs.ac.singidunum.novisad.backend.model.academic.Predmet;
import rs.ac.singidunum.novisad.backend.security.services.UserDetailsImpl;
import rs.ac.singidunum.novisad.backend.service.PredmetService;

@Controller
@RequestMapping(path = "/api/predmeti")
@CrossOrigin(origins = "http://localhost:4200")
public class PredmetController {
	@Autowired
	private PredmetService service;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PredmetDTO>> getAll() {
		ArrayList<PredmetDTO> predmeti = new ArrayList<PredmetDTO>();
		for (Predmet p : service.findAll()) {
			Set<NastavniMaterijalDTO> nastavniMaterijal = p.getNastavniMaterijal().stream().map(nm -> new NastavniMaterijalDTO(
					nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getBrojStrana(), nm.getIzdavac(), nm.getOpis(),
					nm.getKolicina(),
					nm.getIzdato()
			)).collect(Collectors.toSet());
			predmeti.add(new PredmetDTO(p.getId(),p.getSifraPredmeta(), 
					new StudijskiProgramDTO(p.getStudijskiProgram().getId(),p.getStudijskiProgram().getSifraSP(),p.getStudijskiProgram().getNaziv()), 
					p.getSilabus(),p.getNaziv(),p.getEspb(), 
						new NastavnikDTO(p.getNastavnik().getId(),p.getNastavnik().getIme(),p.getNastavnik().getPrezime())
						, p.getVremePocetka(),p.getVremeKraja(), p.getOpis(),nastavniMaterijal));
		}
		return new ResponseEntity<Iterable<PredmetDTO>>(predmeti, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PredmetDTO> getById(@PathVariable("id") Long id){
		Optional<Predmet> p = service.findOne(id);
		if(p.isPresent()) {
			Set<NastavniMaterijalDTO> nastavniMaterijal = p.get().getNastavniMaterijal().stream().map(nm -> new NastavniMaterijalDTO(
					nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getBrojStrana(), nm.getIzdavac(), nm.getOpis(),
					nm.getKolicina(),
					nm.getIzdato()
			)).collect(Collectors.toSet());
			try {
				PredmetDTO dto = new PredmetDTO(p.get().getId(),p.get().getSifraPredmeta(),
						new StudijskiProgramDTO(p.get().getStudijskiProgram().getId(),p.get().getStudijskiProgram().getSifraSP(),p.get().getStudijskiProgram().getNaziv()),p.get().getSilabus(), p.get().getNaziv(),p.get().getEspb(), new NastavnikDTO(p.get().getNastavnik().getId(),p.get().getNastavnik().getIme(),p.get().getNastavnik().getPrezime()),p.get().getVremePocetka(),p.get().getVremeKraja() , p.get().getOpis(), nastavniMaterijal);
				return new ResponseEntity<PredmetDTO>(dto, HttpStatus.OK);
			} catch (Exception e) {
				PredmetDTO dto = new PredmetDTO(p.get().getId(),p.get().getSifraPredmeta(),
						new StudijskiProgramDTO(p.get().getStudijskiProgram().getId(),p.get().getStudijskiProgram().getSifraSP(),p.get().getStudijskiProgram().getNaziv()),p.get().getSilabus(), p.get().getNaziv(),p.get().getEspb(),null,p.get().getVremePocetka(),p.get().getVremeKraja() , p.get().getOpis(), nastavniMaterijal);
				return new ResponseEntity<PredmetDTO>(dto, HttpStatus.OK);
			}
		}
		return new ResponseEntity<PredmetDTO>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/s/{sifraPredmeta}", method = RequestMethod.GET)
	public ResponseEntity<PredmetDTO> getSifraPredmeta(@PathVariable("sifraPredmeta") String sifraPredmeta){
		Optional<Predmet> p = service.findBysifraPredmeta(sifraPredmeta);
		if(p.isPresent()) {
			Set<NastavniMaterijalDTO> nastavniMaterijal = p.get().getNastavniMaterijal().stream().map(nm -> new NastavniMaterijalDTO(
					nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getBrojStrana(), nm.getIzdavac(), nm.getOpis(),
					nm.getKolicina(),
					nm.getIzdato(),
					nm.getGodinaIzdavanja()
			)).collect(Collectors.toSet());
			
			PredmetDTO dto = new PredmetDTO(
					p.get().getId(),
					p.get().getSifraPredmeta(), 
					new StudijskiProgramDTO(p.get().getStudijskiProgram().getId(),p.get().getStudijskiProgram().getSifraSP(),p.get().getStudijskiProgram().getNaziv()),
					p.get().getSilabus(), 					
					p.get().getNaziv(),
					p.get().getEspb(),
					new NastavnikDTO(p.get().getNastavnik().getId(),p.get().getNastavnik().getIme(),p.get().getNastavnik().getPrezime()) ,
					p.get().getVremePocetka(),
					p.get().getVremeKraja(),
					p.get().getOpis(),
					nastavniMaterijal);
			return new ResponseEntity<PredmetDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<PredmetDTO>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Predmet> create(@RequestBody Predmet p){
		try {
			service.save(p);
			return new ResponseEntity<Predmet>(p, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Predmet>(HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Predmet> update(@PathVariable("id") Long id, @RequestBody Predmet predmet){
		Predmet p = service.findOne(id).orElse(null);
		if(p != null) {
			predmet.setId(id);
			predmet = service.save(predmet);
			return new ResponseEntity<Predmet>(HttpStatus.OK);
		}
		return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Predmet> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<Predmet>(HttpStatus.OK);
		}
		return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('STUDENTSKASLUZBA_PERMISSION')")
	@RequestMapping(path = "/{id}/dodajNastavnika", method = RequestMethod.POST)
	public ResponseEntity<Predmet> dodeliNastavnikaPredmetu(@PathVariable("id") Long id, @RequestBody Predmet predmet){
		Predmet p = service.findOne(id).orElse(null);
		if(p != null) {
			predmet.setId(id);
			p.setNastavnik(predmet.getNastavnik());
			p = service.save(p);
			return new ResponseEntity<Predmet>(HttpStatus.OK);
		}
		return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasAnyAuthority('NASTAVNIK_PERMISSION')")
	@RequestMapping(path = "/{id}/izmeniSilabus", method = RequestMethod.PUT)
	public ResponseEntity<Predmet> izmenaSilabusaPredmeta(@PathVariable("id") Long id, @RequestBody Predmet predmet, Authentication authentication){
		if(authentication.isAuthenticated()) {
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			Long userId = userDetails.getId();
			Predmet p = service.findOne(id).orElse(null);
			if(p.getNastavnik().getId().equals(userId)) {
				
				if(p != null) {
					predmet.setId(id);
					predmet.setSifraPredmeta(p.getSifraPredmeta());
					predmet.setNaziv(p.getNaziv());
					predmet.setEspb(p.getEspb());
					predmet.setOpis(p.getOpis());
					predmet.setSilabus(predmet.getSilabus());
					predmet.setNastavniMaterijal(p.getNastavniMaterijal());
					predmet.setStudijskiProgram(p.getStudijskiProgram());
					predmet.setNastavnik(p.getNastavnik());
					predmet.setStudenti(p.getStudenti());
					predmet.setPolaganje(p.getPolaganje());
					predmet.setObavestenja(p.getObavestenja());
					predmet.setVremeKraja(p.getVremeKraja());
					predmet.setVremePocetka(p.getVremePocetka());
					predmet = service.save(predmet);
					return new ResponseEntity<Predmet>(HttpStatus.OK);
				}
			}
		
		}
		return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
	}
	

}
