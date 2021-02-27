package com.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financial.entity.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long>{

}
