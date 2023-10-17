package ku.cs.crownseal.service;
import ku.cs.crownseal.entity.Problem;
import ku.cs.crownseal.model.ProblemRequest;
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
    private ModelMapper modelMapper;


    public List<Problem> getAllProblem() {
        return problemRepository.findAll();
    }


    public void createProblem(ProblemRequest request) {
        Problem record = modelMapper.map(request, Problem.class);
        record.setTimestamp(LocalDateTime.now());
        record.setStatus("ยังไม่ดำเนินการ");
        problemRepository.save(record);
    }
}
