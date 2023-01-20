package raf.rs.VehicleService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raf.rs.VehicleService.model.Reservation;
import raf.rs.VehicleService.model.Vehicle;
import raf.rs.VehicleService.service.ReservationService;
import raf.rs.VehicleService.service.VehicleService;

import java.lang.invoke.VarHandle;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleService vehicleService;
    private ReservationService reservationService;

    public VehicleController(VehicleService vehicleService, ReservationService reservationService){
        this.vehicleService = vehicleService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles(@RequestParam("company") String companyName, @RequestParam("city") String city, @RequestParam("from") String from, @RequestParam("to") String to){
        return new ResponseEntity<>(vehicleService.searchVehicles(city,companyName, from, to), HttpStatus.OK);
    }

    @GetMapping("/range")
    public ResponseEntity<List<Vehicle>> getVehiclesByRange(@RequestParam("from") String from, @RequestParam("to") String to){
        return new ResponseEntity<>(vehicleService.findVehiclesByRange(from, to), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveReservation(@RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.OK);
    }


}
