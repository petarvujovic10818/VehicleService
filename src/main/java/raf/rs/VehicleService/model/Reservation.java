package raf.rs.VehicleService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromDate;

    private String toDate;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private User user;

    @Transient //nece se perzistovati u bazi (racuna se na osnovu (toDate-fromDate) * pricePerDay)
    private int price;

}
