package com.example.todolistapp.repository;

import com.example.todolistapp.dbModel.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoItem, Long> {

}
