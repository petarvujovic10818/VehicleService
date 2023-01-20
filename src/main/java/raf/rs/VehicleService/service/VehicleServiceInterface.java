package raf.rs.VehicleService.service;

import raf.rs.VehicleService.model.Vehicle;

import java.util.Date;
import java.util.List;

public interface VehicleServiceInterface {

    List<Vehicle> searchVehicles(String city, String companyName, String fromDate, String toDate);

    List<Vehicle> searchByCity(String city, String company, Date fromDate);

}
