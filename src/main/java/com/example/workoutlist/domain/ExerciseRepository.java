package com.example.workoutlist.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
* Spring Data repository for the Exercise entity.
*/
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
	List<Exercise> findByName(String name);
	
	//	Exercises in Ascending order
	@Query(value="SELECT * FROM EXERCISE ORDER BY WEEKDAYID ASC",nativeQuery=true)
	List<Exercise> findAllOrderByWeekdayid();
}
