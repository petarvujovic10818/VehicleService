package raf.rs.VehicleService.service;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import raf.rs.VehicleService.dto.ReservationDto;
import raf.rs.VehicleService.model.Reservation;
import raf.rs.VehicleService.repositories.ReservationRepository;

import java.util.List;

@Service
@Transactional
public class ReservationService implements ReservationServiceInterface{

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository=reservationRepository;
    }


    @Override
    public List<Reservation> getReservationByCompanyName(String companyName) {
        return null;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }
}
