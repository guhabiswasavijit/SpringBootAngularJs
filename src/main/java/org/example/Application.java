package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {
    @Value("${create.demo.user}")
    private boolean createDemoUser;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            if(createDemoUser) {
                Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                    User user = new User();
                    user.setEmail(name.toLowerCase() + "@domain.com");
                    user.setName(name);
                    userRepository.save(user);
                });
            }
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
