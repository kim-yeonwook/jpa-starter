package com.jpa.starter.infrastructure.persistence.repository;

import com.jpa.starter.infrastructure.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCode(String code);
}
