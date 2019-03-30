package com.example.workoutlist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExcerciseRepository extends CrudRepository<Excercise, Long> {

	List<Excercise> FindByName(String name);
}
