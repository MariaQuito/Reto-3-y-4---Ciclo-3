package com.example.reto3.repository;

import com.example.reto3.entities.Tool;
import com.example.reto3.repository.crudRepository.ToolCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToolRepository {

    @Autowired
    private ToolCrudRepository toolCrudRepository;

    public List<Tool> getAll(){return (List<Tool>) toolCrudRepository.findAll();}
    public Optional<Tool> getTool(int idTool){return  toolCrudRepository.findById(idTool);}
    public Tool save(Tool c){return toolCrudRepository.save(c);}
    public void delete(Tool c) {
        toolCrudRepository.delete(c);}
}
