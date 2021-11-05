package it.alessiacipriani.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.alessiacipriani.model.Role;
import it.alessiacipriani.model.RoleType;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRoleType(RoleType roletype);

}
