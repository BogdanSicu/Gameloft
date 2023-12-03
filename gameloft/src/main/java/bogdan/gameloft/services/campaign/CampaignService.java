package bogdan.gameloft.services.campaign;

import bogdan.gameloft.models.campaign.Campaign;

import java.util.Set;

public interface CampaignService {

    Set<Campaign> getAllActiveCampaigns();

}
