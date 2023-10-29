package ku.cs.crownseal.controller;

import ku.cs.crownseal.model.ProblemRequest;
import ku.cs.crownseal.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/problems")
public class ProblemController {
    @Autowired
    private ProblemService problemService;


    @GetMapping("/my")
    public String getMemberProblem(Model model,Authentication authentication) {
        model.addAttribute("problems", problemService.getMemberProblem(authentication.getName()));
        return "problem-all";
    }

    @GetMapping("/add")
    public String getProblemForm(Model model) {
        return "problem-add";
    }

    @PostMapping("/add")
    public String createProblem(@ModelAttribute ProblemRequest problem, Authentication authentication) {
        problemService.createProblem(problem, authentication.getName());
        return "redirect:/problems/my";
    }


}
