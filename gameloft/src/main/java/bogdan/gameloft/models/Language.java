package bogdan.gameloft.models;

import bogdan.gameloft.models.player.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LANGUAGE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {

    @Column(name = "name")
    @Id
    private String name;

    @JsonIgnore
    @OneToMany(
            mappedBy = "language",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private Set<Player> players = new HashSet<>();
}
