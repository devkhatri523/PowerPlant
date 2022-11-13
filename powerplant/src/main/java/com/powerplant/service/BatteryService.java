package com.powerplant.service;


import com.powerplant.Exceptions.NotFoundException;
import com.powerplant.domain.Battery;
import com.powerplant.domain.Response;
import com.powerplant.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryService  {
    @Autowired
    private  BatteryRepository batteryRepository;

    public Response getBatteriesWithStatistics(String from, String to) {
        Response response = new Response();
        List<Battery> batteryList = batteryRepository.getBatteryInfo(from, to);
        if (batteryList.isEmpty()) {
            throw new NotFoundException("Battery not found with in range ");
        }
        response.setBatteryNames(batteryList.stream().map(Battery::getName).collect(Collectors.toList()));
        response.setTotal(batteryList.stream().mapToDouble(Battery::getCapacity).sum());
        response.setAverage(batteryList.stream().mapToDouble(Battery::getCapacity).average().getAsDouble());
        return response;
    }

}
