package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.academic.NastavniMaterijal;
import rs.ac.singidunum.novisad.backend.repository.NastavniMaterijalRepository;



@Service
public class NastavniMaterijalService {
	@Autowired
	private NastavniMaterijalRepository repository;
	
	public Iterable<NastavniMaterijal> findAll() {
		return repository.findAll();
	}
	
	public Optional<NastavniMaterijal> findOne(Long id) {
		return repository.findById(id);
	}

	
	public NastavniMaterijal save(NastavniMaterijal novaNastavniMaterijal) {
		return repository.save(novaNastavniMaterijal);
	}
	
	public NastavniMaterijal update(NastavniMaterijal nastavniMaterijal) {
		if(repository.findById(nastavniMaterijal.getId()).isPresent()) {
			return repository.save(nastavniMaterijal);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(NastavniMaterijal nastavniMaterijal) {
		repository.delete(nastavniMaterijal);
	}
	
}