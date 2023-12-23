package fact.it.albumservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "album")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Album {
    private String albumId;
    private String skuCode;
    private String title;
    private String releaseDate;
    private int tracks;
    private Long artistId;
    private Long genreId;
}