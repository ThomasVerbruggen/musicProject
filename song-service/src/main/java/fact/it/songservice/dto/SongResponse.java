package fact.it.songservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongResponse {
    private long id;
    private String title;
    private String artist;
    private int year;
    
}
