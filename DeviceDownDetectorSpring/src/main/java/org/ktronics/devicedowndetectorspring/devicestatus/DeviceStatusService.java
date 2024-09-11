package org.ktronics.devicedowndetectorspring.devicestatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;

@Service
public class DeviceStatusService {

    @Autowired
    private DeviceStatusRepository deviceStatusRepository;

    public List<String> getDevicesWithStatusDown() {
        List<String> devicesWithStatusDown = new ArrayList<>();
        deviceStatusRepository.findByStatus("DOWN").forEach(device -> devicesWithStatusDown.add(device.getIPAddress()));

        return devicesWithStatusDown;
    }

}
