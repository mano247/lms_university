package rs.ac.singidunum.novisad.backend.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.backend.dto.StudentDTO;
import rs.ac.singidunum.novisad.backend.model.Permission;
import rs.ac.singidunum.novisad.backend.model.PermissionEnum;
import rs.ac.singidunum.novisad.backend.model.user.Administrator;
import rs.ac.singidunum.novisad.backend.model.user.Nastavnik;
import rs.ac.singidunum.novisad.backend.model.user.RegistrovaniKorisnik;
import rs.ac.singidunum.novisad.backend.model.user.Student;
import rs.ac.singidunum.novisad.backend.model.user.StudentskaSluzba;
import rs.ac.singidunum.novisad.backend.repository.PermissionRepository;
import rs.ac.singidunum.novisad.backend.repository.RegistrovaniKorisnikRepository;

@Service
public class RegistrovaniKorisnikService {

	@Autowired
	private RegistrovaniKorisnikRepository repository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	public Iterable<RegistrovaniKorisnik> findAll() {
		return repository.findAll();
	}
	
	public Optional<RegistrovaniKorisnik> findOne(Long id) {
		return repository.findById(id);
	}
	
	public Optional<RegistrovaniKorisnik> findByEmail(String email) {
	    return repository.findByEmail(email);
	}

	public RegistrovaniKorisnik save(RegistrovaniKorisnik novaKorisnik) {
		return repository.save(novaKorisnik);
	}
	
	public RegistrovaniKorisnik update(RegistrovaniKorisnik korisnik) {
		if(repository.findById(korisnik.getId()).isPresent()) {
			return repository.save(korisnik);
		}
		return null;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(RegistrovaniKorisnik korisnik) {
		repository.delete(korisnik);
	}
		
	public boolean promeniTipKorisnika(long korisnikId, String tip) {
		RegistrovaniKorisnik korisnik = repository.findById(korisnikId).orElse(null);

		if (korisnik == null) {
			return false;
		}
		if ("student_premission".equalsIgnoreCase(tip) && !(korisnik instanceof Student)) {
			Set<Permission> permissions = new HashSet<>();
			Optional<Permission> studentRole = permissionRepository.findByName(PermissionEnum.STUDENT_PERMISSION);
			permissions.add(studentRole.orElse(null));
			Student student = new Student();
			student.setKorisnickoIme(korisnik.getKorisnickoIme());
			student.setEmail(korisnik.getEmail());
			student.setLozinka(korisnik.getLozinka());
			student.setPermissions(permissions);
			repository.delete(korisnik);
			repository.save(student);
			return true;
		}
		else if ("nastavnik_premission".equalsIgnoreCase(tip) && !(korisnik instanceof Nastavnik)) {
				Set<Permission> permissions = new HashSet<>();
				Optional<Permission> profesorRole = permissionRepository.findByName(PermissionEnum.NASTAVNIK_PERMISSION);
				permissions.add(profesorRole.orElse(null));
				Nastavnik profesor = new Nastavnik();
				profesor.setIme(korisnik.getKorisnickoIme());
				profesor.setEmail(korisnik.getEmail());
				profesor.setLozinka(korisnik.getLozinka());
				profesor.setPermissions(permissions);
				repository.delete(korisnik);
				repository.save(profesor);
			 return true;
		}
		else if ("studentskaSluzba_premission".equalsIgnoreCase(tip) && !(korisnik instanceof StudentskaSluzba)) {
			Set<Permission> permissions = new HashSet<>();
			Optional<Permission> studentskasluzbaRole = permissionRepository.findByName(PermissionEnum.STUDENTSKASLUZBA_PERMISSION);
			permissions.add(studentskasluzbaRole.orElse(null));
			StudentskaSluzba studentskaSluzba = new StudentskaSluzba();
			studentskaSluzba.setKorisnickoIme(korisnik.getKorisnickoIme());
			studentskaSluzba.setEmail(korisnik.getEmail());
			studentskaSluzba.setLozinka(korisnik.getLozinka());
			studentskaSluzba.setPermissions(permissions);
			repository.delete(korisnik);
			repository.save(studentskaSluzba);
			 return true;
		}
		else if ("administrator_premission".equalsIgnoreCase(tip) && !(korisnik instanceof Administrator)) {
			Set<Permission> permissions = new HashSet<>();
			Optional<Permission> administratorRole = permissionRepository.findByName(PermissionEnum.ADMINISTRATOR_PERMISSION);
			permissions.add(administratorRole.orElse(null));
			Administrator administrator = new Administrator();
			administrator.setKorisnickoIme(korisnik.getKorisnickoIme());
			administrator.setEmail(korisnik.getEmail());
			administrator.setLozinka(korisnik.getLozinka());
			administrator.setPermissions(permissions);
			repository.delete(korisnik);
			repository.save(administrator);
			 return true;
		}
		else {

			return false;
		}
	}
	
	public boolean upisStudenta (long korisnikId, StudentDTO dodatneInfStudent) {
		
		RegistrovaniKorisnik korisnik = repository.findById(korisnikId).orElse(null);
		if (korisnik == null) {
			return false;
			}
		else if (!(korisnik instanceof Student)) {
			Set<Permission> permissions = new HashSet<>();
			Optional<Permission> studentRole = permissionRepository.findByName(PermissionEnum.STUDENT_PERMISSION);
			permissions.add(studentRole.orElse(null));
			
			Student student = new Student();
			
			student.setEmail(dodatneInfStudent.getEmail());
			student.setKorisnickoIme(dodatneInfStudent.getKorisnickoIme());
			student.setBrojIndeksa(dodatneInfStudent.getBrojIndeksa());
			student.setLozinka(dodatneInfStudent.getLozinka());
			student.setIme(dodatneInfStudent.getIme());
			student.setPrezime(dodatneInfStudent.getPrezime());
			student.setFakultet(dodatneInfStudent.getFakultet());
			student.setPermissions(permissions);
			repository.delete(korisnik);
			repository.save(student);
			return true;
		}
		else {return false;}
	}
	}
