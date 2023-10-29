package ku.cs.crownseal.controller;

import ku.cs.crownseal.entity.WorkOrder;
import ku.cs.crownseal.model.ProblemRequest;
import ku.cs.crownseal.model.WorkOrderRequest;
import ku.cs.crownseal.repository.CustomerRepository;
import ku.cs.crownseal.service.ProblemService;
import ku.cs.crownseal.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin/problems")
public class AdminController {
    @Autowired
    private ProblemService problemService;

    @Autowired
    private WorkOrderService workOrderService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all")
    public String getAllProblem(Model model) {
        model.addAttribute("problems", problemService.getAllProblem());
        model.addAttribute("type","เรื่องทั้งหมด");
        return "problem-all";
    }
    @GetMapping("/confirm")
    public String getAllProblemConfirm(Model model) {
        model.addAttribute("problems", problemService.getAllProblemByStatus("รับเรื่อง"));
        model.addAttribute("type","รับเรื่องแล้ว");
        return "problem-all";
    }

    @GetMapping("/new")
    public String getAllProblemNew(Model model) {
        model.addAttribute("problems", problemService.getAllProblemByStatus("ยังไม่ดำเนินการ"));
        model.addAttribute("type","ยังไม่ดำเนินการ");
        return "problem-all";
    }
    @GetMapping("/in-progress")
    public String getAllProblemInProgress(Model model) {
        model.addAttribute("problems", problemService.getAllProblemByStatus("กำลังดำเนินการ"));
        model.addAttribute("type","อยู่ระหว่างการจัดการโดยหัวหน้าวิศวะกร");

        return "problem-all";
    }
    @GetMapping("/{id}")
    public String getProblems(@PathVariable UUID id, Model model) {
        model.addAttribute("problem", problemService.getByID(id));
        if (problemService.getByID(id).getStatus().equals("ยังไม่ดำเนินการ")) {
            return "problem-view-new";
        }else if (problemService.getByID(id).getStatus().equals("รับเรื่อง")){
            return "problem-view-confirm";
        }
        return "home";
    }

    @PostMapping("/{problemId}/confirm")
    public String confirmProblem(@PathVariable UUID problemId , Model model)
    {
        problemService.confirmProblem(problemId);
        return "home";
    }

    @PostMapping("/{problemId}/deny")
    public String denyProblem(@PathVariable UUID problemId , Model model)
    {
        problemService.denyProblem(problemId);
        return "home";
    }
    @PostMapping("/{problemId}/finish")
    public String finishProblem( @PathVariable UUID problemId , Model model)
    {
        problemService.finishProblem(problemId);
        return "home";
    }

    @GetMapping("/{problemId}/in-progress")
    public String inProgressProblem( @PathVariable UUID problemId , Model model)
    {
        model.addAttribute("problem", problemService.getByID(problemId));
        model.addAttribute("engineers", customerRepository.findMemberByRole("ROLE_ENGINEER"));
        return "work_order_form";
    }

    @PostMapping("/{problemId}/in-progress")
    public String createWorkOrder(@PathVariable UUID problemId, @ModelAttribute WorkOrderRequest workOrderRequest , Model model) {
        System.out.println(problemId.toString());
        problemService.inProgressProblem(problemId);
        workOrderService.createWorkOrder(workOrderRequest,problemId);

        return "home";
    }


}
