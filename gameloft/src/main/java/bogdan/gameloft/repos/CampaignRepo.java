package bogdan.gameloft.repos;

import bogdan.gameloft.models.campaign.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign, String> {
}
