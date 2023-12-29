package fact.it.albumservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "album")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Album {
    @Id
    @Field("albumId")
    private String albumId;
    private String skuCode;
    private String title;
    private String releaseDate;
    private int tracks;
    private String artistId;
    private String genreId;
}