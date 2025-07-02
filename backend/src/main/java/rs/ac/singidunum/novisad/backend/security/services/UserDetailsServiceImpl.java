package rs.ac.singidunum.novisad.backend.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.singidunum.novisad.backend.model.user.RegistrovaniKorisnik;
import rs.ac.singidunum.novisad.backend.repository.RegistrovaniKorisnikRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  RegistrovaniKorisnikRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    RegistrovaniKorisnik user = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Ne postojeca mejl adresa: " + email));

    return UserDetailsImpl.build(user);
  }

}
