package com.example.sidcloud.Controller;

import com.example.sidcloud.Repository.AppleRepository;
import com.example.sidcloud.model.entity.Apple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import lombok.Data;

import java.util.List;

@RestController
@RequestMapping("/apples")
public class AppleController {

    @Autowired
    private AppleRepository appleRepository;

    public AppleController(AppleRepository appleRepository){
        this.appleRepository= appleRepository;
    }

    @GetMapping
    public List<Apple> getAllApples(){
        return appleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Apple getAppleById(@PathVariable Long id){
        return appleRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Apple createApple(@RequestBody Apple apple){
        return appleRepository.save(apple);
    }

    @PutMapping("/{id}")
    public Apple updateApple(@PathVariable Long id, @RequestBody Apple newApple){
        Apple existingApple = appleRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Apple not found"));
        existingApple.setAppleName(newApple.getAppleName());

        appleRepository.save(existingApple);
        return existingApple;
    }

    @DeleteMapping("/{id}")
    public void deleteApple(Long id){
        appleRepository.deleteById(id);
    }

}
