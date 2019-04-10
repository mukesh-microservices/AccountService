package com.tais.AccountService.dao.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tais.AccountService.dao.entity.UserProfile;

@Repository
public interface ProfileRepository extends CrudRepository<UserProfile, String> {
	Optional<UserProfile> findByEmail(String email);
}
