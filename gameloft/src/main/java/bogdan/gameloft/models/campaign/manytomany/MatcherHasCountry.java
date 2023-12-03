package bogdan.gameloft.models.campaign.manytomany;

import bogdan.gameloft.models.Country;
import bogdan.gameloft.models.Item;
import bogdan.gameloft.models.campaign.Matcher;
import bogdan.gameloft.models.campaign.manytomany.compositekeys.MatcherHasCountryKey;
import bogdan.gameloft.models.player.Player;
import bogdan.gameloft.models.player.manytomany.compositekeys.PlayerItemKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MATCHER_HAS_COUNTRY")
@Data
public class MatcherHasCountry {

    @JsonIgnore
    @EmbeddedId
    MatcherHasCountryKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("matcher_id")
    @JoinColumn(name = "matcher_id")
    private Matcher matcher;

    @ManyToOne
    @MapsId("country_id")
    @JoinColumn(name = "country_id")
    private Country country;


}
