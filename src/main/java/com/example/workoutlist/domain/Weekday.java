package com.example.workoutlist.domain;

public enum Weekday {
	MONDAY(1L), TUESDAY(2L), WEDNESDAY(3L), THURSDAY(4L), FRIDAY(5L), SATURDAY(6L), SUNDAY(7L);

	private Long numVal;

	public static String getByValue(Long value) {
		if (value == null)
			return null;
		if(1L == value)	
			return "Maanantai";
		if(2L == value)	
			return "Tiistai";
		if(3L == value)	
			return "Keskiviikko";
		if(4L == value)	
			return "Torstai";
		if(5L == value)	
			return "Perjantai";
		if(6L == value)	
			return "Lauantai";
		if(7L == value)	
			return "Sunnuntai";
		return null;
	}

	public static Long getByName(String Name) {
		if("Maanantai".equals(Name))	
			return 1L;
		if("Tiistai".equals(Name))	
			return 2L;
		if("Keskiviikko".equals(Name))	
			return 3L;
		if("Torstai".equals(Name))	
			return 4L;
		if("Perjantai".equals(Name))	
			return 5L;
		if("Lauantai".equals(Name))	
			return 6L;
		if("Sunnuntai".equals(Name))	
			return 7L;
		return null;
	}
	
	Weekday(Long numVal) {
		this.numVal = numVal;
	}

	public long getNumVal() {
		return numVal;
	}
}