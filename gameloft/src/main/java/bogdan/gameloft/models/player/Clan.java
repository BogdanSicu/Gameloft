package bogdan.gameloft.models.player;

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
@Table(name = "CLAN")
public class Clan {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "clan",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private Set<Player> players = new HashSet<>();

}
