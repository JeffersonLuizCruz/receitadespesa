package com.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financial.entities.Entry;
import com.financial.repository.entry.EntryQueryInterfaces;


@Repository
public interface EntryRepository extends JpaRepository<Entry, Long>, EntryQueryInterfaces{

}
