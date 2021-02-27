package com.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financial.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	Person existsById(boolean active);

}
