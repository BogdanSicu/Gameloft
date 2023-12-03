package bogdan.gameloft.models.campaign;

import bogdan.gameloft.models.campaignplayer.PlayerCampaignRelation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campaign")
public class Campaign {

    @Column(name = "game")
    private String game;

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "priority")
    private Long priority;

    //Matchers
    @ManyToOne()
    private Matcher matcher;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "last_updated")
    private Date lastUpdated;

    //player
    @OneToMany(mappedBy = "campaign")
    private Set<PlayerCampaignRelation> players = new HashSet<>();
}
