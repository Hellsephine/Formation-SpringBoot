package m2i.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m2i.game.model.Monster;


@Repository
public interface MonsterRepository extends JpaRepository<Monster, Integer> {

}
