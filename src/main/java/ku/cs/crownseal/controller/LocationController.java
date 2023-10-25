package ku.cs.crownseal.controller;

import ku.cs.crownseal.entity.Location;
import ku.cs.crownseal.model.LocationRequest;
import ku.cs.crownseal.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public String getLocationAddPage() {
        return "location-add"; // return หน้าฟอร์ม signup.html
    }

    @PostMapping("/locations")
    public String getCreateLocation(@ModelAttribute LocationRequest locationRequest,Authentication authentication){
        locationService.createLocation(locationRequest, authentication.getName());
        return "home";
    }
    @GetMapping("/locations")
    public String getLocationViewPage() {
        return "location-add"; // return หน้าฟอร์ม signup.html
    }

}
