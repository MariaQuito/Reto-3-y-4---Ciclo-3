package com.example.reto3.controller;

import com.example.reto3.entities.Tool;
import com.example.reto3.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Tool")
@CrossOrigin(origins = "*")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping("/all")
    public List<Tool> getAll() { return toolService.getAll();}

    @GetMapping("/{id}")
    public Optional<Tool> getTool(@PathVariable("id") int id){
        return toolService.getTool(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool save (@RequestBody Tool a) {return toolService.save(a);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool update (@RequestBody Tool a){return toolService.update(a);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return toolService.delete(id);
    }


}
