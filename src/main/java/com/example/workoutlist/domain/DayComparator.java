package com.example.workoutlist.domain;

import java.util.Comparator;

public class DayComparator implements Comparator<Weekday>{

	@Override
	public int compare(Weekday d1, Weekday d2) {
		return d1.getDay().compareTo(d2.getDay());
	}

}
