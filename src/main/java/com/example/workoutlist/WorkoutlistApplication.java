package com.example.workoutlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.workoutlist.domain.ExcerciseRepository;
import com.example.workoutlist.domain.Weekday;
import com.example.workoutlist.domain.WeekdayRepository;
import com.example.workoutlist.domain.Weekdays;

@SpringBootApplication
public class WorkoutlistApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(WorkoutlistApplication.class, args);
		
	}

	@Bean
	public CommandLineRunner ExcerciseDemo(ExcerciseRepository erepository, WeekdayRepository wrepository) {
		return (args) -> {

			wrepository.save(new Weekday(Weekdays.MONDAY));
			wrepository.save(new Weekday(Weekdays.TUESDAY));
			wrepository.save(new Weekday(Weekdays.WEDNESDAY));
			wrepository.save(new Weekday(Weekdays.THURSDAY));
			wrepository.save(new Weekday(Weekdays.FRIDAY));
			wrepository.save(new Weekday(Weekdays.SATURDAY));
			wrepository.save(new Weekday(Weekdays.SUNDAY));
			
			
		};
	}
}
