package com.bridgelabz.userregistration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.userregistration.dto.UserDTO;

import lombok.Data;

@Data
@Entity
@Table(name="User_Data")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id")
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserData(){

    }

    public UserData(UserDTO userDTO){
        this.firstName = userDTO.firstName;
        this.lastName = userDTO.lastName;
        this.email = userDTO.email;
        this.password = userDTO.password;
    }
}