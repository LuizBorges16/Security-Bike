package com.luizborges.securitybike.domain;

import java.time.LocalDateTime;

public class SpeedReading {

    private int id;
    private int bikeId;
    private double speedKmh;
    private LocalDateTime recordedAt;

    public SpeedReading(int id, int bikeId, double speedKmh, LocalDateTime recordedAt) {
        this.id = id;
        this.bikeId = bikeId;
        this.speedKmh = speedKmh;
        this.recordedAt = recordedAt;
    }

    public int getId() {
        return this.id;
    }

    public int getBikeId() {
        return this.bikeId;
    }

    public double getSpeedKmh() {
        return this.speedKmh;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

}

