package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.KancelariskiMaterijal;
import rs.ac.singidunum.novisad.backend.repository.KancelariskiMaterijalRepository;

@Service
public class KancelariskiMaterialService {
	@Autowired
	private KancelariskiMaterijalRepository repository;
	
	public Iterable<KancelariskiMaterijal> findAll() {
		return repository.findAll();
	}
	
	public Optional<KancelariskiMaterijal> findOne(Long id) {
		return repository.findById(id);
	}

	
	public KancelariskiMaterijal save(KancelariskiMaterijal nova) {
		return repository.save(nova);
	}
	
	public KancelariskiMaterijal update(KancelariskiMaterijal kancelariskiMaterijal) {
		if(repository.findById(kancelariskiMaterijal.getId()).isPresent()) {
			return repository.save(kancelariskiMaterijal);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(KancelariskiMaterijal kancelariskiMaterijal) {
		repository.delete(kancelariskiMaterijal);
	}
}
