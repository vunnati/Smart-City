package com.smartCity.objects.users;


import com.smartCity.objects.applications.Application;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Admin")
public class Admins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdminID")
    private Integer adminID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "ApplicationID")
    private Application application;

}
