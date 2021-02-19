package com.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financial.enttry.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
