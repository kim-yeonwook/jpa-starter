package com.example.demo.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Data
@Entity
@Table(name="MEMBER_HIS")
public class MemberHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_HISTORY_ID")
	private Long id;
	
	@Column(name = "LOGIN_TYPE")
	private String loginType;
	
//	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "MEMBER_ID")
	private Member member;
}
