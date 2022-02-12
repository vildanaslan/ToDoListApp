package com.example.todolistapp;

import com.example.todolistapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ToDoListAppApplication {

    @Autowired
    public ToDoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ToDoListAppApplication.class, args);
    }


    /*
    @Override
    public void run(String... args) throws Exception {

        Collection<ToDoItem> todos = Arrays.asList(new ToDoItem("Learn Spring", "Yes"), new ToDoItem("Learn Driving", "No"), new ToDoItem("Go for a Walk", "No"), new ToDoItem("Cook Dinner", "Yes"));
        todos.forEach(todoRepository::save);

    }

 */
}

