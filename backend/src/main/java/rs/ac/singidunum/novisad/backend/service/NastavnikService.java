package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.user.Nastavnik;
import rs.ac.singidunum.novisad.backend.repository.NastavnikRepository;



@Service
public class NastavnikService {
	@Autowired
	private NastavnikRepository repository;
	
	public Iterable<Nastavnik> findAll() {
		return repository.findAll();
	}
	
	public Optional<Nastavnik> findOne(Long id) {
		return repository.findById(id);
	}

	
	public Nastavnik save(Nastavnik novaProfesor) {
		return repository.save(novaProfesor);
	}
	
	public Nastavnik update(Nastavnik profesor) {
		if(repository.findById(profesor.getId()).isPresent()) {
			return repository.save(profesor);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(Nastavnik profesor) {
		repository.delete(profesor);
	}
}
