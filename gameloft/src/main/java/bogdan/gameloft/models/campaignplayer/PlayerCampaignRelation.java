package bogdan.gameloft.models.campaignplayer;

import bogdan.gameloft.models.campaign.Campaign;
import bogdan.gameloft.models.player.Device;
import bogdan.gameloft.models.player.Player;
import bogdan.gameloft.models.player.manytomany.compositekeys.PlayerDeviceKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PLAYER_ACTIVE_CAMPAIGN")
public class PlayerCampaignRelation {

    @JsonIgnore
    @EmbeddedId
    PlayerCampaignKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("player_id")
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @MapsId("campaign_id")
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

}
