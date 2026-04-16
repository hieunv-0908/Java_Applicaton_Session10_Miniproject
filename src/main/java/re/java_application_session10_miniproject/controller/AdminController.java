package re.java_application_session10_miniproject.controller;

import re.java_application_session10_miniproject.model.BorrowRequest;
import re.java_application_session10_miniproject.model.Device;
import re.java_application_session10_miniproject.service.BorrowRequestService;
import re.java_application_session10_miniproject.service.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final DeviceService deviceService;
    private final BorrowRequestService borrowRequestService;

    public AdminController(DeviceService deviceService, BorrowRequestService borrowRequestService) {
        this.deviceService = deviceService;
        this.borrowRequestService = borrowRequestService;
    }

    @GetMapping
    public String adminHome() {
        return "redirect:/admin/requests";
    }

    @GetMapping("/requests")
    public String requestList(Model model) {
        model.addAttribute("requests", borrowRequestService.getAllRequests());
        return "admin/request-list";
    }

    @GetMapping("/devices")
    public String deviceManage(Model model) {
        model.addAttribute("devices", deviceService.getAllDevices());
        model.addAttribute("device", new Device());
        return "admin/device-manage";
    }

    @GetMapping("/devices/new")
    public String showDeviceForm(Model model) {
        model.addAttribute("device", new Device());
        return "admin/device-form";
    }

    @PostMapping("/devices/save")
    public String saveDevice(@ModelAttribute("device") Device device) {
        if (device.getId() == null) {
            deviceService.create(device);
        } else {
            deviceService.update(device);
        }
        return "redirect:/admin/devices";
    }

    @GetMapping("/devices/edit/{id}")
    public String editDevice(@PathVariable Long id, Model model) {
        Device device = deviceService.getById(id);
        if (device == null) {
            return "redirect:/admin/devices";
        }
        model.addAttribute("device", device);
        return "admin/device-form";
    }

    @GetMapping("/devices/delete/{id}")
    public String deleteDevice(@PathVariable Long id) {
        deviceService.deleteById(id);
        return "redirect:/admin/devices";
    }

    @GetMapping("/requests/delete/{id}")
    public String deleteRequest(@PathVariable Long id) {
        borrowRequestService.delete(id);
        return "redirect:/admin/requests";
    }

    @GetMapping("/requests/approve/{id}")
    public String approveRequest(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            borrowRequestService.approveRequest(id);
            redirectAttributes.addFlashAttribute("success", "Đã duyệt yêu cầu thành công");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/admin/requests";
    }

    @GetMapping("/requests/reject/{id}")
    public String rejectRequest(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            borrowRequestService.rejectRequest(id);
            redirectAttributes.addFlashAttribute("success", "Đã từ chối yêu cầu");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/admin/requests";
    }
}
