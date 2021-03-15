package com.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financial.entity.Entry;
import com.financial.repository.entry.EntryQueryInterfaces;



public interface EntryRepository extends JpaRepository<Entry, Long>, EntryQueryInterfaces{

}
