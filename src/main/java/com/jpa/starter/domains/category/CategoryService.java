package com.jpa.starter.domains.category;

import com.jpa.starter.infrastructure.enums.CategoryStatus;
import com.jpa.starter.infrastructure.persistence.entity.Category;
import com.jpa.starter.infrastructure.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category save(String code, String name, String description, int order, String user) {
        // code 중복 검증
        
        // name 중복 검증
        
        Category category = Category.builder()
                .code(code)
                .name(name)
                .description(description)
                .order(order)
                .status(CategoryStatus.ACTIVE)
                .createdId(user)
                .build();

        return categoryRepository.save(category);
    }

    public Category update(String code) {
        Category category = this.categoryRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("카테고리가 없습니다. code : " + code));

        return this.categoryRepository.save(category);
    }

    public void delete(String code) {
        this.categoryRepository.deleteByCode(code);
    }

    public Page<Category> list(Pageable pageable) {
        return null;
    }

    public List<Category> list() {
        return null;
    }

    public Category get(String code) {
        return this.categoryRepository.findByCode(code)
                .orElse(null);
    }
}