package org.example.touristastravelagency_v0.models;

import java.sql.Date;

public class Destinations {
public int id;
public String d_name;
public String d_description;
public int id_country;
public String attractions;
public String image;
public int freq;
public int PackageID;
public int DestinationID;
public float Price;
public int Duration;
public Date StartDate;
public Date EndDate;
public String CountryName;


    public int getId() {
        return id;
    }
    public void setId(int id) {this.id=id;}
    public String getD_name() {return d_name;}
    public void setD_name(String d_name) {this.d_name = d_name;}
    public String getD_description() {return d_description;}
    public void setD_description(String d_description) {this.d_description = d_description;}
    public int getId_country() {return id_country;}
    public void setId_country(int id_country) {this.id_country=id_country;}
    public String getAttractions() {return attractions;}
    public void setAttractions(String attractions) {this.attractions = attractions;}
    public String getImage() {return image;}
    public void setImage(String image) {this.image = image;}
    public int getFreq() {return freq;}
    public void setFreq(int freq) {this.freq = freq;}
    public int getPackageID () {return PackageID;}
    public void setPackageID(int PackageID) {this.PackageID = PackageID;}
    public int getDestinationID () {return DestinationID;}
    public void setDestinationID(int DestinationID) {this.DestinationID = DestinationID;}
    public float getPrice() {return Price;}
    public void setPrice(float Price) {this.Price = Price;}
    public int getDuration() {return Duration;}
    public void setDuration(int Duration) {this.Duration = Duration;}
    public Date getStartDate() {return StartDate;}
    public void setStartDate(Date StartDate) {this.StartDate = StartDate;}
    public Date getEndDate() {return EndDate;}
    public void setEndDate(Date EndDate) {this.EndDate = EndDate;}
    public String getCountryName() {return CountryName;}
    public void setCountryName(String CountryName) {this.CountryName = CountryName;}

    public String popularDestinations(){
        String popularDestinationsStatement = "SELECT id , d_name as DestinationName,image, freq FROM destinations ORDER BY freq DESC LIMIT 5";
        return (popularDestinationsStatement);
    }
    public String updateFreq(){
        String updateFreqStatement = "UPDATE Destinations SET freq = freq+1 WHERE id = ?";
        return (updateFreqStatement);
    }
    public String allDestinations(){
        String allDestinationsStatement = "SELECT d.id as D_id,d.d_name as DestinationName," +
                "d.image as Image,c.country AS CountryName,d.freq as Freq FROM destinations AS d " +
                "INNER JOIN countries AS c ON d.id_country = c.id_country";
        return (allDestinationsStatement);
    }
    public String showDestInfo(){
        String showDestInfoStatement = "SELECT d.id as id, d.d_name as DestinationName, d.d_description as TripDescription," +
                "d.attractions as Attractions,d.image as Image, d.freq as Freq,t.PackageID as PackageID,t.price as TripPrice, " +
                "t.Duration as TripDuration, t.StartDate as TripStart,t.EndDate as TripEnd, d.id_country as CountryID, c.country as Country " +
                "FROM destinations AS d INNER JOIN travelpackages AS t ON d.id= t.DestinationID " +
                "INNER JOIN countries AS c ON c.id_country = d.id_country " +
                "WHERE id=?";
        return (showDestInfoStatement);
    }
    public String EditDestination(){
        String EditDestinationStatement = "UPDATE Destinations SET d_name=?, d_description=?, id_country=?,attractions=?,image=? WHERE id=?";
        return (EditDestinationStatement);
    }
    public String EditTravelPackages(){
        String EditTravelPackagesStatement = "UPDATE TravelPackages SET Price=?, Duration=?, StartDate=?,EndDate=? WHERE PackageID=? ";
        return (EditTravelPackagesStatement);
    }
    public String DeleteTravelPackages(){
        String DeleteTravelPackagesStatement = "DELETE FROM Travelpackages where PackageID = ?";
        return (DeleteTravelPackagesStatement);
    }
    public String DeleteAllTravelPackages(){
        String DeleteTravelPackagesStatement = "DELETE FROM Travelpackages where DestinationID = ?";
        return (DeleteTravelPackagesStatement);
    }
    public String DeleteDestination(){
        String DeleteTravelPackagesStatement = "DELETE FROM Destinations WHERE id=?";
        return (DeleteTravelPackagesStatement);
    }
    public String CreateDestination(){
        String CreateDestinationStatement = "INSERT INTO Destinations (d_name,d_description,id_country,attractions,image,freq) VALUES(?,?,?,?,?,?)";
        return (CreateDestinationStatement);
    }
    public String CreateTravelPackages(){
        String CreateTravelPackagesStatement = "INSERT INTO TravelPackages (DestinationID,Price,Duration,StartDate,EndDate) VALUES(?,?,?,?,?)";
        return (CreateTravelPackagesStatement);
    }
    public String AdvancedSearch(){
        String AdvancedSearchStatement = "SELECT d.id as D_id,d.d_name as DestinationName, d.image as Image,c.country AS CountryName,d.freq as Freq FROM destinations as d INNER JOIN travelpackages as t on d.id = t.destinationID INNER JOIN countries as c on d.id_country = c.id_country WHERE d.id_country = ? AND t.price <= ? AND t.StartDate >= ?";
        return (AdvancedSearchStatement);
    }
    public String AddTravelPackage(){
        String AddTravelPackageStatement = "INSERT INTO travelpackages (DestinationID, price, duration, startDate, endDate) VALUES (?, ?, ?, ?, ?)";
        return (AddTravelPackageStatement);
    }
}
