package ku.cs.crownseal.controller;

import ku.cs.crownseal.model.ProblemRequest;
import ku.cs.crownseal.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/problems")
public class ProblemController {
    @Autowired
    private ProblemService problemService;


    @GetMapping
    public String getAllProblem(Model model,Authentication authentication) {
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
        return "redirect:/problems";
    }


}
