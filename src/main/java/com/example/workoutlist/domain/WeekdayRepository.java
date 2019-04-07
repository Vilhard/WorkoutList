package com.example.workoutlist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WeekdayRepository extends CrudRepository<Weekday, Long>  {
	List<Weekday> findByDay(String day);
}
