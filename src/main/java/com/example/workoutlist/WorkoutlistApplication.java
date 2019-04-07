package com.example.workoutlist;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.workoutlist.domain.Excercise;
import com.example.workoutlist.domain.ExcerciseRepository;
import com.example.workoutlist.domain.Weekday;
import com.example.workoutlist.domain.WeekdayRepository;

@SpringBootApplication
public class WorkoutlistApplication {
	private static final Logger log = LoggerFactory.getLogger(WorkoutlistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WorkoutlistApplication.class, args);
		
		
	}

	@Bean
	public CommandLineRunner ExcerciseDemo(ExcerciseRepository erepository, WeekdayRepository wrepository) {
		return (args) -> {

			wrepository.save(new Weekday("Monday"));
			wrepository.save(new Weekday("Tuesday"));
			wrepository.save(new Weekday("Wednesday"));
			wrepository.save(new Weekday("Thursday"));
			wrepository.save(new Weekday("Friday"));
			wrepository.save(new Weekday("Saturday"));
			wrepository.save(new Weekday("Sunday"));
			
			erepository.save(new Excercise("Barbell Bench Press", 3, 10, wrepository.findByDay("Monday").get(0)));
			erepository.save(new Excercise("Barbell Incline Bench Press", 2, 10, wrepository.findByDay("Monday").get(0)));
			erepository.save(new Excercise("Dips - Chest Version", 2, 8, wrepository.findByDay("Monday").get(0)));
			erepository.save(new Excercise("Close-grip Barberll Bench Press", 2, 10, wrepository.findByDay("Monday").get(0)));
			erepository.save(new Excercise("Lying Dumbell Triceps Extension", 3, 10, wrepository.findByDay("Monday").get(0)));
			erepository.save(new Excercise("Reverse Grip Triceps Pushdown", 1, 10, wrepository.findByDay("Monday").get(0)));
			erepository.save(new Excercise("Dumbbell Shoulder press", 2, 10, wrepository.findByDay("Wednesday").get(0)));
			erepository.save(new Excercise("Leg Press", 2, 12, wrepository.findByDay("Tuesday").get(0)));
		};
	}
}
