package com.upgrade.volcano.contract.service;

import java.util.Date;
import java.util.List;

public interface CalendarServiceContract {

    void initialize();

    List<Date> getAvailableDates();

    Boolean updateAvailableDate(Date date, Boolean availability);

    Boolean isAvailable(Date date);

    Boolean isAvailable(Date date, int duration);

    void deleteAll();

}
