package com.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financial.entities.Entry;
import com.financial.repository.entry.EntryQueryInterfaces;



public interface EntryRepository extends JpaRepository<Entry, Long>, EntryQueryInterfaces{

}
