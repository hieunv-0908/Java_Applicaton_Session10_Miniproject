package re.java_application_session10_miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import re.java_application_session10_miniproject.model.Device;
import re.java_application_session10_miniproject.service.DeviceService;

import java.util.List;

@Controller
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public String listDevices(Model model) {
        List<Device> devices = deviceService.getAllDevices();
        model.addAttribute("devices", devices);
        return "student/device-list";
    }
}
