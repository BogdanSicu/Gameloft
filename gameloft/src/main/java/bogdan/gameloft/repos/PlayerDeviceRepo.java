package bogdan.gameloft.repos;

import bogdan.gameloft.models.player.manytomany.PlayerDeviceRelation;
import bogdan.gameloft.models.player.manytomany.compositekeys.PlayerDeviceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDeviceRepo extends JpaRepository<PlayerDeviceRelation, PlayerDeviceKey> {
}
