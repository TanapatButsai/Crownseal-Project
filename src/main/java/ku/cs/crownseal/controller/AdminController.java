package ku.cs.crownseal.controller;

import ku.cs.crownseal.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/admin/problems")
public class AdminController {
    @Autowired
    private ProblemService problemService;

    @GetMapping("/all")
    public String getAllProblem(Model model) {
        model.addAttribute("problems", problemService.getAllProblem());
        return "problem-all";
    }
    @GetMapping("/{id}")
    public String getAllProblems(@PathVariable UUID id, Model model) {
        model.addAttribute("problem", problemService.getByID(id));
        return "problem-view";
    }
}