package com.powerplant.service;


import com.powerplant.Exceptions.NotFoundException;
import com.powerplant.domain.Battery;
import com.powerplant.domain.Range;
import com.powerplant.domain.Response;
import com.powerplant.repository.BatteryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatteryServiceTest {
    @Mock
    private BatteryRepository batteryRepository;
    @InjectMocks
    private BatteryService batteryService;
    private List<Battery> batteryList;

     Response response = new Response();
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        response.setBatteryNames(Arrays.asList("Akunda Bay","Yirrkala"));
        response.setTotal(27000);
        response.setAverage(13500);
        batteryList = new ArrayList<Battery>() {{
            add(new Battery("Akunda Bay","6107",13500));
            add(new Battery("Yirrkala","6057",13500));
        }};

    }

    @Test
    public void shouldThrowBatteryNotFoundException(){
        Range range = new Range();
        range.setFrom("10000");
        range.setTo("20000");
        when(batteryRepository.getBatteryInfo(range.getFrom(),range.getTo())).thenReturn(Collections.emptyList());
        assertThrows(NotFoundException.class,()->{   batteryService.getBatteriesWithStatistics(range.getFrom(),range.getTo());
        });
    }
    @Test
    public void shouldReturnNameOfBatteriesWithOrderAndStatics(){
        Range range = new Range();
        range.setFrom("2084");
        range.setFrom("0880");
        when(batteryRepository.getBatteryInfo(range.getFrom(),range.getTo())).thenReturn(batteryList);
        Response response1 = batteryService.getBatteriesWithStatistics(range.getFrom(),range.getTo());
        assertThat(response1.getBatteryNames()).isEqualTo(response.getBatteryNames());
        assertThat(response1.getAverage()).isEqualTo(response.getAverage());
        assertThat(response1.getTotal()).isEqualTo(response.getTotal());


    }
}
