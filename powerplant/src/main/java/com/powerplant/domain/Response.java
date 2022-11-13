package com.powerplant.domain;

import java.util.List;

/**
 * This class is for building response for batteries names
 * and average and total watt capacity
 */
public class Response {
    private List<String> batteryNames;

    public List<String> getBatteryNames() {
        return batteryNames;
    }

    public void setBatteryNames(List<String> batteryNames) {
        this.batteryNames = batteryNames;
    }

    private double average;
    private double total;

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
