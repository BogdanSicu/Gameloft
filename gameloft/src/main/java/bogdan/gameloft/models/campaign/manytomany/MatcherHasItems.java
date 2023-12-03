package bogdan.gameloft.models.campaign.manytomany;

import bogdan.gameloft.models.Item;
import bogdan.gameloft.models.campaign.Matcher;
import bogdan.gameloft.models.campaign.manytomany.compositekeys.MatcherHasItemsKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "MATCHER_HAS_ITEM")
public class MatcherHasItems {

    @JsonIgnore
    @EmbeddedId
    MatcherHasItemsKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("matcher_id")
    @JoinColumn(name = "matcher_id")
    private Matcher matcher;

    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "item_id")
    private Item item;

}
