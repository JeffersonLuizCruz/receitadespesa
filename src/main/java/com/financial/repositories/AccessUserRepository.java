package com.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financial.entities.AccessUser;


@Repository
public interface AccessUserRepository extends JpaRepository<AccessUser, Long>{

}
