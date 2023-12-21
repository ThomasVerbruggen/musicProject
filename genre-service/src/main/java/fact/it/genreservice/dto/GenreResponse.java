package fact.it.genreservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreResponse {
    private Long genreId;
    private String name;
    private String description;
    private String skuCode;
}
