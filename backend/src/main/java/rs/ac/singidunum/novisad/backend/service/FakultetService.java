package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.academic.Fakultet;
import rs.ac.singidunum.novisad.backend.model.academic.StudijskiProgram;
import rs.ac.singidunum.novisad.backend.repository.FakultetRepository;

@Service
public class FakultetService {
	@Autowired
	private FakultetRepository repository;
	
	public Iterable<Fakultet> findAll() {
		return repository.findAll();
	}
	
	public Optional<Fakultet> findOne(Long id) {
		return repository.findById(id);
	}
	
	public Optional<Fakultet> findBySifra(String sifraFakulteta) {
		return repository.findBySifraFakulteta(sifraFakulteta);
	}
	
	public Fakultet save(Fakultet novaFakultet) {
		return repository.save(novaFakultet);
	}
	
	public Fakultet update(Fakultet fakultet) {
		if(repository.findById(fakultet.getId()).isPresent()) {
			return repository.save(fakultet);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(Fakultet fakultet) {
		repository.delete(fakultet);
	}
	
	@SuppressWarnings("deprecation")
	public Set<StudijskiProgram> getAllCoursesOfFaculty(Long id) {
		return repository.getById(id).getStudijskiProgrami();
	}
}
