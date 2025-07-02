package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.ZavrsniRad;
import rs.ac.singidunum.novisad.backend.repository.ZavrsniRadRepository;

@Service
public class ZavrsniRadService {
	@Autowired
	private ZavrsniRadRepository zrRepository;
	
	public Iterable<ZavrsniRad> findAll() {
		return zrRepository.findAll();
	}
	
	public Optional<ZavrsniRad> findOne(Long id) {
		return zrRepository.findById(id);
	}

	
	public ZavrsniRad save(ZavrsniRad noviZavrsniRad) {
		return zrRepository.save(noviZavrsniRad);
	}
	
	public ZavrsniRad update(ZavrsniRad ZavrsniRad) {
		if(zrRepository.findById(ZavrsniRad.getId()).isPresent()) {
			return zrRepository.save(ZavrsniRad);
		}
		return null;
	}
	
	public void delete(Long id) {
		zrRepository.deleteById(id);
	}
	
	public void delete(ZavrsniRad ZavrsniRad) {
		zrRepository.delete(ZavrsniRad);
	}
}
