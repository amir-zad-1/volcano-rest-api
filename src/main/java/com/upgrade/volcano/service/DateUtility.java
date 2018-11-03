package com.upgrade.volcano.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
public class DateUtility {

    public Date[] getDateRange(Date startDate, int duration) {
        ArrayList<Date> dates = new ArrayList<>();
        Calendar calendar = this.getCalendar(startDate);
        calendar.add(Calendar.DATE, -1);

        for (int dayIndex = 0; dayIndex < duration; dayIndex++) {
            calendar.add(Calendar.DATE, 1);
            dates.add(calendar.getTime());
        }

        return dates.toArray(new Date[0]);
    }

    public Calendar getCalendar(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public String formateDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

}
