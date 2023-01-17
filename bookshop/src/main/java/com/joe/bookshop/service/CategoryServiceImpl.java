package com.joe.bookshop.service;

import com.joe.bookshop.domain.dto.CategoryDTO;
import com.joe.bookshop.domain.model.Category;
import com.joe.bookshop.reposietpry.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

  //  @Override
    public List<Category> getAll(){             // Read
        return categoryRepository.findAll();
    }

    public Optional<Category> getById (int id){  // Read by id
        return categoryRepository.findById(id);
    }

    public void save(CategoryDTO categoryDTO){    // Create, Update
        Category category = new Category(categoryDTO.getName());
        category.setId(0);
        categoryRepository.save(category);
    }

    public String delete(int id){           // Deleted
        categoryRepository.deleteById(id);
        return "Deleted";
    }


}
