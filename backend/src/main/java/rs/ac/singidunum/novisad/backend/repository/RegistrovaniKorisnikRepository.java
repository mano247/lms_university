package rs.ac.singidunum.novisad.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.novisad.backend.model.user.RegistrovaniKorisnik;

@Repository
public interface RegistrovaniKorisnikRepository extends JpaRepository<RegistrovaniKorisnik, Long>{

	Optional<RegistrovaniKorisnik> findByEmail(String email);

	Boolean existsRegistrovaniKorisnikByEmail(String email);
}
