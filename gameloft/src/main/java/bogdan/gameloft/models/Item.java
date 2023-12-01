package bogdan.gameloft.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @Column(name = "name")
    private String name;

}
