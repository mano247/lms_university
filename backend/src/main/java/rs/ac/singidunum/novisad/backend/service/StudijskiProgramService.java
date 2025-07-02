package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.academic.StudijskiProgram;
import rs.ac.singidunum.novisad.backend.repository.StudijskiProgramRepository;

@Service
public class StudijskiProgramService {
	@Autowired
	private StudijskiProgramRepository repository;
	
	public Iterable<StudijskiProgram> findAll() {
		return repository.findAll();
	}
	
	public Optional<StudijskiProgram> findOne(Long id) {
		return repository.findById(id);
	}
	
	public Optional<StudijskiProgram> findBySifraSP(String sifraSP) {
		return repository.findBySifraSP(sifraSP);
	}
	
	public StudijskiProgram save(StudijskiProgram noviStudijskiProgram) {
		return repository.save(noviStudijskiProgram);
	}
	
	public StudijskiProgram update(StudijskiProgram studijskiProgram) {
		if(repository.findById(studijskiProgram.getId()).isPresent()) {
			return repository.save(studijskiProgram);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(StudijskiProgram studijskiProgram) {
		repository.delete(studijskiProgram);
	}
	
}
