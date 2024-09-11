package org.ktronics.devicedowndetectorspring.devicestatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Availability")
public class DeviceStatus {

    @Id
    private String IPAddress;
    private String Status;

    public DeviceStatus() {
    }

    public DeviceStatus(String IPAddress, String Status) {
        this.IPAddress = IPAddress;
        this.Status = Status;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
