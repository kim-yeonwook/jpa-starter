package com.jpa.starter.infrastructure.persistence.repository;

import com.jpa.starter.infrastructure.enums.BoardStatus;
import com.jpa.starter.infrastructure.persistence.entity.Board;
import com.jpa.starter.infrastructure.persistence.repository.custom.BoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {

    Optional<Board> findByCode(String code);

    Optional<Board> findByCodeAndStatusIn(String code, BoardStatus... status);

    void removeByCode(String code);
}
