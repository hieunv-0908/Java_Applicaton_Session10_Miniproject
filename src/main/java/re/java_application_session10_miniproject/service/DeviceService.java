package re.java_application_session10_miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.java_application_session10_miniproject.model.Device;
import re.java_application_session10_miniproject.repository.DeviceRepository;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> findAll() {
        return deviceRepository.findAll();
    }
}
