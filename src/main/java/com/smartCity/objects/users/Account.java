package com.smartCity.objects.users;

import lombok.*;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private Integer accountID;

    @Column(name = "Username")
    private String username;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Phone Number")
    private String phoneNumber;

    @Column(name = "Role")
    private String role;

}
