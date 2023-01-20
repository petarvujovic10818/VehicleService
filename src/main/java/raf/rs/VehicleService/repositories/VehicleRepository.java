package raf.rs.VehicleService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import raf.rs.VehicleService.model.Vehicle;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findVehiclesByCompany_NameOrCompany_CityOrFromDateGreaterThanEqualAndToDateLessThanEqual(String companyName, String companyCity, Date fromDate, Date toDate);

    List<Vehicle> findVehiclesByCompany_CityContainsAndCompany_NameContainsAndFromDateNotBetween(String city, String companyName, Date fromDate);

    @Query(value = "SELECT * FROM Vehicle v where v.company_name LIKE %?1% and v.company_city LIKE %?2% and v.fromDate NOT BETWEEN ?3 AND ?4 and v.toDate NOT BETWEEN ?3 AND ?4", nativeQuery = true)
    List<Vehicle> findVehicles(String companyName, String companyCity, String fromDate, String toDate);
}
