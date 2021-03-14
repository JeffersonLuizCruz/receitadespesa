package com.financial.specification;

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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import com.financial.dto.EntryRequestDto;
import com.financial.entity.Entry;
import com.financial.util.ResultEntry;

public class EntrySpecification {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Page<ResultEntry> resumir(EntryRequestDto entryRequestDto, Pageable pageable) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ResultEntry> criteria = builder.createQuery(ResultEntry.class);
		
		Root<Entry> root = criteria.from(Entry.class);
		
		criteria.select(builder.construct(ResultEntry.class
				, root.get("id"), root.get("description")
				, root.get("expirationDate"), root.get("paymentDate")
				, root.get("amount"), root.get("type")
				, root.get("category").get("name")
				, root.get("person").get("name")));
		
		Predicate[] predicates = criarRestricoes(entryRequestDto, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResultEntry> query = entityManager.createQuery(criteria);
		adicionarRestricaoDePaginacao(query, pageable);
		
		return 
	}
	
	///
	
public static Specification<Entry> search(String text){
	
		return new Specification<Entry>() {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unused")
			public Predicate[] filter(Root<Entry> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) {
				EntryRequestDto entryRequestDto = new EntryRequestDto();
				List<Predicate> listaPredicates = new ArrayList<>();
				
				List<Predicate> listPredicates = new ArrayList<>();

				if(!ObjectUtils.isEmpty(entryRequestDto.getDescricao())) {
					listPredicates.add(cb.like(
											cb.lower(root.get("descricao")), 
											"%"+entryRequestDto.getDescricao()+"%"));
				}
				if(null != entryRequestDto.getDataVencimentoDe()) {
					listaPredicates.add(cb.greaterThanOrEqualTo(
											root.get("dataVencimento"), 
											entryRequestDto.getDataVencimentoDe()));
				}
				if(null != entryRequestDto.getDataVencimentoAte()) {
					listaPredicates.add(cb.lessThanOrEqualTo(
											root.get("dataVencimento"), 
											entryRequestDto.getDataVencimentoAte()));
				}
				return listPredicates.toArray(new Predicate[listPredicates.size()]);
			}

			@Override
			public Predicate toPredicate(Root<Entry> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return null;
			}

		};
	}

}
