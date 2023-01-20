package raf.rs.VehicleService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import raf.rs.VehicleService.model.Vehicle;
import raf.rs.VehicleService.service.VehicleService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/pls")
    public ResponseEntity<List<Vehicle>> getVehicles(@RequestParam("company") String companyName, @RequestParam("city") String city, @RequestParam("from") String from, @RequestParam("to") String to){
        return new ResponseEntity<>(vehicleService.searchVehicles(city,companyName,from,to), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getVhs(@RequestParam("city") String city, @RequestParam("company") String companyName, @RequestParam("from") Date fromDate){
        return new ResponseEntity<>(vehicleService.searchByCity(city, companyName, fromDate), HttpStatus.OK);
    }

}
