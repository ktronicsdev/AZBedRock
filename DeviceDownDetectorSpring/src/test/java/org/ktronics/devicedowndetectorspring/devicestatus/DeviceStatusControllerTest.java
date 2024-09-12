package org.ktronics.devicedowndetectorspring.devicestatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DeviceStatusControllerTest {

    @Mock
    private DeviceStatusService deviceStatusService;

    @InjectMocks
    private DeviceStatusController deviceStatusController;

    private DeviceStatus deviceStatus;
    private  ArrayList<Object> deviceStatusList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        deviceStatus = new DeviceStatus("192.168.0.1", "Down");

        deviceStatusList = new ArrayList<>();
        deviceStatusList.add(deviceStatus);
    }

    @Test
    void testGetDevicesWithStatusDown() {
        when(deviceStatusService.getDevicesWithStatusDown()).thenReturn(deviceStatusList);

        ResponseEntity<?> responseEntity = deviceStatusController.getDevicesWithStatusDown();

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody()).isEqualTo(deviceStatusList);
        verify(deviceStatusService, times(1)).getDevicesWithStatusDown();
    }

    @Test
    void testGetDevicesWithStatusDown_NoDevicesDown() {
        when(deviceStatusService.getDevicesWithStatusDown()).thenReturn(new ArrayList<>());

        ResponseEntity<?> responseEntity = deviceStatusController.getDevicesWithStatusDown();

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody()).isInstanceOf(List.class);
        assertThat(((List<?>) responseEntity.getBody()).isEmpty()).isTrue();
        verify(deviceStatusService, times(1)).getDevicesWithStatusDown();
    }

    @Test
    void testGetDevicesWithStatusDown_ServiceThrowsException() {
        when(deviceStatusService.getDevicesWithStatusDown()).thenThrow(new RuntimeException("Service failed"));

        ResponseEntity<?> responseEntity = deviceStatusController.getDevicesWithStatusDown();

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        assertThat(responseEntity.getBody()).isEqualTo("An error occurred while fetching devices with status DOWN. Service failed");
        verify(deviceStatusService, times(1)).getDevicesWithStatusDown();
    }
}
