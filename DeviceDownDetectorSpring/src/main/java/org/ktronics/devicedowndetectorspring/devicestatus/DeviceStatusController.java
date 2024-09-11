package org.ktronics.devicedowndetectorspring.devicestatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceStatusController {
    private final DeviceStatusService deviceStatusService;

    public DeviceStatusController(DeviceStatusService deviceStatusService) {
        this.deviceStatusService = deviceStatusService;
    }

    @GetMapping("/down")
    public ResponseEntity<?> getDevicesWithStatusDown() {
        try {
            return ResponseEntity.ok(deviceStatusService.getDevicesWithStatusDown());
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while fetching devices with status DOWN");
        }
    }
}
