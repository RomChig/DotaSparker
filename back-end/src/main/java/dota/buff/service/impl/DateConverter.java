package dota.buff.service.impl;

import lombok.experimental.UtilityClass;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@UtilityClass
public class DateConverter {
    private static final String DATE_PATTERN = "dd/MM/yyyy HH:mm";

    public static String convert(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
}
