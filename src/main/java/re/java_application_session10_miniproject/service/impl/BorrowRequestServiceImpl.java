package re.java_application_session10_miniproject.service.impl;

import re.java_application_session10_miniproject.model.BorrowRequest;
import re.java_application_session10_miniproject.model.Device;
import re.java_application_session10_miniproject.dto.BorrowRequestDto;
import re.java_application_session10_miniproject.repository.BorrowRequestRepository;
import re.java_application_session10_miniproject.repository.DeviceRepository;
import re.java_application_session10_miniproject.service.BorrowRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowRequestServiceImpl implements BorrowRequestService {

    private final BorrowRequestRepository repository;
    private final DeviceRepository deviceRepository;

    public BorrowRequestServiceImpl(BorrowRequestRepository repository, DeviceRepository deviceRepository) {
        this.repository = repository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<BorrowRequest> getAllRequests() {
        return repository.findAll();
    }

    @Override
    public BorrowRequest getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public BorrowRequest create(BorrowRequest request) {
        request.setId(null);
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDate.now());
        return repository.save(request);
    }

    @Override
    public BorrowRequest createBorrowRequest(BorrowRequestDto dto) {
        // Get device information
        Device device = deviceRepository.findById(dto.getDeviceId())
            .orElseThrow(() -> new RuntimeException("Thiết bị không tồn tại"));
        
        // VAL-03: Check if quantity exceeds available stock
        if (dto.getQuantity() > device.getAvailable()) {
            throw new RuntimeException("Số lượng vượt quá tồn kho. Chỉ còn " + device.getAvailable() + " thiết bị khả dụng");
        }
        
        // Create BorrowRequest from DTO
        BorrowRequest request = new BorrowRequest();
        request.setDeviceId(dto.getDeviceId());
        request.setFullName(dto.getFullName());
        request.setStudentCode(dto.getStudentCode());
        request.setEmail(dto.getEmail());
        request.setQuantity(dto.getQuantity());
        request.setBorrowDate(dto.getBorrowDate());
        request.setReturnDate(dto.getReturnDate());
        request.setReason(dto.getReason());
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDate.now());
        
        return repository.save(request);
    }

    @Override
    public BorrowRequest update(BorrowRequest request) {
        return repository.save(request);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<BorrowRequest> getByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public BorrowRequest approveRequest(Long id) {
        BorrowRequest request = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Yêu cầu không tồn tại"));
        
        if (!"PENDING".equals(request.getStatus())) {
            throw new RuntimeException("Chỉ có thể duyệt yêu cầu đang ở trạng thái PENDING");
        }
        
        // Get device and update available quantity
        Device device = deviceRepository.findById(request.getDeviceId())
            .orElseThrow(() -> new RuntimeException("Thiết bị không tồn tại"));
        
        if (request.getQuantity() > device.getAvailable()) {
            throw new RuntimeException("Số lượng vượt quá tồn kho. Chỉ còn " + device.getAvailable() + " thiết bị khả dụng");
        }
        
        // Update device available quantity
        device.setAvailable(device.getAvailable() - request.getQuantity());
        deviceRepository.save(device);
        
        // Update request status
        request.setStatus("APPROVED");
        return repository.save(request);
    }

    @Override
    public BorrowRequest rejectRequest(Long id) {
        BorrowRequest request = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Yêu cầu không tồn tại"));
        
        request.setStatus("REJECTED");
        return repository.save(request);
    }
}
