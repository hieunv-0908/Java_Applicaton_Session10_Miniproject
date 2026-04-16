package re.java_application_session10_miniproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.java_application_session10_miniproject.model.Device;
import re.java_application_session10_miniproject.repository.DeviceRepository;
import re.java_application_session10_miniproject.service.DeviceService;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public void update(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public void deleteById(Long id) {
        deviceRepository.deleteById(id);
    }
}
