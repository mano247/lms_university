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

import rs.ac.singidunum.novisad.backend.dto.FakultetDTO;
import rs.ac.singidunum.novisad.backend.dto.GodinaStudijaDTO;
import rs.ac.singidunum.novisad.backend.dto.StudentDTO;
import rs.ac.singidunum.novisad.backend.dto.StudentNaGodiniDTO;
import rs.ac.singidunum.novisad.backend.dto.StudijskiProgramDTO;
import rs.ac.singidunum.novisad.backend.model.GodinaStudija;
import rs.ac.singidunum.novisad.backend.model.StudentNaGodini;
import rs.ac.singidunum.novisad.backend.model.academic.StudijskiProgram;
import rs.ac.singidunum.novisad.backend.model.user.Student;
import rs.ac.singidunum.novisad.backend.service.StudentNaGodiniService;

@Controller
@RequestMapping(path = "/api/sng")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentNaGodiniController {
	@Autowired
	private StudentNaGodiniService service;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<StudentNaGodiniDTO>> getAll(){
		HashSet<StudentNaGodiniDTO> sng = new HashSet<StudentNaGodiniDTO>();
		for (StudentNaGodini s : service.findAll()) {
			GodinaStudija gs = s.getGodinaStudija();
			Student st = s.getStudent();
			StudijskiProgram sp = s.getStudijskiProgram();
			
			GodinaStudijaDTO godinaStudija = new GodinaStudijaDTO(gs.getId(),gs.getGodina());
			StudentDTO student = new StudentDTO(st.getId(),st.getIme(),st.getPrezime(),st.getEmail(),st.getLozinka(),st.getBrojIndeksa(),st.getKorisnickoIme());
			StudijskiProgramDTO sProgram = new StudijskiProgramDTO(sp.getId(),sp.getSifraSP(),sp.getOpis(),sp.getNaziv(),sp.getRukovodilac(),new FakultetDTO(sp.getFakultet().getId(),sp.getFakultet().getSifraFakulteta(),sp.getFakultet().getNaziv()));
			
			
			sng.add(new StudentNaGodiniDTO(s.getId(),s.getDatumUpisa(),godinaStudija,student,sProgram));
		}
		return new ResponseEntity<Iterable<StudentNaGodiniDTO>>(sng, HttpStatus.OK);
		}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentNaGodiniDTO> get(@PathVariable("id") Long id) {
		Optional<StudentNaGodini> s = service.findOne(id);
		if(s.isPresent()) {
			GodinaStudija gs = s.get().getGodinaStudija();
			Student st = s.get().getStudent();
			StudijskiProgram sp = s.get().getStudijskiProgram();
			
			GodinaStudijaDTO godinaStudija = new GodinaStudijaDTO(gs.getId(),gs.getGodina());
			StudentDTO student = new StudentDTO(st.getId(),st.getIme(),st.getPrezime(),st.getEmail(),st.getLozinka(),st.getBrojIndeksa(),st.getKorisnickoIme());
			StudijskiProgramDTO sProgram = new StudijskiProgramDTO(sp.getId(),sp.getSifraSP(),sp.getOpis(),sp.getNaziv(),sp.getRukovodilac(),new FakultetDTO(sp.getFakultet().getId(),sp.getFakultet().getSifraFakulteta(),sp.getFakultet().getNaziv()));
			
			StudentNaGodiniDTO sng = new StudentNaGodiniDTO(s.get().getId(),s.get().getDatumUpisa(),godinaStudija,student,sProgram);
			return new ResponseEntity<StudentNaGodiniDTO>(sng, HttpStatus.OK);
		}
		return new ResponseEntity<StudentNaGodiniDTO>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<StudentNaGodini> create(@RequestBody StudentNaGodini sng){
		try {
			service.save(sng);
			return new ResponseEntity<StudentNaGodini>(sng, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<StudentNaGodini>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentNaGodini> delete(@PathVariable("id") Long id){
		if(service.findOne(id).isPresent()) {
			service.delete(id);
			return new ResponseEntity<StudentNaGodini>(HttpStatus.OK);
		}
		return new ResponseEntity<StudentNaGodini>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StudentNaGodini> update(@PathVariable("id") Long id, @RequestBody StudentNaGodini studentNaGodini){
		StudentNaGodini sng = service.findOne(id).orElse(null);

		if(sng != null) {
			studentNaGodini.setId(id);
			studentNaGodini = service.save(studentNaGodini);
			return new ResponseEntity<StudentNaGodini>(studentNaGodini, HttpStatus.OK);
				}
		return new ResponseEntity<StudentNaGodini>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/fbs/{id}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<StudentNaGodiniDTO>> getByStudentId(@PathVariable("id") Long id){
		HashSet<StudentNaGodiniDTO> sng = new HashSet<StudentNaGodiniDTO>();
		for (StudentNaGodini s : service.findAll()) {
			Student st = s.getStudent();
			if (id == st.getId()) {
				GodinaStudija gs = s.getGodinaStudija();
				StudijskiProgram sp = s.getStudijskiProgram();
				
				GodinaStudijaDTO godinaStudija = new GodinaStudijaDTO(gs.getId(),gs.getGodina());
				StudentDTO student = new StudentDTO(st.getId(),st.getIme(),st.getPrezime(),st.getEmail(),st.getLozinka(),st.getBrojIndeksa(),st.getKorisnickoIme());
				StudijskiProgramDTO sProgram = new StudijskiProgramDTO(sp.getId(),sp.getSifraSP(),sp.getOpis(),sp.getNaziv(),sp.getRukovodilac(),new FakultetDTO(sp.getFakultet().getId(),sp.getFakultet().getSifraFakulteta(),sp.getFakultet().getNaziv()));
				
				
				sng.add(new StudentNaGodiniDTO(s.getId(),s.getDatumUpisa(),godinaStudija,student,sProgram));
			}
		}
		return new ResponseEntity<Iterable<StudentNaGodiniDTO>>(sng, HttpStatus.OK);
		}
}


