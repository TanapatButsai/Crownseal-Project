package ku.cs.crownseal.controller;

import ku.cs.crownseal.entity.WorkOrder;
import ku.cs.crownseal.repository.CustomerRepository;
import ku.cs.crownseal.repository.WorkOrderRepository;
import ku.cs.crownseal.service.ProblemService;
import ku.cs.crownseal.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class EngineerController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    WorkOrderService workOrderService;
    @Autowired
    WorkOrderRepository workOrderRepository;
    @Autowired
    ProblemService problemService;


    @GetMapping("/admin/engineer")
    public String getEngineerListPage(Model model){

        model.addAttribute("engineers", customerRepository.findMemberByRole("ROLE_ENGINEER"));

        return "engineer-list";
    }

    @GetMapping("/work/my")
    public String getWorkOrderList(Model model, Authentication authentication){

        model.addAttribute("orders", workOrderService.getWorkOrderListByMember(authentication.getName()));

        return "work-order-list";
    }
    @GetMapping("/work/my/{workOrderId}")
    public String getWorkOrderView(@PathVariable UUID workOrderId,Model model){
        model.addAttribute("order", workOrderService.getWorkOrderById(workOrderId));
        return "work-order-view";
    }
    @PostMapping("/work/{problemId}/finish")
    public String finishProblem(@PathVariable UUID problemId , @RequestParam("pdfFile") MultipartFile file, Model model)
    {
        problemService.processedProblem(problemId);
        // Add logic to associate the uploaded file with the WorkOrder
        return "home";
    }

}
