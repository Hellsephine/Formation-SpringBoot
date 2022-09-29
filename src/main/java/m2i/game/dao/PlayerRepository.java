package m2i.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m2i.game.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
