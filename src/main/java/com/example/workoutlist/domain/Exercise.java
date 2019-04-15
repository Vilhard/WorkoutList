package com.example.workoutlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Exercise {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private int sets, reps;
	private Long weekdayid;
	
	public Exercise(){}
	
	public Exercise(String name, int sets, int reps, Long weekdayid) {
		this.name = name;
		this.sets = sets;
		this.reps = reps;
		this.weekdayid = weekdayid;
	}

	public Long getDay() {
		return weekdayid;
	}

	public void setDay(Long weekdayid) {
		this.weekdayid = weekdayid;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
}
