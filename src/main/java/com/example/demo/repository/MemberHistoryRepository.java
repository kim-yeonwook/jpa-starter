package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.MemberHistory;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Long> {

}
