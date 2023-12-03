package bogdan.gameloft.models.player;

import bogdan.gameloft.models.player.manytomany.PlayerDeviceRelation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "DEVICE")
public class Device {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "firmware")
    private String firmware;

    @OneToMany(mappedBy = "device")
    private Set<PlayerDeviceRelation> devices = new HashSet<>();
}
