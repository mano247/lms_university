package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.PredmetnaObavestenja;
import rs.ac.singidunum.novisad.backend.repository.PredmetnaObavestenjaRepository;


@Service
public class PredmetnaObavestenjaService {
	@Autowired
	private PredmetnaObavestenjaRepository repository;
	
	public Iterable<PredmetnaObavestenja> findAll() {
		return repository.findAll();
	}
	
	public Optional<PredmetnaObavestenja> findOne(Long id) {
		return repository.findById(id);
	}

	
	public PredmetnaObavestenja save(PredmetnaObavestenja novaOpstaObavestenja) {
		return repository.save(novaOpstaObavestenja);
	}
	
	public PredmetnaObavestenja update(PredmetnaObavestenja opstaObavestenja) {
		if(repository.findById(opstaObavestenja.getId()).isPresent()) {
			return repository.save(opstaObavestenja);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(PredmetnaObavestenja opstaObavestenja) {
		repository.delete(opstaObavestenja);
	}
}
