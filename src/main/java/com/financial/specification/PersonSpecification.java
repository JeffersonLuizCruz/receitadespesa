package com.financial.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import com.financial.entities.Person;
import com.financial.repositories.filter.PersonFilter;

public class PersonSpecification {

	public static Specification<Person> search(String text){
		
		return new Specification<Person>() {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unused")
			public Predicate[] t(Root<Person> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) {
				PersonFilter personRequestDto = new PersonFilter();
				
				List<Predicate> listPredicates = new ArrayList<>();

				if(!ObjectUtils.isEmpty(personRequestDto.getName())) {
					listPredicates.add(cb.like(
											cb.lower(root.get("name")), 
											"%"+personRequestDto.getName()+"%"));
				}
				if(!ObjectUtils.isEmpty(personRequestDto.getActive())) {
					listPredicates.add(cb.equal(
											root.get("active"), 
											personRequestDto.getActive()));
				}
				return listPredicates.toArray(new Predicate[listPredicates.size()]);
			}

			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
			
	}
