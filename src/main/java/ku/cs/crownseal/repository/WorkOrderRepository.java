package ku.cs.crownseal.repository;

import ku.cs.crownseal.entity.Member;
import ku.cs.crownseal.entity.WorkOrder;
import ku.cs.crownseal.entity.WorkReportUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, UUID> {

        List<WorkOrder> findAllByMemberUsernameAndProblemStatus(String username,String string);


}
