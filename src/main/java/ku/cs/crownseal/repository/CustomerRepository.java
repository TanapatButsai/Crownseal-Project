package ku.cs.crownseal.repository;

import ku.cs.crownseal.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Member, UUID> {
    Member findByUsername(String username);
}
