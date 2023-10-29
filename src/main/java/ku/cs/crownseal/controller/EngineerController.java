package ku.cs.crownseal.controller;

import ku.cs.crownseal.repository.CustomerRepository;
import ku.cs.crownseal.repository.WorkOrderRepository;
import ku.cs.crownseal.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
