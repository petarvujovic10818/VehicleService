package raf.rs.VehicleService.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import raf.rs.VehicleService.model.Vehicle;
import raf.rs.VehicleService.repositories.VehicleRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class VehicleService implements VehicleServiceInterface {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository=vehicleRepository;
    }

    @Override
    public List<Vehicle> searchVehicles(String city, String companyName, String fromDate, String toDate) {
        return vehicleRepository.findVehicles(companyName,city,fromDate,toDate);
    }

    @Override
    public List<Vehicle> searchByCity(String city, String companyName, Date fromDate) {
        return vehicleRepository.findVehiclesByCompany_CityContainsAndCompany_NameContainsAndFromDateNotBetween(city, companyName, fromDate);
    }

}
