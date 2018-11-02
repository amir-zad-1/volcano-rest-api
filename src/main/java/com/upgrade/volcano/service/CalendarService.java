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

    @Autowired
    DateUtility dateUtility;


    private void reset() {
        this.calendarRepository.deleteAll();
    }

    @Override
    public void initialize() {

        Calendar calendar = this.dateUtility.getCalendar(new Date());

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
                .map(ReservationCalendar::getDate)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean updateAvailableDate(Date date, Boolean availability) {
        ReservationCalendar calendarDay = this.calendarRepository.findByDate(date);
        if (calendarDay == null) return false;

        calendarDay.setIsAvailable(availability);
        this.calendarRepository.save(calendarDay);
        return true;
    }

    @Override
    public Boolean isAvailable(Date date) {
        ReservationCalendar calendarDay = this.calendarRepository.findByDate(date);
        if (calendarDay != null) {
            return calendarDay.getIsAvailable();
        } else {
            return false;
        }
    }

    @Override
    public Boolean isAvailable(Date date, int duration) {
        Date[] dates = this.dateUtility.getDateRange(date, duration);
        for (Date day: dates) {
            Boolean isAvailable = this.isAvailable(day);
            if (!isAvailable) return false;
        }
        return true;
    }

}
