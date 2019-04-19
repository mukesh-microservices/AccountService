package com.tais.AccountService.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tais.AccountService.dao.entity.UserRole;

@Repository
public interface RoleRepository extends CrudRepository<UserRole, String> {
	
}
