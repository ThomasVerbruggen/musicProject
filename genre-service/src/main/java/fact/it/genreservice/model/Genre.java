package fact.it.genreservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "genres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;
    private String name;
    private String description;
    private String skuCode;
}
