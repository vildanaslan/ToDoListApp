package com.example.todolistapp.service;

import com.example.todolistapp.dbModel.User;
import com.example.todolistapp.dto.UserDto;
import com.example.todolistapp.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    final Logger logger = LogManager.getLogger(LoginService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DozerBeanMapper mapper;

    public void register(UserDto userDto){
        User user = mapper.map(userDto, User.class);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        logger.debug("Password of user with username: {} encoded!", user.getUsername());

        userRepository.save(user);
        logger.info("New user: {} created!", user);
    }
}
