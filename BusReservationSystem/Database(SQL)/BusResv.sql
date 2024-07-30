CREATE DATABASE BusResv;
USE BusResv;

CREATE TABLE Bus(
	ID INT PRIMARY KEY,
    AC BOOLEAN,
    Capacity INT
);
DROP TABLE BUS;
INSERT INTO Bus(ID,AC,Capacity)VALUES(1,0,2),(2,1,2),(3,0,5);

	SELECT * FROM Bus;

CREATE TABLE Booking(
	PassengerName VARCHAR(255),
    BusNO INT,
    Travel_Date Date
);

DROP TABLE Booking;
SELECT * FROM Booking;