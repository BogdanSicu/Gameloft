package bogdan.gameloft.models.player.manytomany;

import bogdan.gameloft.models.player.Device;
import bogdan.gameloft.models.player.Player;
import bogdan.gameloft.models.player.manytomany.compositekeys.PlayerDeviceKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PLAYER_DEVICES")
@Data
public class PlayerDeviceRelation {

    @JsonIgnore
    @EmbeddedId
    PlayerDeviceKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("player_id")
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @MapsId("device_id")
    @JoinColumn(name = "id")
    private Device device;

}
