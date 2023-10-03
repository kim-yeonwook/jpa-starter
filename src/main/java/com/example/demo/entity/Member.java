package com.example.demo.entity;

import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Entity
@Table(name="member")
public class Member {

	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="birthday")
	private Date birthday;
	
	@OneToOne
	@JoinColumn(name="role_id", nullable = false)
	private Role role;

	@Builder.Default
	@OneToMany(mappedBy = "member")
	private Set<MemberHistory> memberHistory = new HashSet<>();

	public void add(MemberHistory memberHistory) {
		memberHistory.add(this);
		this.memberHistory.add(memberHistory);
	}

	@Override
	public String toString() {
		return "Member{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", nickname='" + nickname + '\'' +
				", age=" + age +
				", birthday=" + birthday +
				", role=" + role +
				", memberHistory=" + memberHistory +
				'}';
	}
}
