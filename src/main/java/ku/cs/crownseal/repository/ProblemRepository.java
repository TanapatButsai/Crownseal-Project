package ku.cs.crownseal.repository;


import ku.cs.crownseal.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;


@Repository
public interface ProblemRepository extends JpaRepository<Problem, UUID> {

}