package com.example.reto3.service;

import com.example.reto3.entities.Tool;
import com.example.reto3.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAll(){return toolRepository.getAll();}
    public Optional<Tool> getTool(int id){return toolRepository.getTool(id);}
    public Tool save(Tool a){
        if(a.getId()==null){
            return toolRepository.save(a);
        } else{
            Optional<Tool> e = toolRepository.getTool(a.getId());
            if (e.isPresent()){
                return a;
            } else {
                return toolRepository.save(a);
            }
        }
    }

    public Tool update(Tool a){
        if(a.getId()!= null){
            Optional<Tool> q = toolRepository.getTool(a.getId());
            if (q.isPresent()){
                if (a.getDescription() != null){
                    q.get().setDescription(a.getDescription());
                }
                if (a.getName() != null){
                    q.get().setName(a.getName());
                }
                if (a.getBrand() != null){
                    q.get().setBrand(a.getBrand());
                }
                if (a.getYear() != null){
                    q.get().setYear(a.getYear());
                }
                toolRepository.save(q.get());
                return q.get();
            } else {
                return a;
            }
        } else {
            return a;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Tool> a = toolRepository.getTool(id);
        if (a.isPresent()){
            toolRepository.delete(a.get());
            flag =true;
        }
        return flag;
    }
}


