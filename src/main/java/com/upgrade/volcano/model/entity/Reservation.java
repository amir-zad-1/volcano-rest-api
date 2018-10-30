package com.upgrade.volcano.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date reservationDateUTC;

    @NotBlank(message = "Please enter your Email.")
    private String email;

    @NotNull(message = "Please enter the arrival date.")
    private Date arrivalDateUTC;

    @NotNull(message = "Please enter the departure date.")
    private Date departureDateUTC;

    public Reservation() {
    }

    public Reservation (Long id, String email, Date arrivalDate, Date departureDate) {
        this.id = id;
        this.email = email;
        this.arrivalDateUTC = arrivalDate;
        this.departureDateUTC = departureDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getReservationDateUTC() {
        return reservationDateUTC;
    }

    public void setReservationDateUTC(Date reservationDateUTC) {
        this.reservationDateUTC = reservationDateUTC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getArrivalDateUTC() {
        return arrivalDateUTC;
    }

    public void setArrivalDateUTC(Date arrivalDateUTC) {
        this.arrivalDateUTC = arrivalDateUTC;
    }

    public Date getDepartureDateUTC() {
        return departureDateUTC;
    }

    public void setDepartureDateUTC(Date departureDateUTC) {
        this.departureDateUTC = departureDateUTC;
    }


}
