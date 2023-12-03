package bogdan.gameloft.repos;

import bogdan.gameloft.models.campaignplayer.PlayerCampaignKey;
import bogdan.gameloft.models.campaignplayer.PlayerCampaignRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerCampaignRelationRepo extends JpaRepository<PlayerCampaignRelation, PlayerCampaignKey> {
}
