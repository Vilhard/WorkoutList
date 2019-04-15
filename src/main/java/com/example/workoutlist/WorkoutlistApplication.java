package com.example.workoutlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.workoutlist.domain.ExerciseRepository;
import com.example.workoutlist.domain.User;
import com.example.workoutlist.domain.UserRepository;

@SpringBootApplication
public class WorkoutlistApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(WorkoutlistApplication.class, args);
		
	}

	@Bean
	public CommandLineRunner ExerciseDemo(ExerciseRepository erepository, UserRepository urepository) {
		return (args) -> {
			User user1 = new User("user", "$2a$12$kMbnkMYyxMltYepVPiojFOQ8qllqvV5xLUvI/HWxdpQ3XSL137U36","USER");
			User user2 = new User("admin", "$2a$12$duP3QxbMpvnpwTlcLQO9JOHRVFvMWnsybLfMoohsB0rddXJJa4B.a","ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}
}
