package com.upgrade.volcano.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ReservationCalendar {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean isAvailable;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public ReservationCalendar() {
    }

    public ReservationCalendar(Long id, Boolean isAvailable, Date date) {

        this.id = id;
        this.isAvailable = isAvailable;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean available) {
        isAvailable = available;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
