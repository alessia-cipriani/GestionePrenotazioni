package it.alessiacipriani.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.alessiacipriani.model.Citta;
import it.alessiacipriani.model.Role;
import it.alessiacipriani.model.RoleType;
import it.alessiacipriani.model.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> findAllRole(){
		return roleRepository.findAll();
	}
	public Optional<Role> getRoleById(Long id){
		return roleRepository.findById(id);
	}
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
}
