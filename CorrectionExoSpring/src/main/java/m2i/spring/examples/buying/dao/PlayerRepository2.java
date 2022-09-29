package m2i.spring.examples.buying.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import m2i.spring.examples.buying.model.Player2;

@Repository
public interface PlayerRepository2 extends CrudRepository<Player2, Integer> {

}
