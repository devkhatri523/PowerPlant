package com.powerplant.repository;

import com.powerplant.domain.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery,Long> {
    @Query(value = "SELECT * FROM Battery where post_code In(?1,?2) order by name asc", nativeQuery = true)
     List<Battery> getBatteryInfo(String from,String to);

}
