package org.ktronics.devicedowndetectorspring.devicestatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceStatusRepository extends JpaRepository<DeviceStatus, String>{

    @Query("SELECT d FROM DeviceStatus d WHERE d.Status = ?1")
    List<DeviceStatus> findByStatus(String status);
}
