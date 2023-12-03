package bogdan.gameloft.services.player;

import bogdan.gameloft.models.campaign.Campaign;
import bogdan.gameloft.models.campaign.manytomany.MatcherDoesntHaveItems;
import bogdan.gameloft.models.campaign.manytomany.MatcherHasCountry;
import bogdan.gameloft.models.campaign.manytomany.MatcherHasItems;
import bogdan.gameloft.models.campaignplayer.PlayerCampaignKey;
import bogdan.gameloft.models.campaignplayer.PlayerCampaignRelation;
import bogdan.gameloft.models.player.Player;
import bogdan.gameloft.models.player.manytomany.PlayerItemRelation;
import bogdan.gameloft.repos.PlayerCampaignRelationRepo;
import bogdan.gameloft.repos.PlayerRepo;
import bogdan.gameloft.services.campaign.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class PlayerServiceImplementation implements PlayerService {

    private final PlayerRepo playerRepo;
    private final CampaignService campaignService;
    private final PlayerCampaignRelationRepo playerCampaignRelationRepo;

    @Autowired
    public PlayerServiceImplementation(PlayerRepo playerRepo, CampaignService campaignService, PlayerCampaignRelationRepo playerCampaignRelationRepo) {
        this.playerRepo = playerRepo;
        this.campaignService = campaignService;
        this.playerCampaignRelationRepo = playerCampaignRelationRepo;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public Player activateCampaign(UUID playerId) {

        Player checkPlayer = playerRepo.findById(playerId).orElse(null);

        if(checkPlayer != null) {
            return null;
        }

        Set<Campaign> activeCampaigns = campaignService.getAllActiveCampaigns();

        if(activeCampaigns.isEmpty()) {
            return null;
        }



        for (Campaign campaign : activeCampaigns) {

            boolean hasCountry = false;
            boolean hasItem = false;
            boolean doesNotHaveItems = false;

            for (MatcherHasCountry country : campaign.getMatcher().getHasCountries()) {
                if(checkPlayer.getCountry() != null && country.getCountry().getName().equals(checkPlayer.getCountry().getName())) {
                    hasCountry = true;
                    break;
                }
            }

            for (MatcherHasItems item : campaign.getMatcher().getHasItems()) {
                if(!checkPlayer.getInventory().isEmpty()) {
                    for (PlayerItemRelation inventoryItem : checkPlayer.getInventory()) {
                        if(inventoryItem.getItem().getName().equals(item.getItem().getName())) {
                            hasItem = true;
                            break;
                        }
                    }
                }
                if(hasItem) {
                    break;
                }
            }

            for (MatcherDoesntHaveItems noItem : campaign.getMatcher().getDoesNotHaveItems()) {
                if(!checkPlayer.getInventory().isEmpty()) {
                    for (PlayerItemRelation inventoryItem : checkPlayer.getInventory()) {
                        if(inventoryItem.getItem().getName().equals(noItem.getItem().getName())) {
                            doesNotHaveItems = true;
                            break;
                        }
                    }
                }
                if(doesNotHaveItems) {
                    break;
                }
            }

            if(hasItem && hasCountry &&
                    !doesNotHaveItems &&
                    checkPlayer.getLevel() <= campaign.getMatcher().getLevelMax() &&
                    checkPlayer.getLevel() >= campaign.getMatcher().getLevelMin() ) {

                PlayerCampaignKey playerCampaignKey =  new PlayerCampaignKey(checkPlayer.getPlayerId(), campaign.getName());
                PlayerCampaignRelation playerCampaignRelation = new PlayerCampaignRelation();
                playerCampaignRelation.setId(playerCampaignKey);
                playerCampaignRelationRepo.save(playerCampaignRelation);

            }
        }

        return playerRepo.findById(playerId).orElse(null);
    }
}
