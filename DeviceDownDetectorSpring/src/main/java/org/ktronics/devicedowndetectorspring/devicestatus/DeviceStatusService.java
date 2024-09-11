package org.ktronics.devicedowndetectorspring.devicestatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class DeviceStatusService {

    @Autowired
    private DeviceStatusRepository deviceStatusRepository;

    public ArrayList<Object> getDevicesWithStatusDown() {
        var devicesWithStatusDown = new ArrayList<>();
        deviceStatusRepository.findByStatus("DOWN").forEach(device -> devicesWithStatusDown.add(device.getIPAddress()));

        return devicesWithStatusDown;
    }

}
