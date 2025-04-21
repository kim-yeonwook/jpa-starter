package com.jpa.starter.infrastructure.persistence.repository;

import com.jpa.starter.infrastructure.persistence.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByCode(String code);

    void removeByCode(String code);
}
