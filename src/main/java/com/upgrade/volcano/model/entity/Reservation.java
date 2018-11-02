package com.upgrade.volcano.model.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;


    @Range(min = 1, max = 3, message = "Min = 1, Max = 3")
    private int duration;

    public Reservation() {
    }

    public Reservation(Long id, String email, Date arrivalDate, int duration) {
        this.id = id;
        this.email = email;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
        this.reservationDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.arrivalDate);
        calendar.add(Calendar.DATE, this.duration);
        return calendar.getTime();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
