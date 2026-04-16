package re.java_application_session10_miniproject.repository;

import org.springframework.stereotype.Repository;
import re.java_application_session10_miniproject.model.Device;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeviceRepository {
    private List<Device> devicesList = new ArrayList<>();

    public DeviceRepository(List<Device> devicesList) {
        this.devicesList = List.of(
                new Device("iPhone 14 Pro", "Smartphone", "Black", 250000000),
                new Device("Macbook Pro 16", "LapTop", "Silver", 40000000),
                new Device("Samsung TV 8K", "TV", "Black", 150000000),
                new Device("Canon EOS 80D", "Camera", "Black", 10000000),
                new Device("Sony Headphone", "Headphone", "Red", 1000000)
        );
    }

    public List<Device> findAll() {
        return devicesList;
    }
}
