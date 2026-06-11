package com.smartCity.objects.applications;

import com.smartCity.objects.users.Admins;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ApplicationChoices")
public class ApplicationChoices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApplicationChoiceID")
    private Integer choiceID;

    @Column(name = "ApplicationType")
    private String applicationType;

    @Column(name = "Focus")
    private String focus;

    @Column(name = "Elements")
    private List<String> elements;

    @ManyToOne
    @JoinColumn(name = "ApplicationID")
    private Application application;
}
