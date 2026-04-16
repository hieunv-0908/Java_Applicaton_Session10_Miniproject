package re.java_application_session10_miniproject.repository;

import re.java_application_session10_miniproject.model.Device;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DeviceRepository {

    private final List<Device> data = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public DeviceRepository() {
        // Add some sample devices với số lượng available khác total quantity
        data.add(new Device(idGenerator.getAndIncrement(), "Màn hình LCD", "Màn hình 24 inch", 10, 7));
        data.add(new Device(idGenerator.getAndIncrement(), "Cáp HDMI", "Cáp HDMI 2m", 20, 18));
        data.add(new Device(idGenerator.getAndIncrement(), "Bàn phím cơ", "Bàn phím cơ RGB", 5, 2));
        data.add(new Device(idGenerator.getAndIncrement(), "Chuột gaming", "Chuột gaming wireless", 8, 5));
        data.add(new Device(idGenerator.getAndIncrement(), "Laptop Dell", "Laptop Dell Core i5", 6, 4));
        data.add(new Device(idGenerator.getAndIncrement(), "Webcam HD", "Webcam 1080p", 12, 9));
    }

    public List<Device> findAll() {
        return new ArrayList<>(data);
    }

    public Optional<Device> findById(Long id) {
        return data.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();
    }

    public Device save(Device device) {
        if (device.getId() == null) {
            device.setId(idGenerator.getAndIncrement());
            data.add(device);
            return device;
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(device.getId())) {
                data.set(i, device);
                return device;
            }
        }

        data.add(device);
        return device;
    }

    public void deleteById(Long id) {
        data.removeIf(device -> device.getId().equals(id));
    }

    public List<Device> findByNameContainingIgnoreCase(String name) {
        return data.stream()
                .filter(d -> d.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
