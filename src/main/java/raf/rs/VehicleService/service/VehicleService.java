package raf.rs.VehicleService.service;

import jakarta.servlet.Registration;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import raf.rs.VehicleService.model.Reservation;
import raf.rs.VehicleService.model.Vehicle;
import raf.rs.VehicleService.repositories.ReservationRepository;
import raf.rs.VehicleService.repositories.VehicleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class VehicleService implements VehicleServiceInterface {

    private VehicleRepository vehicleRepository;
    private ReservationRepository reservationRepository;

    public VehicleService(VehicleRepository vehicleRepository, ReservationRepository reservationRepository){
        this.vehicleRepository=vehicleRepository;
        this.reservationRepository=reservationRepository;
    }

    @Override
    public List<Vehicle> searchVehicles(String city, String companyName, String fromDate, String toDate) {
        List<Vehicle> l1 = vehicleRepository.findVehiclesByCompany_NameContainsAndCompany_CityContains(companyName,city);
//        l1.retainAll(vehicleRepository.findVehiclesByRange(fromDate,toDate));
//        List<Registration> arej = null;
        List<Vehicle> l2 = new ArrayList<>();
        List<Reservation> arej = reservationRepository.findReservationRange(fromDate, toDate);
        System.out.println("AREJ: " + arej.size());
        if(arej.size() == 0) return l1;
        for (Vehicle vehicle : l1) {
            for (Reservation reservation : arej) {
                if(reservation.getVehicle().getId() != vehicle.getId() && !l2.contains(vehicle)){
                    l2.add(vehicle);
                }
            }
        }

        return l2;
    }

    @Override
    public List<Vehicle> findVehiclesByRange(String fromDate, String toDate) {
        return vehicleRepository.findVehiclesByRange(fromDate, toDate);
    }

}
