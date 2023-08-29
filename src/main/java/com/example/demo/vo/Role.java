package com.example.demo.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Entity
@Table(name="ROLE")
public class Role {
	
	@Id
	@Column(name="ROLE_ID")
	private Long id;
	
	@Column(name="ROLE_CD", unique = true)
	private String code;
	
	@Column(name="ROLE_NM", unique = true)
	private String name;

}
