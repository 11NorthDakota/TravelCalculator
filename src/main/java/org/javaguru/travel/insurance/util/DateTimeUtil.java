package org.javaguru.travel.insurance.util;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.Period;

@Component
public class DateTimeUtil {
    public int calculateDaysBetween(LocalDate from, LocalDate to) {
        int errorCode = -9999999;
        if(from == null || to == null) return errorCode;
        return Period.between(from,to).getDays();
    }
}
