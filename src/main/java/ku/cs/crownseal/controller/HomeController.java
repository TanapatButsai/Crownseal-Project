package ku.cs.crownseal.controller;

import ku.cs.crownseal.entity.Member;
import ku.cs.crownseal.repository.CustomerRepository;
import ku.cs.crownseal.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    CustomerRepository customerRepository;

    UserDetailsServiceImp userDetailsServiceImp;
    @RequestMapping("/")
    public String getHomePage(Model model, Authentication authentication) {
        model.addAttribute("greeting", "สวัสดียินดีต้อนรับ");
        // ต้องคืนค่าเป็นชื่อไฟล์ html template โดยในเมธอดนี้ คืนค่าเป็น home.html
        return "home";
    }

    @GetMapping("/profile")
    public String getProfilePage(Authentication authentication,Model model) {
        Member member = customerRepository.findByUsername(authentication.getName());
        model.addAttribute("email",member.getEmail());
        model.addAttribute("name",member.getName());
        model.addAttribute("username",member.getUsername());
        model.addAttribute("phone",member.getPhoneNumber());
        model.addAttribute("role",member.getRole());
        return "profile"; // return หน้าฟอร์ม signup.html
    }

}
