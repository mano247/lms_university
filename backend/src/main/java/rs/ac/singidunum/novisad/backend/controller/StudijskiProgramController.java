package rs.ac.singidunum.novisad.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

import rs.ac.singidunum.novisad.backend.dto.FakultetDTO;
import rs.ac.singidunum.novisad.backend.dto.StudijskiProgramDTO;
import rs.ac.singidunum.novisad.backend.model.academic.StudijskiProgram;
import rs.ac.singidunum.novisad.backend.service.StudijskiProgramService;


@Controller
@RequestMapping(path = "/api/studijskiProgrami")
@CrossOrigin(origins = "http://localhost:4200")
public class StudijskiProgramController {
	@Autowired
	private StudijskiProgramService service;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<StudijskiProgramDTO>> getAll(){
		List<StudijskiProgramDTO> studijskiProgrami = new ArrayList<StudijskiProgramDTO>();
		for (StudijskiProgram sp : service.findAll()) {
			if(sp.getFakultet()!=null) {
				Set<String> Predmeti = sp.getPredmeti()
	                    .stream()
	                    .map(predmet -> predmet.getSifraPredmeta())
	                    .collect(Collectors.toSet());
				StudijskiProgramDTO programDTO = new StudijskiProgramDTO(sp.getId(), sp.getSifraSP(), sp.getOpis(), sp.getNaziv(),  sp.getRukovodilac(),  new FakultetDTO(sp.getFakultet().getId(),sp.getFakultet().getSifraFakulteta(),sp.getFakultet().getNaziv()), Predmeti);
	
				studijskiProgrami.add(programDTO);
			}else {
				Set<String> Predmeti = sp.getPredmeti()
	                    .stream()
	                    .map(predmet -> predmet.getSifraPredmeta())
	                    .collect(Collectors.toSet());
				StudijskiProgramDTO programDTO = new StudijskiProgramDTO(sp.getId(), sp.getSifraSP(), sp.getOpis(), sp.getNaziv(),  sp.getRukovodilac(), null, Predmeti);
	
				studijskiProgrami.add(programDTO);
		}
			}
		
		return new ResponseEntity<Iterable<StudijskiProgramDTO>>(studijskiProgrami, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudijskiProgramDTO> get(@PathVariable("id") Long id){
		Optional<StudijskiProgram> sp = service.findOne(id);
		if(sp.isPresent() && sp.get().getFakultet()!= null) {
			Set<String> Predmeti = sp.get().getPredmeti()
                    .stream()
                    .map(predmet -> predmet.getSifraPredmeta())
                    .collect(Collectors.toSet());
			StudijskiProgramDTO dto = new StudijskiProgramDTO(sp.get().getId(),sp.get().getSifraSP(), sp.get().getOpis(), sp.get().getNaziv(), sp.get().getRukovodilac(), new FakultetDTO(sp.get().getFakultet().getId(),sp.get().getFakultet().getSifraFakulteta(),sp.get().getFakultet().getNaziv()), Predmeti);
			return new ResponseEntity<StudijskiProgramDTO>(dto, HttpStatus.OK);
		}else if(sp.isPresent()) {
			Set<String> Predmeti = sp.get().getPredmeti()
                    .stream()
                    .map(predmet -> predmet.getSifraPredmeta())
                    .collect(Collectors.toSet());
			StudijskiProgramDTO dto = new StudijskiProgramDTO(sp.get().getId(),sp.get().getSifraSP(), sp.get().getOpis(), sp.get().getNaziv(), sp.get().getRukovodilac(), null, Predmeti);
			return new ResponseEntity<StudijskiProgramDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgramDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/s/{sifraSP}", method = RequestMethod.GET)
	public ResponseEntity<StudijskiProgramDTO> get(@PathVariable("sifraSP") String sifraSP){
		Optional<StudijskiProgram> sp = service.findBySifraSP(sifraSP);
		if(sp.isPresent() && sp.get().getFakultet()!=null) {
			Set<String> Predmeti = sp.get().getPredmeti()
                    .stream()
                    .map(predmet -> predmet.getSifraPredmeta())
                    .collect(Collectors.toSet());
			StudijskiProgramDTO dto = new StudijskiProgramDTO(sp.get().getId(),sp.get().getSifraSP(), sp.get().getOpis(), sp.get().getNaziv(), sp.get().getRukovodilac(), new FakultetDTO(sp.get().getFakultet().getId(),sp.get().getFakultet().getSifraFakulteta(),sp.get().getFakultet().getNaziv()), Predmeti);
			return new ResponseEntity<StudijskiProgramDTO>(dto, HttpStatus.OK);
		}else if(sp.isPresent()) {
			Set<String> Predmeti = sp.get().getPredmeti()
                    .stream()
                    .map(predmet -> predmet.getSifraPredmeta())
                    .collect(Collectors.toSet());
			StudijskiProgramDTO dto = new StudijskiProgramDTO(sp.get().getId(),sp.get().getSifraSP(), sp.get().getOpis(), sp.get().getNaziv(), sp.get().getRukovodilac(),null , Predmeti);
			return new ResponseEntity<StudijskiProgramDTO>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgramDTO>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<StudijskiProgram> create(@RequestBody StudijskiProgram r){
		try {
			service.save(r);
			return new ResponseEntity<StudijskiProgram>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StudijskiProgram> update(@PathVariable("id") Long id, @RequestBody StudijskiProgram sp){
		StudijskiProgram u = service.findOne(id).orElse(null);
		if(u != null) {
			sp.setId(id);
			sp = service.save(sp);
			return new ResponseEntity<StudijskiProgram>(HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR_PERMISSION')")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudijskiProgram> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<StudijskiProgram>(HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.NOT_FOUND);
	}
}

