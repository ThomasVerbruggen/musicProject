package fact.it.albumservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "album")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Album {
    @Id
    private String albumId;
    private String skuCode;
    private String title;
    private String releaseDate;
    private int tracks;
    private Long artistId;
    private Long genreId;
}