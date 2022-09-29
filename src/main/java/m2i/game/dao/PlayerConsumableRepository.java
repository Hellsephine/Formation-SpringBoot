package m2i.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m2i.game.model.PlayerConsumable;
import m2i.game.model.PlayerConsumableId;


@Repository
public interface PlayerConsumableRepository 
	extends JpaRepository<PlayerConsumable, PlayerConsumableId> {

}
