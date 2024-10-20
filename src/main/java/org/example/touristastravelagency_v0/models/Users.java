package org.example.touristastravelagency_v0.models;

public class Users {
    public String username;
    public String pass;
    public String u_name;
    public Integer id_country;
    public Integer phone;
    public String email;
    public Boolean admin_role;

    public String getUsername () {return username;}
    public String getPass () {return pass;}
    public String getU_name () {return u_name;}
    public Integer getId_country () {return id_country;}
    public Integer getPhone () {return phone;}
    public String getEmail () {return email;}
    public Boolean getAdmin_role () {return admin_role;}
    public void setUsername (String username) {this.username = username;}
    public void setPass (String pass) {this.pass = pass;}
    public void setU_name (String u_name) {this.u_name = u_name;}
    public void setId_country (Integer id_country) {this.id_country = id_country;}
    public void setPhone (Integer phone) {this.phone = phone;}
    public void setEmail (String email) {this.email = email;}
    public void setAdmin_role(Boolean admin_role) {this.admin_role = admin_role;}


    public String LoginUser(){
        String loginUserStatement ="SELECT username,pass,admin_role FROM Users WHERE username=? AND pass = ?";
        return(loginUserStatement);
    }
    public String SignUpUser(){
        String SignUpUserStatement ="INSERT INTO Users (username,pass,u_name,id_country,phone,email,admin_role) VALUES (?,?,?,?,?,?,?)";
        return(SignUpUserStatement);
    }
    public void CheckEmail(String email){
        
    }
    public String UpdateUser(){
        String UpdateUserStatement ="UPDATE Users SET pass=?, u_name=?, id_country=?,phone=?,email=?,admin_role=? WHERE username=?";
        return(UpdateUserStatement);
    }
    public String ShowUser(){
        String ShowUserStatement ="SELECT pass,u_name,id_country,phone,email,admin_role FROM Users WHERE username=?";
        return(ShowUserStatement);
    }

}
