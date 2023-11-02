package ku.cs.crownseal.controller;

import ku.cs.crownseal.entity.Member;
import ku.cs.crownseal.entity.Problem;
import ku.cs.crownseal.model.ProblemRequest;
import ku.cs.crownseal.repository.CustomerRepository;
import ku.cs.crownseal.repository.ProblemRepository;
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

    @Autowired
    ProblemRepository problemRepository;

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

    @GetMapping("/done")
    public String getProfilePage(Authentication authentication,Model model) {
        Problem problem = problemRepository.findAllByStatus(authentication.getName());
        model.addAttribute("doneTime",problem.getTimeStampFinish());

        return "profile"; // return หน้าฟอร์ม signup.html
    }
}
