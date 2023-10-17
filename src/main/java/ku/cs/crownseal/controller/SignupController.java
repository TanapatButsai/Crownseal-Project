package ku.cs.crownseal.controller;

import ku.cs.crownseal.model.SignupRequest;
import ku.cs.crownseal.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class SignupController {

    @Autowired
    private SignupService signupService;


    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup"; // return หน้าฟอร์ม signup.html
    }


    @PostMapping("/signup")
    public String signupUser(@ModelAttribute SignupRequest customer, Model model) {


        if (signupService.isUsernameAvailable(customer.getUsername())) {
            signupService.createUser(customer);
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", "Username not available");
        }
        // return หน้าฟอร์ม signup.html เช่นกัน แต่จะมี message ปรากฎ
        return "signup";
    }

}
