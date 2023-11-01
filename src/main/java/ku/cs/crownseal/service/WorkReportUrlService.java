package ku.cs.crownseal.service;

import ku.cs.crownseal.entity.WorkOrder;
import ku.cs.crownseal.entity.WorkReportUrl;
import ku.cs.crownseal.model.WorkOrderRequest;
import ku.cs.crownseal.model.WorkReportUrlRequest;
import ku.cs.crownseal.repository.WorkOrderRepository;
import ku.cs.crownseal.repository.WorkReportUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class WorkReportUrlService {
    @Autowired
    private WorkReportUrlRepository workReportUrlRepository;
    @Autowired

    private ModelMapper modelMapper;
    @Autowired
    private WorkOrderRepository workOrderRepository;
    public WorkReportUrl createWorkReportUrl(WorkReportUrlRequest workReportUrlRequest) {
        WorkReportUrl record = modelMapper.map(workReportUrlRequest, WorkReportUrl.class);
        workReportUrlRepository.save(record);
        return record;
    }
    public void setRepairingReportUrlByWorkOrderID(UUID uuid, String url){
        WorkReportUrl record = workOrderRepository.findById(uuid).get().getWorkReportUrl();
        record.setRepairingReportUrl(url);
        workReportUrlRepository.save(record);
    }
}
