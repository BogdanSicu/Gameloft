package bogdan.gameloft.models.campaign.manytomany;

import bogdan.gameloft.models.Item;
import bogdan.gameloft.models.campaign.Matcher;
import bogdan.gameloft.models.campaign.manytomany.compositekeys.MatcherDoesntHaveItemsKey;
import bogdan.gameloft.models.campaign.manytomany.compositekeys.MatcherHasCountryKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MATCHER_DOES_NOT_HAVE_ITEMS")
public class MatcherDoesntHaveItems {

    @JsonIgnore
    @EmbeddedId
    MatcherDoesntHaveItemsKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("matcher_id")
    @JoinColumn(name = "matcher_id_not")
    private Matcher matcher;

    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "item_id_not")
    private Item item;

}
