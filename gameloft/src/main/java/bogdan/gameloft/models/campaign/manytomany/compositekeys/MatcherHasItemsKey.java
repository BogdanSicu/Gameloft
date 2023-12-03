package bogdan.gameloft.models.campaign.manytomany.compositekeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class MatcherHasItemsKey implements Serializable {

    @Column(name = "matcher_id")
    private Long matcher_id;

    @Column(name = "item_id")
    private String item_id;

}
