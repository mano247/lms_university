package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.academic.Univerzitet;
import rs.ac.singidunum.novisad.backend.repository.UniverzitetRepository;

@Service
public class UniverzitetService {
	@Autowired
	private UniverzitetRepository repository;
	
	public Iterable<Univerzitet> findAll() {
		return repository.findAll();
	}
	
	public Optional<Univerzitet> findOne(Long id) {
		return repository.findById(id);
	}

	
	public Univerzitet save(Univerzitet novaUniverzitet) {
		return repository.save(novaUniverzitet);
	}
	
	public Univerzitet update(Univerzitet univerzitet) {
		if(repository.findById(univerzitet.getId()).isPresent()) {
			return repository.save(univerzitet);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(Univerzitet univerzitet) {
		repository.delete(univerzitet);
	}

}
