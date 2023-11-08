package ku.cs.crownseal.service;
import ku.cs.crownseal.entity.Problem;
import ku.cs.crownseal.model.ProblemRequest;
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
public class ProblemService {


    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WorkOrderRepository workOrderRepository;

    public List<Problem> getAllProblem() {

        return problemRepository.findAll();
    }
    public List<Problem> getAllProblemByStatus(String status) {

        return problemRepository.findProblemsByStatus(status);
    }
    public Problem getByID(UUID problemId){ return problemRepository.findById(problemId).get();}


    public List<Problem> getMemberProblem(String name) {
        return customerRepository.findByUsername(name).getProblemList();
    }
    public void createProblem(ProblemRequest request,String name) {
        Problem record = modelMapper.map(request, Problem.class);
        record.setMember(customerRepository.findByUsername(name));
        record.setTimeStampStart(LocalDateTime.now());
        record.setStatus("ยังไม่ดำเนินการ");
        problemRepository.save(record);
    }
    public void setProblemWorkOrder(UUID workOrderId, UUID uuid){
        Problem record = problemRepository.findById(uuid).get();
        record.setWorkOrder(workOrderRepository.findById(workOrderId).get());
        problemRepository.save(record);
    }
    public void confirmProblem(UUID problemId){
        Problem record = problemRepository.findById(problemId).get();
        record.setStatus("รับเรื่อง");
        problemRepository.save(record);
    }

    public void denyProblem(UUID problemId){
        Problem record = problemRepository.findById(problemId).get();
        record.setStatus("ไม่รับเรื่อง");
        problemRepository.save(record);
    }

    public void finishProblem(UUID problemId){
        Problem record = problemRepository.findById(problemId).get();
        record.setStatus("แก้ไขแล้ว");
        record.setTimeStampFinish(LocalDateTime.now());
        problemRepository.save(record);
    }

    public void processedProblemByWorkOrder(UUID workOrderId){

        Problem record = problemRepository.findById(workOrderId).get();
        record.setStatus("ดำเนินการแล้ว");
        problemRepository.save(record);
    }
    public void inProgressProblem(UUID problemId){
        Problem record = problemRepository.findById(problemId).get();
        record.setStatus("กำลังดำเนินการ");
        problemRepository.save(record);
    }
    public List<Problem> getAllStatusNotDeny(){
        return problemRepository.findAllByStatusNot("ไม่รับเรื่อง");
    }
}

