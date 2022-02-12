package com.example.todolistapp.service;

import com.example.todolistapp.dbModel.ToDoItem;
import com.example.todolistapp.dto.ToDoItemDto;
import com.example.todolistapp.repository.ToDoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoService {


    final Logger logger = LogManager.getLogger(ToDoService.class);

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDoItemDto> getAllItems(){

        return toDoRepository.findAll().stream().map(item -> dozerBeanMapper.map(item, ToDoItemDto.class)).collect(Collectors.toList());
    }

    public Long createItem(ToDoItemDto itemDto){
        ToDoItem item = dozerBeanMapper.map(itemDto, ToDoItem.class);

        logger.debug("New to do item: {} will be created!", item);
        toDoRepository.save(item);
        logger.info("New to do item: {} created!", item);

        return item.getId();
    }

    public Long updateItem(Long id){
        Optional<ToDoItem> toBeUpdated = toDoRepository.findById(id);

        if(toBeUpdated.isPresent()){
            if(toBeUpdated.get().getStatus().equals("TODO")){
                toBeUpdated.get().setStatus("Completed");
                logger.info("To do item with id: {} updated!", id);
            }else {toBeUpdated.get().setStatus("TODO");}
            toDoRepository.save(toBeUpdated.get());
            return id;
        }

        return null;
    }

    public Long deleteItem(Long id){
        Optional<ToDoItem> toBeUpdated = toDoRepository.findById(id);
        if(toBeUpdated.isPresent()) {
            toDoRepository.deleteById(id);
            logger.info("To do item with id: {} deleted!", id);
            return id;
        }
        return null;
    }

}
