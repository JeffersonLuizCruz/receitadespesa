package com.financial.repositories.person;

import java.util.ArrayList;
import java.util.List;

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

import org.springframework.util.ObjectUtils;

import com.financial.entities.Person;
import com.financial.repositories.filter.PersonFilter;


public class PersonQueryImpl implements PersonQuery{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<Person> findByPerson(PersonFilter personFilter, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		
		Root<Person> root = criteriaQuery.from(Person.class);

		Predicate[] predicates = this.criarRestricoes(personFilter, criteriaBuilder, root);
		criteriaQuery.where(predicates);

		TypedQuery<Person> typedQuery = entityManager.createQuery(criteriaQuery);
		adicionarRestricaoDePaginacao(typedQuery, pageable);
		

		return new PageImpl<>(typedQuery.getResultList(), pageable, this.total(personFilter));
	}
	

	private Predicate[] criarRestricoes(PersonFilter personFilter, CriteriaBuilder criteriaBuilder, Root<Person> root) {
		List<Predicate> listaPredicates = new ArrayList<>();
		
		if(!ObjectUtils.isEmpty(personFilter.getName())) {
			listaPredicates.add(criteriaBuilder.like(
									criteriaBuilder.lower(root.get("name")), 
									"%"+personFilter.getName()+"%"));
		}
		
		if(!ObjectUtils.isEmpty(personFilter.getActive())) {
			listaPredicates.add(criteriaBuilder.equal(
									root.get("active"), 
									personFilter.getActive()));
		}
		
		return listaPredicates.toArray(new Predicate[listaPredicates.size()]);
	}
	
	private void adicionarRestricaoDePaginacao(TypedQuery<?> typedQuery, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
		
		typedQuery.setFirstResult(primeiroRegistroDaPagina);
		typedQuery.setMaxResults(totalRegistroPorPagina);
	}
	
	private Long total(PersonFilter pessoaFilter) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		
		Root<Person> root = criteriaQuery.from(Person.class);
		
		Predicate[] predicates = this.criarRestricoes(pessoaFilter, criteriaBuilder, root);
		
		criteriaQuery.where(predicates);
		
		criteriaQuery.select(criteriaBuilder.count(root));
		
		return entityManager.createQuery(criteriaQuery).getSingleResult();
		
	}

}
