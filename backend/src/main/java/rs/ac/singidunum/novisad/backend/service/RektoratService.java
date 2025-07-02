package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.Rektorat;
import rs.ac.singidunum.novisad.backend.model.academic.Univerzitet;
import rs.ac.singidunum.novisad.backend.repository.RektoratRepository;

@Service
public class RektoratService {

	@Autowired
	private RektoratRepository repository;

	
	public Iterable<Rektorat> findAll() {
		return repository.findAll();
	}
	
	public Optional<Rektorat> findOne(Long id) {
		return repository.findById(id);
	}

	
	public Rektorat save(Rektorat novaRektorat) {
		return repository.save(novaRektorat);
	}
	
	public Rektorat update(Rektorat rektorat) {
		if(repository.findById(rektorat.getId()).isPresent()) {
			return repository.save(rektorat);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(Rektorat rektorat) {
		repository.delete(rektorat);
	}
	
	@SuppressWarnings("deprecation")
	public Set<Univerzitet> getAllUniversityForRectorat(Long id) {
		return repository.getById(id).getUniverziteti();
	}
}
