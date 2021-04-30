package com.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financial.entities.Entry;
import com.financial.repositories.entry.EntryQuery;


@Repository
public interface EntryRepository extends JpaRepository<Entry, Long>, EntryQuery{

}
