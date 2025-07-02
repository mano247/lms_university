package rs.ac.singidunum.novisad.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.novisad.backend.model.Polaganje;

@Repository
public interface PolaganjeRepository extends JpaRepository<Polaganje, Long>{

	@SuppressWarnings("unused")
	private Iterable<Polaganje> findAllByStudent(Long id){
        List<Polaganje> polaganja = new ArrayList<>();
        for(Polaganje pp : findAll()){
            if(pp.getStudent().getId() == id) {
                polaganja.add(pp);
            }
        }
        return polaganja;
    };
}
