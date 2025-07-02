package rs.ac.singidunum.novisad.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.novisad.backend.model.academic.Fakultet;



@Repository
public interface FakultetRepository extends JpaRepository<Fakultet, Long>{
	
//	Optional<Fakultet> findOne(Long Id);

	Optional<Fakultet> findBySifraFakulteta(String sifraFakulteta);

}

