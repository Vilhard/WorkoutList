CREATE TABLE IF NOT EXISTS EXCERCISE (
	id int(5) NOT NULL AUTO_INCREMENT, 
	name varchar(255) DEFAULT NULL, 
	reps int(3) NOT NULL, 
	sets int(3) NOT NULL, 
	weekdayid int(5), 
	PRIMARY KEY (id)
	);

CREATE TABLE IF NOT EXISTS WEEKDAY(
	weekdayid int(5) NOT NULL AUTO_INCREMENT, 
	day VARCHAR(255), 
	PRIMARY KEY (weekdayid)
	);