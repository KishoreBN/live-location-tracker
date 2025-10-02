package org.live.location.tracker.DTO;

import java.time.LocalDateTime;

public class LocationSnapshot {
    private long driver_id;
    private long order_id;
    private double latitude;
    private double longitude;
    private double speed;
    private LocalDateTime timestamp;

    public LocationSnapshot() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"driver_id\":" + driver_id +
                ", \"order_id\":" + order_id +
                ", \"latitude\":" + latitude +
                ", \"longitude\":" + longitude +
                ", \"speed\":" + speed +
                ", \"timestamp\":" + timestamp +
                '}';
    }

    public LocationSnapshot(long driverId, long orderId, double latitude, double longitude, double speed, LocalDateTime timestamp) {
        driver_id = driverId;
        order_id = orderId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.timestamp = timestamp;
    }

    public void setDriver_id(long driver_id) {
        this.driver_id = driver_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public long getDriver_id() {
        return driver_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getSpeed() {
        return speed;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
