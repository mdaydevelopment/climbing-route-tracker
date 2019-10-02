CREATE TABLE climber (
	climber_id 		INT NOT NULL AUTO_INCREMENT,
	first_name		VARCHAR(30) NOT NULL,
	last_name		VARCHAR(30) NOT NULL,
	dob				DATE NOT NULL,
	PRIMARY KEY(climber_id)
);

CREATE TABLE route (
	route_id 		INT NOT NULL AUTO_INCREMENT,
	name 			VARCHAR(100) NOT NULL,
	difficulty 		VARCHAR(8) NOT NULL,
	notes 			VARCHAR(200),
	PRIMARY KEY(route_id)
);

CREATE TABLE ascent (
	ascent_id 		INT NOT NULL AUTO_INCREMENT,
	climber_id 		INT NOT NULL,
	route_id 		INT NOT NULL,
	send_date   	DATE NOT NULL,
	PRIMARY KEY(ascent_id),
	FOREIGN KEY(climber_id) REFERENCES climber(climber_id),
	FOREIGN KEY(route_id) REFERENCES route(route_id)
);

