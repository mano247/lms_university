package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.user.StudentskaSluzba;
import rs.ac.singidunum.novisad.backend.repository.StudentskaSluzbaRepository;



@Service
public class StudentskaSluzbaService {
	@Autowired
	private StudentskaSluzbaRepository repository;
	
	public Iterable<StudentskaSluzba> findAll() {
		return repository.findAll();
	}
	
	public Optional<StudentskaSluzba> findOne(Long id) {
		return repository.findById(id);
	}

	
	public StudentskaSluzba save(StudentskaSluzba novaStudentskaSluzba) {
		return repository.save(novaStudentskaSluzba);
	}
	
	public StudentskaSluzba update(StudentskaSluzba studentskaSluzba) {
		if(repository.findById(studentskaSluzba.getId()).isPresent()) {
			return repository.save(studentskaSluzba);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(StudentskaSluzba studentskaSluzba) {
		repository.delete(studentskaSluzba);
	}
}
