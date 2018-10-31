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

    private Date reservationDate;

    @NotBlank(message = "Please enter your Email.")
    private String email;

    @NotNull(message = "Please enter the arrival date.")
    private Date arrivalDate;

    @NotNull(message = "Please enter the departure date.")
    private Date departureDate;

    public Reservation() {
    }

    public Reservation (Long id, String email, Date arrivalDate, Date departureDate) {
        this.id = id;
        this.email = email;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }


}
