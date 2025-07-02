package rs.ac.singidunum.novisad.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.model.GodinaStudija;
import rs.ac.singidunum.novisad.backend.repository.GodinaStudijaRepository;


@Service
public class GodinaStudijaService {

	@Autowired
	private GodinaStudijaRepository godinaRepository;
	
	public Iterable<GodinaStudija> findAll() {
		return godinaRepository.findAll();
	}
	
	public Optional<GodinaStudija> findOne(Long id) {
		return godinaRepository.findById(id);
	}

	public GodinaStudija save(GodinaStudija novaGodinaStudija) {
		return godinaRepository.save(novaGodinaStudija);
	}
	
	public GodinaStudija update(GodinaStudija godinaStudija) {
		if(godinaRepository.findById(godinaStudija.getId()).isPresent()) {
			return godinaRepository.save(godinaStudija);
		}
		return null;
	}
	
	public void delete(Long id) {
		godinaRepository.deleteById(id);
	}
}
