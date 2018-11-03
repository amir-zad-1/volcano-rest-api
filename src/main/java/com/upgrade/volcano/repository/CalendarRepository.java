package com.upgrade.volcano.repository;


import com.upgrade.volcano.model.entity.ReservationCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<ReservationCalendar, Long> {

    List<ReservationCalendar> findByIsAvailable(boolean availabilityStatus);

    ReservationCalendar findByDate(Date date);

}
