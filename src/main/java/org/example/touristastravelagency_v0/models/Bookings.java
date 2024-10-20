package org.example.touristastravelagency_v0.models;

import java.sql.Date;

public class Bookings {
    public int BookingID;
    public String username;
    public int PackageID;
    public Date BookingDate;
    public String BookingStatus;
    public String DestinationName;
    public String Country;
    public float Price;
    public int Duration;
    public Date StartDate;
    public Date EndDate;

    public int getBookingID() {
        return BookingID;
    }
    public void setBookingID(int bookingID) {this.BookingID = bookingID;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public int getPackageID() {return PackageID;}
    public void setPackageID(int packageID) {this.PackageID = packageID;}
    public Date getBookingDate() {return BookingDate;}
    public void setBookingDate(Date bookingDate) {this.BookingDate = bookingDate;}
    public String getBookingStatus() {return BookingStatus;}
    public void setBookingStatus(String bookingStatus) {this.BookingStatus = bookingStatus;}
    public String getDestinationName() {return DestinationName;}
    public void setDestinationName(String destinationName) {this.DestinationName = destinationName;}
    public String getCountry() {return Country;}
    public void setCountry(String country) {this.Country = country;}
    public float getPrice() {return Price;}
    public void setPrice(float price) {this.Price = price;}
    public int getDuration() {return Duration;}
    public void setDuration(int duration) {this.Duration = duration;}
    public Date getStartDate() {return StartDate;}
    public void setStartDate(Date startDate) {this.StartDate = startDate;}
    public Date getEndDate() {return EndDate;}
    public void setEndDate(Date endDate) {this.EndDate = endDate;}

    public String CreateBooking(){
        String CreateBookingStatement = "INSERT INTO Bookings(username,PackageID,BookingDate,BookingStatus) VALUES (?,?,?,?)";
        return (CreateBookingStatement);
    }
    public String ShowBooking(){
        String ShowBookingStatement = "SELECT d.d_name as DestinationName,c.country as Country,t.Price as Price,t.Duration as Duration,t.StartDate as StartDate,t.EndDate as EndDate,b.BookingID AS BookingID,b.BookingDate as BookingDate,b.BookingStatus as BookingStatus FROM destinations as d INNER JOIN Countries as c on d.id_country = c.id_country INNER JOIN travelpackages as t ON d.id= t.DestinationID INNER JOIN Bookings as b on t.PackageID = b.PackageID WHERE b.username=?";
        return (ShowBookingStatement);
    }
    public String ShowAllBooking(){
        String ShowAllBookingStatement = "SELECT d.d_name as DestinationName,c.country as Country,t.Price as Price,t.Duration as Duration,t.StartDate as StartDate,t.EndDate as EndDate,b.BookingID AS BookingID,b.username AS username,b.BookingDate as BookingDate,b.BookingStatus as BookingStatus FROM destinations as d INNER JOIN Countries as c on d.id_country = c.id_country INNER JOIN travelpackages as t ON d.id= t.DestinationID INNER JOIN Bookings as b on t.PackageID = b.PackageID";
        return (ShowAllBookingStatement);
    }
    public String CancelBooking(){
        String CancelBookingStatement = "DELETE FROM Bookings WHERE BookingID=? and username=?";
        return (CancelBookingStatement);
    }
    public String ChangeStatusBooking(){
        String ChangeStatusBookingStatement = "UPDATE Bookings SET BookingStatus=? WHERE bookingID=?";
        return (ChangeStatusBookingStatement);
    }
}
