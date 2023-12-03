package bogdan.gameloft.services.player;


import bogdan.gameloft.models.player.Player;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PlayerService {

    public List<Player> getAllPlayers();

    public Player activateCampaign(UUID playerId);

}
