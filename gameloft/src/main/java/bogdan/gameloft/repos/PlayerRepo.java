package bogdan.gameloft.repos;

import bogdan.gameloft.models.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepo extends JpaRepository<Player, UUID> {
}
