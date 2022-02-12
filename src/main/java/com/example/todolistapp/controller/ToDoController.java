package com.example.todolistapp.controller;


import com.example.todolistapp.dto.ToDoItemDto;
import com.example.todolistapp.repository.ToDoRepository;
import com.example.todolistapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDoController {

    @Autowired
    ToDoRepository todoRepository;

    @Autowired
    private ToDoService todoService;


    @GetMapping(value = "/todolist")
    public String getAll(Model model){

        model.addAttribute("todolist",todoService.getAllItems());
        return "todolist";
    }

    @PostMapping(value = "/createToDoItem")
    public String createNewItem(String title, String description, String status, Model model){
        ToDoItemDto itemDto = ToDoItemDto.builder()
                .title(title)
                .description(description)
                .status(status)
                .build();

        todoService.createItem(itemDto);

        model.addAttribute("todolist", todoService.getAllItems());
        return "todolist";
    }

    @RequestMapping(value = "/updateToDoItem/{id}")
    public String updateItem(@PathVariable Long id, Model model){
        todoService.updateItem(id);

        model.addAttribute("todolist", todoService.getAllItems());
        return "todolist";
    }

    @RequestMapping(value = "/deleteToDoItem/{id}")
    public String  deleteItem(@PathVariable Long id, Model model){
        todoService.deleteItem(id);

        model.addAttribute("todolist", todoService.getAllItems());
        return "todolist";
    }
}