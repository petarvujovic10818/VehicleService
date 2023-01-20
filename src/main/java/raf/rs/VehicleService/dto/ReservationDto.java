package raf.rs.VehicleService.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import raf.rs.VehicleService.model.User;
import raf.rs.VehicleService.model.Vehicle;

@Data
@Setter
@Getter
public class ReservationDto {

    private String fromDate;

    private String toDate;

    private Vehicle vehicle;

    private User user;

}
