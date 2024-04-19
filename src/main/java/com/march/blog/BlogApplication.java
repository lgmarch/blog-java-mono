package com.march.blog;

import com.march.blog.persistence.UserEntity;
import com.march.blog.persistence.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(BlogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
		LOGGER.info("* Blog Started *");
	}

	@Override
	public void run(String... args) {
		UserEntity user1 = new UserEntity(1, "Bob", "bob@mail.com", "123");
		UserEntity user2 = new UserEntity(2, "Jon", "jon@mail.com", "123");

		userRepository.saveAll(Arrays.asList(user1, user2));

		for (UserEntity user : userRepository.findAll()) {
			LOGGER.info(user.getName() + " " + user.getEmail());
		}
	}
}
