package com.upgrade.volcano.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class ReservationAvailability {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean isAvailable;

    private Date desiredDate;

    public ReservationAvailability() {
    }

    public ReservationAvailability(Long id, Boolean isAvailable, Date desiredDate) {

        this.id = id;
        this.isAvailable = isAvailable;
        this.desiredDate = desiredDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Date getDesiredDate() {
        return desiredDate;
    }

    public void setDesiredDate(Date desiredDate) {
        this.desiredDate = desiredDate;
    }

}
