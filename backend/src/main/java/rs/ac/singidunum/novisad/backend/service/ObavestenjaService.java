package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.Obavestenje;
import rs.ac.singidunum.novisad.backend.repository.ObavestenjeRepository;



@Service
public class ObavestenjaService {
	@Autowired
	private ObavestenjeRepository repository;
	
	public Iterable<Obavestenje> findAll() {
		return repository.findAll();
	}
	
	public Optional<Obavestenje> findOne(Long id) {
		return repository.findById(id);
	}

	
	public Obavestenje save(Obavestenje novaObavestenja) {
		return repository.save(novaObavestenja);
	}
	
	public Obavestenje update(Obavestenje obavestenja) {
		if(repository.findById(obavestenja.getId()).isPresent()) {
			return repository.save(obavestenja);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(Obavestenje obavestenja) {
		repository.delete(obavestenja);
	}
}
