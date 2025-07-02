package rs.ac.singidunum.novisad.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import rs.ac.singidunum.novisad.backend.security.jwt.AuthEntryPointJwt;
import rs.ac.singidunum.novisad.backend.security.jwt.AuthTokenFilter;
import rs.ac.singidunum.novisad.backend.security.services.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> 
	        auth.requestMatchers("/api/auth/signup").permitAll()
	        	.requestMatchers("/api/auth/signin").permitAll()
		            .requestMatchers("/api/obavestenja/**").permitAll()
		            .requestMatchers("/api/kancelariskiMaterial/**").permitAll()
		            .requestMatchers("/api/registrovaniKorisnici/**").permitAll()
		            .requestMatchers("/api/rektorati/**").permitAll()
		            .requestMatchers("/api/univerziteti/**").permitAll()
		            .requestMatchers("/api/fakulteti/**").permitAll()
		            .requestMatchers("/api/studijskiProgrami/**").permitAll()
		            .requestMatchers("/api/predmeti/**").permitAll()
		            .requestMatchers("/api/studenti/**").permitAll()
		            .requestMatchers("/api/predmetnaObavestenja/**").permitAll()
		            .requestMatchers("/api/nastavnici/**").permitAll()
		            .requestMatchers("/api/polaganja/**").permitAll()
		            .requestMatchers("/api/administratori/**").permitAll()
		            .requestMatchers("/api/studentskaSluzba/**").permitAll()
		            .requestMatchers("/api/nastavnimaterijal/**").permitAll()
		            .requestMatchers("/api/zavrsniRad/**").permitAll()
		            .requestMatchers("/api/sng/**").permitAll()
		        .anyRequest().authenticated()
        );
    
    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    
    return http.build();
  }
}