package m2i.spring.examples.buying.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import m2i.spring.examples.buying.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

}
