package m2i.game.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class PlayerConsumable {

	@EmbeddedId
	private PlayerConsumableId id;
	
	private int quantity;
	
	protected PlayerConsumable()
	{
		
	}

	public PlayerConsumable(Player player, Consumable consumable, int quantity)
	{
		id = new PlayerConsumableId(player.getId(), consumable.getId());
		this.quantity = quantity;
	}

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PlayerConsumableId getId() {
		return id;
	}
	
	/**
	 * Deux PlayerConsumable sont les mêmes si ils ont le même identifiant.
	 */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        PlayerConsumable that = (PlayerConsumable) o;
        return Objects.equals(id, that.id);
    }
 
	/**
	 * L'identifiant définit le hash.
	 */
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
