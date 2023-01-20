package raf.rs.VehicleService.service;

import raf.rs.VehicleService.dto.ReservationDto;
import raf.rs.VehicleService.model.Reservation;

import java.util.List;

public interface ReservationServiceInterface {

    List<Reservation> getReservationByCompanyName(String companyName);

    Reservation addReservation(Reservation reservation);

}
