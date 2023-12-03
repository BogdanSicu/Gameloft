package bogdan.gameloft.models.campaign;

import bogdan.gameloft.models.campaign.manytomany.MatcherDoesntHaveItems;
import bogdan.gameloft.models.campaign.manytomany.MatcherHasCountry;
import bogdan.gameloft.models.campaign.manytomany.MatcherHasItems;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MATCHERS")
public class Matcher {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "level_min")
    private Long levelMin;

    @Column(name = "level_max")
    private Long levelMax;

    @OneToMany(mappedBy = "matcher")
    private Set<MatcherHasItems> hasItems = new HashSet<>();

    @OneToMany(mappedBy = "matcher")
    private Set<MatcherHasCountry> hasCountries = new HashSet<>();

    @OneToMany(mappedBy = "matcher")
    private Set<MatcherDoesntHaveItems> doesNotHaveItems = new HashSet<>();

    @OneToMany(
            mappedBy = "name",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private Set<Campaign> campaigns = new HashSet<>();

}
