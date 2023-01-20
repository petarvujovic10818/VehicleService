package raf.rs.VehicleService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String model;

    private int price;

    private String fromDate;

    private String toDate;

    @ManyToOne(optional = false)
    private Company company;

}
