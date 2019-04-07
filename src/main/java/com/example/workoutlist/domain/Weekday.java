package com.example.workoutlist.domain;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Weekday {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long weekdayid;
	private String day;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "weekday")
	private List<Excercise> excercises;
	
	
	public Weekday() {
	}

	public Weekday(String day) {
		this.day = day;
	}

	public Long getWeekdayid() {
		return weekdayid;
	}

	public void setWeekdayid(Long weekdayid) {
		this.weekdayid = weekdayid;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Weekday [weekdayid=" + weekdayid + ", day=" + day + "]";
	}

}
