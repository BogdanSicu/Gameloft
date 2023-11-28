package bogdan.gameloft.models.campaign;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CAMPAIGN")
public class Campaign {

    @Column(name = "game")
    private String game;

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "priority")
    private Long priority;

    //Matchers

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "last_updated")
    private Date lastUpdated;
}
