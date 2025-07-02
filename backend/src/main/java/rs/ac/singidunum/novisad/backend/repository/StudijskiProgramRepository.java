package rs.ac.singidunum.novisad.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.novisad.backend.model.academic.StudijskiProgram;


@Repository
public interface StudijskiProgramRepository extends JpaRepository<StudijskiProgram, Long>{

	Optional<StudijskiProgram> findBySifraSP(String sifraSP);

}
