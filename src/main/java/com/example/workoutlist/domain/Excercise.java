package com.example.workoutlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Excercise {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private int sets, reps;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "weekdayid")
	private Weekday weekday;
	
	public Excercise(){}
	
	public Excercise(String name, int sets, int reps, Weekday weekday){
		this.name = name;
		this.sets = sets;
		this.reps = reps;
		this.weekday = weekday;
	}
	
	public Weekday getWeekday() {
		return weekday;
	}

	public void setWeekday(Weekday weekday) {
		this.weekday = weekday;
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

	@Override
	public String toString() {
		return "Excercise [id=" + id + ", name=" + name + ", sets=" + sets + ", reps=" + reps + ", weekday=" + weekday
				+ "]";
	}
	

}
