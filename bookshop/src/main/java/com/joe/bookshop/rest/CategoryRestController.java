package com.joe.bookshop.rest;

import com.joe.bookshop.domain.dto.CategoryDTO;
import com.joe.bookshop.domain.model.Category;
import com.joe.bookshop.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category_api")
public class CategoryRestController {

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryRestController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> geCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/{categoryId}")
    public CategoryDTO getCtg(@PathVariable("categoryId")Integer id){
        Optional<Category> category = categoryService.getById(id);
        return new CategoryDTO(category.get().getName());
    }

    @PostMapping("/category")
    public CategoryDTO addCtg(@RequestBody CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);
        return categoryDTO;
    }

}
