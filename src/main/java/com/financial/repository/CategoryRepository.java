package com.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financial.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
