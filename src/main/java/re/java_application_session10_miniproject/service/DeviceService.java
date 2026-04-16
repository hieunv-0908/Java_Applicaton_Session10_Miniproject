package re.java_application_session10_miniproject.service;

import re.java_application_session10_miniproject.model.Device;
import java.util.List;

public interface DeviceService {
    List<Device> getAllDevices();
    Device getById(Long id);
    void create(Device device);
    void update(Device device);
    void deleteById(Long id);
}
