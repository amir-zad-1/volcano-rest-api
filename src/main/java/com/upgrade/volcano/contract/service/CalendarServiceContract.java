package com.upgrade.volcano.contract.service;

import java.util.Date;
import java.util.List;

public interface CalendarServiceContract {

    void initialize();
    List<Date> getAvailableDates();

}
