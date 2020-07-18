package com.javatechie.jwt.api;

import com.javatechie.jwt.api.entity.User;
import com.javatechie.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtPocApplication {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init()
    {
        List<User> users = Stream.of(
                new User(101, "javatechie", "password", "javatechie@gmail.com"),
                new User(102, "user1", "pwd1", "user1@gmail.com"),
                new User(103, "user2", "pwd2", "user2@gmail.com"),
                new User(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtPocApplication.class, args);
    }

}
