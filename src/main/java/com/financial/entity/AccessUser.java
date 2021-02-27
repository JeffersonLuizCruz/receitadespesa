package com.financial.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter @Setter
@Entity(name = "access_user")
public class AccessUser implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	private String name;
	
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable
	private List<Permission> permission;

}
