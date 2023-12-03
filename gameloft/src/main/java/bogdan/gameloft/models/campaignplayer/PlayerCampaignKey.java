package bogdan.gameloft.models.campaignplayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerCampaignKey implements Serializable {

    @Column(name = "player_id")
    private UUID player_id;

    @Column(name = "campaign_id")
    private String campaign_id;


}
