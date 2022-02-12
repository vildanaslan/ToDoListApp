package com.example.todolistapp.dbModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ToDoItem {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private String status;

}
/*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String todoItem;
    private String completed;

    public ToDoItem(String todoItem, String completed) {
        super();
        this.todoItem = todoItem;
        this.completed = completed;
    }
 */

