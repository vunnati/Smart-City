package com.smartCity.repository;

import com.smartCity.objects.evStations.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations, Integer> {

    Reservations findByReservationID(Integer reservationID);
}
