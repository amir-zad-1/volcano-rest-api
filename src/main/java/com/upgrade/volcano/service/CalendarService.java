package com.upgrade.volcano.service;

import com.upgrade.volcano.contract.service.CalendarServiceContract;
import com.upgrade.volcano.model.entity.ReservationCalendar;
import com.upgrade.volcano.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarService implements CalendarServiceContract {

    int AVAILABLE_DAYS_IN_CALENDAR = 30;

    @Autowired
    CalendarRepository calendarRepository;


    private void reset() {
        this.calendarRepository.deleteAll();
    }

    @Override
    public void initialize() {

        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        this.reset();

        for (Boolean notUsed : new Boolean[AVAILABLE_DAYS_IN_CALENDAR]) {
            calendar.add(Calendar.DATE, 1);
            this.calendarRepository.save(new ReservationCalendar(null, true, calendar.getTime()));
        }
    }

    @Override
    public List<Date> getAvailableDates() {
        return this.calendarRepository
                .findByIsAvailable(true)
                .stream()
                .map(ReservationCalendar::getDay)
                .collect(Collectors.toList());
    }
}
