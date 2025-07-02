package rs.ac.singidunum.novisad.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.novisad.backend.model.academic.Predmet;


@Repository
public interface PredmetRepository extends JpaRepository<Predmet, Long>{

	Optional<Predmet> findBysifraPredmeta(String sifraPredmet);

}

