package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.StudentNaGodini;
import rs.ac.singidunum.novisad.backend.repository.StudentNaGodiniRepository;

@Service
public class StudentNaGodiniService {
	
	@Autowired
	private StudentNaGodiniRepository sngRepository;
	
	public Iterable<StudentNaGodini> findAll() {
		return sngRepository.findAll();
	}
	
	public Optional<StudentNaGodini> findOne(Long id) {
		return sngRepository.findById(id);
	}

	
	public StudentNaGodini save(StudentNaGodini noviStudentNaGodini) {
		return sngRepository.save(noviStudentNaGodini);
	}
	
	public StudentNaGodini update(StudentNaGodini studentNaGodini) {
		if(sngRepository.findById(studentNaGodini.getId()).isPresent()) {
			return sngRepository.save(studentNaGodini);
		}
		return null;
	}
	
	public void delete(Long id) {
		sngRepository.deleteById(id);
	}
	
	public void delete(StudentNaGodini studentNaGodini) {
		sngRepository.delete(studentNaGodini);
	}

}
