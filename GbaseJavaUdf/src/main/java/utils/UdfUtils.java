package utils;

import java.util.HashMap;
import java.util.Map;

public class UdfUtils {

    private static final Map<String, Long> TIME_MAP = new HashMap<>();

    static {
        TIME_MAP.put("d", 1000L * 60 * 60 * 24);
        TIME_MAP.put("day", 1000L * 60 * 60 * 24);
        TIME_MAP.put("h", 1000L * 60 * 60);
        TIME_MAP.put("hour", 1000L * 60 * 60);
        TIME_MAP.put("m", 1000L * 60);
        TIME_MAP.put("minute", 1000L * 60);
        TIME_MAP.put("s", 1000L);
        TIME_MAP.put("second", 1000L);
    }

    /**
     * Parses a time string in the format of a number followed by a unit (e.g., "1d", "15h", "30m").
     * @param time the time string to parse
     * @return the time duration in milliseconds
     * @throws IllegalArgumentException if the format is invalid or the unit is unrecognized
     */
    public static long parseTime(String time) {
        if (time == null || time.isEmpty()) {
            throw new IllegalArgumentException("Time string cannot be null or empty");
        }
        StringBuilder valueBuilder = new StringBuilder();
        StringBuilder unitBuilder = new StringBuilder();
        for (char c : time.toCharArray()) {
            if (Character.isDigit(c)) {
                valueBuilder.append(c);
            } else {
                unitBuilder.append(c);
            }
        }
        if (valueBuilder.length() == 0 || unitBuilder.length() == 0) {
            throw new IllegalArgumentException("Invalid time format: " + time);
        }
        long value;
        try {
            value = Long.parseLong(valueBuilder.toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric value in time string: " + time, e);
        }
        String unit = unitBuilder.toString();
        Long multiplier = TIME_MAP.get(unit);
        if (multiplier == null) {
            throw new IllegalArgumentException("Unknown time unit: " + unit);
        }
        return value * multiplier;
    }
}
