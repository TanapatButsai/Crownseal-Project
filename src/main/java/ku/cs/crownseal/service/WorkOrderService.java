package ku.cs.crownseal.service;

import ku.cs.crownseal.entity.Problem;
import ku.cs.crownseal.entity.WorkOrder;
import ku.cs.crownseal.model.ProblemRequest;
import ku.cs.crownseal.model.WorkOrderRequest;
import ku.cs.crownseal.repository.CustomerRepository;
import ku.cs.crownseal.repository.ProblemRepository;
import ku.cs.crownseal.repository.WorkOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class WorkOrderService {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private WorkOrderRepository workOrderRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProblemService problemService;
    public void createWorkOrder(WorkOrderRequest request, UUID id) {
        WorkOrder record = modelMapper.map(request, WorkOrder.class);
        record.setTime_stamp_start(LocalDateTime.now());
        record.setProblem(problemRepository.findById(id).get());
//        problemService.setProblemWorkOrder(record,id);
        workOrderRepository.save(record);
    }

    public List<WorkOrder> getWorkOrderListByMember(String username){
        return customerRepository.findByUsername(username).getWorkOrderList();
    }
    public WorkOrder getWorkOrderById(UUID id){

        return workOrderRepository.findById(id).get();

    }
}
