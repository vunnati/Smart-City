package com.smartCity.objects.users;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserHistory")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HistoryID")
    private Integer historyID;

    @Column(name = "EvStationID")
    private Integer evStationID;

    @Column(name = "EVStationAddress")
    private String evStationAddress;

    @Column(name = "TimesUsed")
    private Integer timesUsed;

    @Column(name = "Action")
    private String action;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

}
