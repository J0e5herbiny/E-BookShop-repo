package com.joe.bookshop.reposietpry;

import com.joe.bookshop.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    void deleteById(int id);

    Optional<Category> findById(int id);
}
