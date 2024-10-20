package org.example.touristastravelagency_v0.models;

public class Countries {
    public int id_country;
    public String country;

    public String getCountry() {return country;}

    public int getIdCountry() {
        return id_country;
    }
    public void setIdCountry(int id_country) {this.id_country = id_country;}
    public void setCountry(String country) {this.country = country;}




    public String getCountryName(){
        String getCountryNameStatement = "SELECT id_country, country FROM Countries";
        return (getCountryNameStatement);
    }
}
