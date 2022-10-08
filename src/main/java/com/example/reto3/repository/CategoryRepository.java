package com.example.reto3.repository;

import com.example.reto3.entities.Category;
import com.example.reto3.repository.crudRepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){return (List<Category>) categoryCrudRepository.findAll();}
    public Optional<Category> getCategory(int idCategory){return  categoryCrudRepository.findById(idCategory);}
    public Category save(Category c){return categoryCrudRepository.save(c);}
    public void delete(Category c) {
        categoryCrudRepository.delete(c);}
}
