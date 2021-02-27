package com.financial.repository.query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.financial.dto.PersonRequestDto;
import com.financial.entity.Person;

public class PersonQueryImpl implements PersonQueryInterfaces{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<Person> filter(PersonRequestDto personRequestDto, Pageable pageable) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		
		Root<Person> root = criteriaQuery.from(Person.class);
		
		Predicate[] predicates = this.criarRestricoes(personRequestDto, criteriaBuilder, root);
		criteriaQuery.where(predicates);
		
		TypedQuery<Person> typedQuery = entityManager.createQuery(criteriaQuery);
		adicionarRestricaoDePaginacao(typedQuery, pageable);
		
		
		return new PageImpl<>(typedQuery.getResultList(), pageable, this.total(personRequestDto));
	}

}
