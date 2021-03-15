package com.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.financial.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person>{

}
