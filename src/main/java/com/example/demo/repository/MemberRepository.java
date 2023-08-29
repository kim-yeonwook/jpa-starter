package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

//	@Query(value=""
//			+ ""
//			+ ""
//			+ ""
//			+ "", nativeQuery=true)
//	Member findMember(Long id);
}
