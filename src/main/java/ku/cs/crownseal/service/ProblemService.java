package ku.cs.crownseal.service;
import ku.cs.crownseal.entity.Problem;
import ku.cs.crownseal.model.ProblemRequest;
import ku.cs.crownseal.repository.CustomerRepository;
import ku.cs.crownseal.repository.ProblemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;


@Service
public class ProblemService {


    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<Problem> getAllProblem() {

        return problemRepository.findAll();
    }

    public List<Problem> getMemberProblem(String name) {
        return customerRepository.findByUsername(name).getProblemList();
    }
    public void createProblem(ProblemRequest request,String name) {
        Problem record = modelMapper.map(request, Problem.class);
        record.setMember(customerRepository.findByUsername(name));
        record.setTimestamp(LocalDateTime.now());
        record.setStatus("ยังไม่ดำเนินการ");
        problemRepository.save(record);
    }
}
