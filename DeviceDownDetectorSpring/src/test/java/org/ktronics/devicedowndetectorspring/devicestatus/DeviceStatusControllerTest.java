package org.ktronics.devicedowndetectorspring.devicestatus;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

@WebMvcTest(DeviceStatusController.class)
public class DeviceStatusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private DeviceStatusService deviceStatusService;

    @InjectMocks
    private DeviceStatusController deviceStatusController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetDevicesWithStatusDown() throws Exception {
        // Arrange
        when(deviceStatusService.getDevicesWithStatusDown()).thenReturn(new ArrayList<>()); // Return empty list for simplicity

        // Act & Assert
        mockMvc.perform(get("/api/devices/down"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetDevicesWithStatusDownWithDevices() throws Exception {
        // Arrange
        var devices = new ArrayList<>();
        devices.add(new DeviceStatus("192.168.0.1", "Down"));
        devices.add(new DeviceStatus("192.168.1.1", "Down"));
        when(deviceStatusService.getDevicesWithStatusDown()).thenReturn(devices);

        // Act & Assert
        mockMvc.perform(get("/api/devices/down"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[1].name").value("Device2"));
    }

    @Test
    public void testGetDevicesWithStatusDownThrowsException() throws Exception {
        // Arrange
        when(deviceStatusService.getDevicesWithStatusDown()).thenThrow(new RuntimeException("Service error"));

        // Act & Assert
        mockMvc.perform(get("/api/devices/down"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType("text/plain"))
                .andExpect(content().string("An error occurred while fetching devices with status DOWN. Service error"));
    }
}
