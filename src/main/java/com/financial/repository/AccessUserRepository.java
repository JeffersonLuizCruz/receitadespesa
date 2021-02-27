package com.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financial.entity.AccessUser;


@Repository
public interface AccessUserRepository extends JpaRepository<AccessUser, Long>{

}
