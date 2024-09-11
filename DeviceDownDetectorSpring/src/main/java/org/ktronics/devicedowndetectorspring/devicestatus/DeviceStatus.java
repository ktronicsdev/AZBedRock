package org.ktronics.devicedowndetectorspring.devicestatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Availability")
public final class DeviceStatus {

    @Id
    private final String IPAddress;
    private final String Status;

    public DeviceStatus() {
        this.IPAddress = null;
        this.Status = null;
    }

    public DeviceStatus(String IPAddress, String Status) {
        this.IPAddress = IPAddress;
        this.Status = Status;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public String getStatus() {
        return Status;
    }
}
