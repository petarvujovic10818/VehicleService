package raf.rs.VehicleService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import raf.rs.VehicleService.model.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationByVehicle_Company_NameContains(String companyName);

    @Query(value="SELECT * FROM Reservation r where r.from_date BETWEEN ?1 AND ?2 OR r.to_date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Reservation> findReservationRange(String dateFrom, String dateTo);


}
