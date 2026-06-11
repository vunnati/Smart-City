package com.smartCity.objects.applications;


import com.smartCity.objects.users.Admins;
import lombok.Data;
import jakarta.persistence.*;


@Data
@Entity
@Table(name = "Application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApplicationID")
    private Integer applicationID;

    @ManyToOne
    @JoinColumn(name = "AdminID")
    private Admins admins;

    @Column(name = "ApplicationName")
    private String applicationName;

    @Column(name = "Application Password")
    private String password;

    @Column(name = "Image Name")
    private String imageName;

    @Column(name = "Application Type")
    private String applicationType;

    @Column(name = "Customized")
    private boolean customized;

}
