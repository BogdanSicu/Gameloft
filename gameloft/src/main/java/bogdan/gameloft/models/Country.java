package bogdan.gameloft.models;

import bogdan.gameloft.models.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COUNTRY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Column(name = "name")
    @Id
    private String name;

    @OneToMany(
            mappedBy = "country",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private Set<Player> players = new HashSet<>();
}
