package raf.rs.VehicleService.repositories;

import org.hibernate.sql.results.jdbc.internal.JdbcValuesCacheHit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import raf.rs.VehicleService.model.Reservation;
import raf.rs.VehicleService.model.Vehicle;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findVehiclesByCompany_NameContainsAndCompany_CityContains(String company, String city);

//    List<Vehicle> findVehiclesByReservations

    @Query(value = "SELECT * FROM Vehicle v WHERE v.reservation_from_date NOT BETWEEN ?1 AND ?2 AND v.reservation_to_date NOT BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Vehicle> findVehiclesByRange(String fromDate, String toDate);
}
