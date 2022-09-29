package m2i.spring.examples.transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionalUserRepository extends JpaRepository<TransactionalUser, Integer> {

}
