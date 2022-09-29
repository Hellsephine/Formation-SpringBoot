package m2i.game.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class PlayerConsumableId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "player_id")
	private int playerId;
	
	@Column(name = "consumable_id")
	private int consumableId;

	public PlayerConsumableId(int playerId, int consumableId)
	{
		this.playerId = playerId;
		this.consumableId = consumableId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        PlayerConsumableId that = (PlayerConsumableId) o;
        return playerId == that.playerId && consumableId == that.consumableId;
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(playerId, consumableId);
    }
}