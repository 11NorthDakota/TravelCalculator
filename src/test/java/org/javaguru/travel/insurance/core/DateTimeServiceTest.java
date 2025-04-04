package org.javaguru.travel.insurance.core;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeServiceTest {

    private final DateTimeService dts = new DateTimeService();

    @Test
    void calculateDaysBetweenPositiveTest() {
        LocalDate dateFrom = createDate("26.02.2025");
        LocalDate dateTo = createDate("27.02.2025");
        assertEquals(dts.calculateDaysBetween(dateFrom, dateTo),1);
    }

    @Test
    void calculateDaysBetweenNegativeTest() {
        LocalDate dateFrom = createDate("26.02.2025");
        LocalDate dateTo = createDate("24.02.2025");
        assertEquals(dts.calculateDaysBetween(dateFrom, dateTo),-2 );
    }


    private LocalDate createDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, dtf);
    }

}