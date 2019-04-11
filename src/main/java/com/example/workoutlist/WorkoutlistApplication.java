package com.example.workoutlist;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.workoutlist.domain.Exercise;
import com.example.workoutlist.domain.ExerciseRepository;


@SpringBootApplication
public class WorkoutlistApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(WorkoutlistApplication.class, args);
		
	}

	@Bean
	public CommandLineRunner ExerciseDemo(ExerciseRepository erepository) {
		return (args) -> {
			erepository.save(new Exercise("Maastaveto",2,10,2L));
			erepository.save(new Exercise("Leuanveto", 3, 10,1L));
			erepository.save(new Exercise("Kulmasoutu", 3, 10,3L));
		};
	}
}
