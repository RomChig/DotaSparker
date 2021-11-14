package dota.buff.service.impl;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateConverter {
    private static final String DATE_PATTERN = "dd/MM/yyyy HH:mm";

    public static String convert(Instant date) {
        return date.atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
}
