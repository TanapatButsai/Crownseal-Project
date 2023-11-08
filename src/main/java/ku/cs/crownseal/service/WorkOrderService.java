package ku.cs.crownseal.service;

import ku.cs.crownseal.entity.Problem;
import ku.cs.crownseal.entity.WorkOrder;
import ku.cs.crownseal.entity.WorkReportUrl;
import ku.cs.crownseal.model.ProblemRequest;
import ku.cs.crownseal.model.WorkOrderRequest;
import ku.cs.crownseal.model.WorkReportUrlRequest;
import ku.cs.crownseal.repository.CustomerRepository;
import ku.cs.crownseal.repository.ProblemRepository;
import ku.cs.crownseal.repository.WorkOrderRepository;
import ku.cs.crownseal.repository.WorkReportUrlRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class WorkOrderService {

    @Autowired
    private ProblemRepository problemRepository;



    @Autowired
    private WorkOrderRepository workOrderRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProblemService problemService;
    public WorkOrder createWorkOrder(WorkOrderRequest request, UUID id, WorkReportUrl workReportUrl) {
        WorkOrder record = modelMapper.map(request, WorkOrder.class);
        record.setWorkReportUrl(workReportUrl);
        record.setTime_stamp_start(LocalDateTime.now());
        record.setProblem(problemRepository.findById(id).get());
        workOrderRepository.save(record);
        return record;
    }

    public List<WorkOrder> getWorkOrderListByMember(String username){
        return workOrderRepository.findAllByMemberUsernameAndProblemStatus(username,"กำลังดำเนินการ");
    }
    public String getWorkOrderLocation(UUID uuid){
        String locationName = workOrderRepository.findById(uuid).get().getProblem().getMember().getLocationName();
        String locationDetail = workOrderRepository.findById(uuid).get().getProblem().getMember().getLocationDetail();
        String province = workOrderRepository.findById(uuid).get().getProblem().getMember().getProvince();
        String district = workOrderRepository.findById(uuid).get().getProblem().getMember().getDistrict();
        String postal = workOrderRepository.findById(uuid).get().getProblem().getMember().getPostalCode();
        return locationName + " " + locationDetail + " " + province + " " + district + " " + postal;
    }
    public WorkOrder getWorkOrderById(UUID id){

        return workOrderRepository.findById(id).get();
    }

    public void setWorkOrderUrlByProblemId(UUID uuid, String url){
        WorkOrder workOrder = workOrderRepository.findById(uuid).get();
//        workOrder.setRepairingReportUrl(url);
        workOrderRepository.save(workOrder);
    }

}
