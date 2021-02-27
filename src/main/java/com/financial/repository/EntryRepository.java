package com.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financial.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long>{

}
