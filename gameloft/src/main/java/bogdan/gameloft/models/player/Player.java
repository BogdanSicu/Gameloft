package bogdan.gameloft.models.player;

import bogdan.gameloft.models.Country;
import bogdan.gameloft.models.Language;
import bogdan.gameloft.models.campaignplayer.PlayerCampaignRelation;
import bogdan.gameloft.models.player.manytomany.PlayerDeviceRelation;
import bogdan.gameloft.models.player.manytomany.PlayerItemRelation;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "PLAYER")
public class Player {

    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID playerId;

    @Column(name = "credential")
    private String credential;

    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "last_session")
    private Date lastSession;

    @Column(name = "total_spent")
    private Long totalSpent;

    @Column(name = "total_refund")
    private Long totalRefund;

    @Column(name = "total_transactions")
    private Long totalTransactions;

    @Column(name = "last_purchase")
    private Date lastPurchase;

    @OneToMany(mappedBy = "player")
    private Set<PlayerCampaignRelation> active_campaigns = new HashSet<>();

    @OneToMany(mappedBy = "player")
    private Set<PlayerDeviceRelation> devices = new HashSet<>();

    @Column(name = "level")
    private Long level;

    @Column(name = "xp")
    private Long xp;

    @Column(name = "total_playtime")
    private Long totalPlaytime;

    @ManyToOne()
    private Country country;

    @ManyToOne()
    private Language language;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "player")
    private Set<PlayerItemRelation> inventory = new HashSet<>();

    @ManyToOne()
    private Clan clan;

    @Column(name = "_customfield")
    private String customField;
}
