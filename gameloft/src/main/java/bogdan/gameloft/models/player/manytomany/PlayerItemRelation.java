package bogdan.gameloft.models.player.manytomany;

import bogdan.gameloft.models.Item;
import bogdan.gameloft.models.player.Player;
import bogdan.gameloft.models.player.manytomany.compositekeys.PlayerItemKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PLAYER_ITEMS")
@Data
public class PlayerItemRelation {

    @JsonIgnore
    @EmbeddedId
    PlayerItemKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("player_id")
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "quantity")
    private Long quantity;
}
