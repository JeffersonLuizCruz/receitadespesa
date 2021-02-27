package com.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financial.entity.AccessUser;

public interface AccessUserRepository extends JpaRepository<AccessUser, Long>{

}
