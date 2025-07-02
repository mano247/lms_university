package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.academic.Predmet;
import rs.ac.singidunum.novisad.backend.repository.PredmetRepository;



@Service
public class PredmetService {
	@Autowired
	private PredmetRepository repository;

	public Iterable<Predmet> findAll() {
		return repository.findAll();
	}
	
	public Optional<Predmet> findOne(Long id) {
		return repository.findById(id);
	}
	
	public Optional<Predmet> findBysifraPredmeta(String SifraPredmet) {
		return repository.findBysifraPredmeta(SifraPredmet);
	}

	public Predmet save(Predmet noviPredmet) {
		return repository.save(noviPredmet);
	}
	
	public Predmet update(Predmet predmet) {
		if(repository.findById(predmet.getId()).isPresent()) {
			return repository.save(predmet);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(Predmet predmet) {
		repository.delete(predmet);
	}
}