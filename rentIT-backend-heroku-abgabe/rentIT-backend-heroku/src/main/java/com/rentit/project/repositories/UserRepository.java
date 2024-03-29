package com.rentit.project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentit.project.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	Optional<UserEntity> findByUsername(String username);
	
	Optional<UserEntity> findByEmail(String email);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
}
