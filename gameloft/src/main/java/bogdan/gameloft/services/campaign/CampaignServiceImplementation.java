package bogdan.gameloft.services.campaign;

import bogdan.gameloft.models.campaign.Campaign;
import bogdan.gameloft.repos.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CampaignServiceImplementation implements CampaignService{

    private final CampaignRepo campaignRepo;

    @Autowired
    public CampaignServiceImplementation(CampaignRepo campaignRepo) {
        this.campaignRepo = campaignRepo;
    }

    @Override
    public Set<Campaign> getAllActiveCampaigns() {
        return campaignRepo.findAll().stream().filter(Campaign::getEnabled).collect(Collectors.toSet());
    }
}
