package rs.ac.singidunum.novisad.backend.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
import rs.ac.singidunum.novisad.backend.dto.PredmetnaObavestenjaDTO;
import rs.ac.singidunum.novisad.backend.dto.StudijskiProgramDTO;
import rs.ac.singidunum.novisad.backend.model.academic.Predmet;
import rs.ac.singidunum.novisad.backend.model.PredmetnaObavestenja;
import rs.ac.singidunum.novisad.backend.model.user.Student;
import rs.ac.singidunum.novisad.backend.security.services.UserDetailsImpl;
import rs.ac.singidunum.novisad.backend.service.PredmetService;
import rs.ac.singidunum.novisad.backend.service.PredmetnaObavestenjaService;

@Controller
@RequestMapping(path = "/api/predmetnaObavestenja")
@CrossOrigin(origins = "http://localhost:4200")
public class PredmetnaObavestenjaController {
	@Autowired
	private PredmetnaObavestenjaService service;
	
	@Autowired
	private PredmetService predmetService;

	
	@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'NASTAVNIK_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PredmetnaObavestenjaDTO>> getAll(Authentication authentication){
		if (authentication.isAuthenticated()) {
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			Long userId = userDetails.getId();
			 
			ArrayList<PredmetnaObavestenjaDTO> predmetnaObavestenja = new ArrayList<PredmetnaObavestenjaDTO>();
			for (PredmetnaObavestenja o : service.findAll()) {
		
				PredmetDTO predmet = new PredmetDTO(o.getPredmet().getId(),o.getPredmet().getSifraPredmeta(), o.getPredmet().getSilabus(), o.getPredmet().getNaziv(), o.getPredmet().getEspb(),
						new NastavnikDTO(o.getPredmet().getNastavnik().getId(),o.getPredmet().getNastavnik().getIme(),o.getPredmet().getNastavnik().getPrezime()), o.getPredmet().getVremePocetka(), o.getPredmet().getVremeKraja(),
						o.getPredmet().getOpis(), o.getPredmet().getNastavniMaterijal().stream().map(
								nm -> new NastavniMaterijalDTO(nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getGodinaIzdavanja(), nm.getIzdavac(), nm.getOpis(), nm.getUrl(), nm.getIshod(), nm.getKolicina(), nm.getIzdato()
								)).collect(Collectors.toSet()));
			
				Optional<Predmet> pr = predmetService.findOne(o.getPredmet().getId());
				List<Long> id = new ArrayList<>();
				for(Student s: pr.get().getStudenti()) {
					id.add(s.getId());
				}

				if (id.contains(userId)) {
					
					predmetnaObavestenja.add(new PredmetnaObavestenjaDTO(o.getId(), o.getNaslov(), o.getSadrzaj(), o.getDatum(), o.getSlika(), predmet, o.getVremePocetka(), o.getVremeKraja()));
				}else if(pr.get().getNastavnik().getId() == userId) {
					predmetnaObavestenja.add(new PredmetnaObavestenjaDTO(o.getId(), o.getNaslov(), o.getSadrzaj(), o.getDatum(), o.getSlika(), predmet, o.getVremePocetka(), o.getVremeKraja()));

				}
				
			}
			return new ResponseEntity<Iterable<PredmetnaObavestenjaDTO>>(predmetnaObavestenja, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'NASTAVNIK_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PredmetnaObavestenjaDTO> get(@PathVariable("id") Long id){
		Optional<PredmetnaObavestenja> o = service.findOne(id);
		if(o.isPresent()) {
			PredmetDTO predmet = new PredmetDTO(
					o.get().getPredmet().getId(),
					o.get().getPredmet().getSifraPredmeta(),
					new StudijskiProgramDTO(o.get().getPredmet().getStudijskiProgram().getId(),o.get().getPredmet().getStudijskiProgram().getSifraSP(),o.get().getPredmet().getStudijskiProgram().getNaziv()),
					o.get().getPredmet().getSilabus(),
					o.get().getPredmet().getNaziv(),
					o.get().getPredmet().getEspb(),
					new NastavnikDTO(o.get().getPredmet().getNastavnik().getId(),o.get().getPredmet().getNastavnik().getIme(),o.get().getPredmet().getNastavnik().getPrezime()),
					o.get().getPredmet().getVremePocetka(), 
					o.get().getPredmet().getVremeKraja(), 
					o.get().getPredmet().getOpis(), 
					o.get().getPredmet().getNastavniMaterijal().stream().map(nm -> new NastavniMaterijalDTO(nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getGodinaIzdavanja(), nm.getIzdavac(), nm.getOpis(), nm.getUrl(), nm.getIshod(), nm.getKolicina(), nm.getIzdato()
									)).collect(Collectors.toSet()));

			PredmetnaObavestenjaDTO obavestenje = new PredmetnaObavestenjaDTO(o.get().getId(), o.get().getNaslov(), o.get().getSadrzaj(), o.get().getDatum(), o.get().getSlika(), predmet, o.get().getVremePocetka(), o.get().getVremeKraja());
			return new ResponseEntity<PredmetnaObavestenjaDTO>(obavestenje, HttpStatus.OK);
		}
		return new ResponseEntity<PredmetnaObavestenjaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('NASTAVNIK_PERMISSION')")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<PredmetnaObavestenja> create(@RequestBody PredmetnaObavestenja r, Authentication authentication){
			if (authentication.isAuthenticated()) {
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				Long userId = userDetails.getId();

				Optional<Predmet> p = predmetService.findOne(r.getPredmet().getId());

				if(p.get().getNastavnik().getId().equals(userId)) {
					r.setSlika("");
					r.setDatum(LocalDateTime.now());
					service.save(r);
					return new ResponseEntity<PredmetnaObavestenja>(r, HttpStatus.CREATED);
				}
			}
		return new ResponseEntity<PredmetnaObavestenja>(HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasAnyAuthority('NASTAVNIK_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PredmetnaObavestenja> update(@PathVariable("id") Long id, @RequestBody PredmetnaObavestenja predmetnaObavestenja, Authentication authentication){

		if (authentication.isAuthenticated()) {
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			Long userId = userDetails.getId();

			Optional<Predmet> p = predmetService.findOne(service.findOne(id).get().getPredmet().getId());

			if (p.get().getNastavnik().getId().equals(userId)) {
				PredmetnaObavestenja obavestenjeZaIzmenu = service.findOne(id).orElse(null);
				if(obavestenjeZaIzmenu != null) {
					obavestenjeZaIzmenu.setId(id);
					obavestenjeZaIzmenu.setNaslov(predmetnaObavestenja.getNaslov());
					obavestenjeZaIzmenu.setSadrzaj(predmetnaObavestenja.getSadrzaj());
					obavestenjeZaIzmenu.setDatum(LocalDateTime.now());
					obavestenjeZaIzmenu.setSlika("");
					obavestenjeZaIzmenu.setPredmet(obavestenjeZaIzmenu.getPredmet());
					@SuppressWarnings("unused")
					PredmetnaObavestenja izmenjenoObavestenje = service.save(obavestenjeZaIzmenu);
					return new ResponseEntity<PredmetnaObavestenja>(HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<PredmetnaObavestenja>(HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasAnyAuthority('NASTAVNIK_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PredmetnaObavestenja> delete(@PathVariable("id") Long id, Authentication authentication) {

		if (authentication.isAuthenticated()) {
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			Long userId = userDetails.getId();

			Optional<Predmet> p = predmetService.findOne(service.findOne(id).get().getPredmet().getId());

			if(p.get().getNastavnik().getId().equals(userId)) {

				if (service.findOne(id).isPresent()) {
					service.delete(id);
					return new ResponseEntity<PredmetnaObavestenja>(HttpStatus.OK);
				}
			}


		}
		return new ResponseEntity<PredmetnaObavestenja>(HttpStatus.NOT_FOUND);
	}

@PreAuthorize("hasAnyAuthority('STUDENT_PERMISSION', 'STUDENTSKASLUZBA_PERMISSION', 'NASTAVNIK_PERMISSION', 'ADMINISTRATOR_PERMISSION')")
@RequestMapping(path = "gbp/{id}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PredmetnaObavestenjaDTO>> getByPredmet(@PathVariable("id") Long id, Authentication authentication){

		 
		ArrayList<PredmetnaObavestenjaDTO> predmetnaObavestenja = new ArrayList<PredmetnaObavestenjaDTO>();
		for (PredmetnaObavestenja o : service.findAll()) {
			
			if (authentication.isAuthenticated()) {
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				Long userId = userDetails.getId();
				if (o.getPredmet().getId().equals(id)) {
					PredmetDTO predmet = new PredmetDTO(
							o.getPredmet().getId(),
							o.getPredmet().getSifraPredmeta(), 
							o.getPredmet().getSilabus(), 
							o.getPredmet().getNaziv(), 
							o.getPredmet().getEspb(),
							new NastavnikDTO(o.getPredmet().getNastavnik().getId(),o.getPredmet().getNastavnik().getIme(),o.getPredmet().getNastavnik().getPrezime()), o.getPredmet().getVremePocetka(), o.getPredmet().getVremeKraja(),
							o.getPredmet().getOpis(), 
							o.getPredmet().getNastavniMaterijal()
							.stream()
							.map( nm -> new NastavniMaterijalDTO(nm.getId(), nm.getNaslov(), nm.getAutori(), nm.getGodinaIzdavanja(), nm.getIzdavac(), nm.getOpis(), nm.getUrl(), nm.getIshod(), nm.getKolicina(), nm.getIzdato()
									)).collect(Collectors.toSet()));
				
					Optional<Predmet> pr = predmetService.findOne(o.getPredmet().getId());
					List<Long> idlist = new ArrayList<>();
					for(Student s: pr.get().getStudenti()) {
						idlist.add(s.getId());
					}
		
					if (idlist.contains(userId)) {
						predmetnaObavestenja.add(new PredmetnaObavestenjaDTO(o.getId(), o.getNaslov(), o.getSadrzaj(), o.getDatum(), o.getSlika(), predmet, o.getVremePocetka(), o.getVremeKraja()));
					}else if(pr.get().getNastavnik().getId() == userId) {
						predmetnaObavestenja.add(new PredmetnaObavestenjaDTO(o.getId(), o.getNaslov(), o.getSadrzaj(), o.getDatum(), o.getSlika(), predmet, o.getVremePocetka(), o.getVremeKraja()));
					}
		}
				}
		return new ResponseEntity<Iterable<PredmetnaObavestenjaDTO>>(predmetnaObavestenja, HttpStatus.OK);
}	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
}
}
