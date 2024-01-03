package fact.it.artistservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistRequest {
    private String skuCode;
    private String name;
    private Date birthDate;
    private String countryOfOrigin;
    private String label;
    private Boolean isActive;
}
