package rs.ac.singidunum.novisad.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.Polaganje;
import rs.ac.singidunum.novisad.backend.repository.PolaganjeRepository;



@Service
public class PolaganjeService {
	@Autowired
	private PolaganjeRepository repository;
	
	public Iterable<Polaganje> findAll() {
		return repository.findAll();
	}
	
	public Optional<Polaganje> findOne(Long id) {
		return repository.findById(id);
	}

	
	public Polaganje save(Polaganje novaPokusajPolaganja) {
		return repository.save(novaPokusajPolaganja);
	}
	
	public Polaganje update(Polaganje pokusajPolaganja) {
		if(repository.findById(pokusajPolaganja.getId()).isPresent()) {
			return repository.save(pokusajPolaganja);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(Polaganje pokusajPolaganja) {
		repository.delete(pokusajPolaganja);
	}

	public Iterable<Polaganje> findAllByStudent(Long id ) {
		List<Polaganje> polaganja = new ArrayList<>();
		for(Polaganje pp : findAll()){
			if(pp.getStudent().getId() == id) {
				polaganja.add(pp);
			}
		}
		return polaganja;
	}
}

