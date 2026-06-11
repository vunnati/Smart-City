package com.smartCity.objects.evStations;

import com.smartCity.objects.users.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Reservations")
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReservationID")
    private Integer reservationID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "EvStationID")
    private Integer evStaionID;
}
