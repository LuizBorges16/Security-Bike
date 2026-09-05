package com.luizborges.securitybike.service;

import com.luizborges.securitybike.domain.SpeedReading;
import java.util.List;
import java.time.Duration;
import java.time.LocalDateTime;

public class LockService {
    private static final double STOPPED_SPEED_KMH = 0.1;
    private static final double MAX_SPEED_KMH = 3.0;
    private static final int MIN_SECONDS_BELOW = 5;
    private static final int MAX_READING_AGE_SECONDS = 10;

    public boolean canLock(List<SpeedReading> readings) {

        if (readings.isEmpty()) {
            return false;
        }

        SpeedReading last = readings.get(readings.size() - 1);
        long idadeEmSegundos = Duration.between(last.getRecordedAt(), LocalDateTime.now()).getSeconds();


        if (idadeEmSegundos > MAX_READING_AGE_SECONDS) {
            return false;
        }

        if (last.getSpeedKmh() < STOPPED_SPEED_KMH) {
            return true;
        }

        SpeedReading first = readings.get(0);
        long coberturaSegundos = Duration.between(first.getRecordedAt(), LocalDateTime.now()).getSeconds();
        if (coberturaSegundos < MIN_SECONDS_BELOW) {
            return false;
        }
        LocalDateTime windowStart = LocalDateTime.now().minusSeconds(MIN_SECONDS_BELOW);
        for (SpeedReading r : readings){
            if (r.getRecordedAt().isAfter(windowStart) && r.getSpeedKmh() >= MAX_SPEED_KMH){
                return false;
            }
        }

        return true;
    }
}
