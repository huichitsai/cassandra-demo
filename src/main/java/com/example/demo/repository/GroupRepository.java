package com.example.demo.repository;

import com.example.demo.model.Group;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, String> {
    
}
