package com.financial.repositories.entry;

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

import com.financial.entities.Entry;
import com.financial.repositories.filter.EntryFilter;
import com.financial.repositories.projection.ResultEntry;


public class EntryQueryImpl implements EntryQuery{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Page<Entry> filter(EntryFilter entryFilter, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Entry> criteriaQuery = criteriaBuilder.createQuery(Entry.class);
		
		Root<Entry> root = criteriaQuery.from(Entry.class);
		
		Predicate[] predicates = this.createRestriction(entryFilter, criteriaBuilder, root);
		criteriaQuery.where(predicates);
		
		TypedQuery<Entry> typedQuery = entityManager.createQuery(criteriaQuery);
		addRestrictionToPage(typedQuery, pageable);
		
		
		return new PageImpl<>(typedQuery.getResultList(), pageable, this.total(entryFilter));
	}

	@Override
	public Page<ResultEntry> result(EntryFilter entryRequestDto, Pageable pageable) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ResultEntry> criteria = builder.createQuery(ResultEntry.class);
		
		Root<Entry> root = criteria.from(Entry.class);
		
		criteria.select(builder.construct(ResultEntry.class
				, root.get("id"), root.get("description")
				, root.get("expirationDate"), root.get("paymentDate")
				, root.get("amount"), root.get("type")
				, root.get("category").get("name")
				, root.get("person").get("name")));
		
		Predicate[] predicates = createRestriction(entryRequestDto, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResultEntry> query = entityManager.createQuery(criteria);
		addRestrictionToPage(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(entryRequestDto));
	}
	
	private Long total(EntryFilter entryFilter) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		
		Root<Entry> root = criteriaQuery.from(Entry.class);
		
		Predicate[] predicates = this.createRestriction(entryFilter, criteriaBuilder, root);
		
		criteriaQuery.where(predicates);
		criteriaQuery.select(criteriaBuilder.count(root));
		
		return entityManager.createQuery(criteriaQuery).getSingleResult();
		
	}
	
	@SuppressWarnings("unused")
	private void addRestrictionToPage(TypedQuery<?> typedQuery, Pageable pageable) {	
		int currentPage = pageable.getPageNumber(); // Página Atual
		int TotalPageRegistration = pageable.getPageSize(); // Total de Registro de Página
		int primeiroRegistroDaPagina = currentPage * TotalPageRegistration;
		
		typedQuery.setFirstResult(primeiroRegistroDaPagina);
		typedQuery.setMaxResults(TotalPageRegistration);
	}
	
	private Predicate[] createRestriction(EntryFilter entryFilter, CriteriaBuilder criteriaBuilder, Root<Entry> root) {
		List<Predicate> listaPredicates = new ArrayList<>();
		
		if(!ObjectUtils.isEmpty(entryFilter.getDescricao())) {
			listaPredicates.add(criteriaBuilder.like(
									criteriaBuilder.lower(root.get("descricao")), 
									"%"+entryFilter.getDescricao()+"%"));
		}
		
		if(null != entryFilter.getDataVencimentoDe()) {
			listaPredicates.add(criteriaBuilder.greaterThanOrEqualTo(
									root.get("dataVencimento"), 
									entryFilter.getDataVencimentoDe()));
		}
		
		if(null != entryFilter.getDataVencimentoAte()) {
			listaPredicates.add(criteriaBuilder.lessThanOrEqualTo(
									root.get("dataVencimento"), 
									entryFilter.getDataVencimentoAte()));
		}
		
		return listaPredicates.toArray(new Predicate[listaPredicates.size()]);
	}

}
