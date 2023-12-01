package bogdan.gameloft.models.player.manytomany.compositekeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
public class PlayerDeviceKey implements Serializable {

    @Column(name = "player_id")
    private UUID player_id;

    @Column(name = "device_id")
    private Long device_id;

}
