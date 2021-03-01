/**
 * Bug
 * 
package com.financial.repository.query;

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

import com.financial.dto.PageRequestModel;
import com.financial.entity.Person;

@Deprecated
public class PersonQueryImpl implements PersonQueryInterfaces{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<Person> findByPerson(PageRequestModel personRequestDto, Pageable pageable) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		
		Root<Person> root = criteriaQuery.from(Person.class);
		//
		Predicate[] predicates = this.criarRestricoes(personRequestDto, criteriaBuilder, root);
		criteriaQuery.where(predicates);
		//
		TypedQuery<Person> typedQuery = entityManager.createQuery(criteriaQuery);
		adicionarRestricaoDePaginacao(typedQuery, pageable);
		
		//
		return new PageImpl<>(typedQuery.getResultList(), pageable, this.total(personRequestDto));
	}
	

	private Predicate[] criarRestricoes(PageRequestModel personRequestDto, CriteriaBuilder criteriaBuilder, Root<Person> root) {
		
		List<Predicate> listaPredicates = new ArrayList<>();
		
		if(!ObjectUtils.isEmpty(personRequestDto.getName())) {
			listaPredicates.add(criteriaBuilder.like(
									criteriaBuilder.lower(root.get("name")), 
									"%"+personRequestDto.getName()+"%"));
		}
		
		if(!ObjectUtils.isEmpty(personRequestDto.getActive())) {
			listaPredicates.add(criteriaBuilder.equal(
									root.get("active"), 
									personRequestDto.getActive()));
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
	
	private Long total(PageRequestModel pessoaFilter) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		
		Root<Person> root = criteriaQuery.from(Person.class);
		
		Predicate[] predicates = this.criarRestricoes(pessoaFilter, criteriaBuilder, root);
		
		criteriaQuery.where(predicates);
		
		criteriaQuery.select(criteriaBuilder.count(root));
		
		return entityManager.createQuery(criteriaQuery).getSingleResult();
		
	}

}
*/
