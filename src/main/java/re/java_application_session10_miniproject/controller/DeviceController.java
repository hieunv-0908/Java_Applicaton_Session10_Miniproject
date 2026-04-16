package re.java_application_session10_miniproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import re.java_application_session10_miniproject.service.DeviceService;

@Controller
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/devices")
    public String listDevices(Model model) {
        model.addAttribute("devices", deviceService.findAll());
        return "deviceList";
    }
}
