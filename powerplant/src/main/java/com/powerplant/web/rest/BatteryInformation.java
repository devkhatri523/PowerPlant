package com.powerplant.web.rest;

import com.powerplant.domain.Battery;
import com.powerplant.domain.Range;
import com.powerplant.domain.Response;
import com.powerplant.repository.BatteryRepository;
import com.powerplant.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BatteryInformation {
    @Autowired
    private BatteryRepository batteryRepository;
    @Autowired
    private BatteryService batteryService;

    @PostMapping("/register-battery")
    public ResponseEntity<Void> saveBatteryInfo(@RequestBody List<Battery> batteryList) {
        batteryRepository.saveAll(batteryList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/battery-info")
    public Response getBatteryInformation(@RequestBody Range range) {
         return  batteryService.getBatteriesWithStatistics(range.getFrom(), range.getTo());
    }
}
