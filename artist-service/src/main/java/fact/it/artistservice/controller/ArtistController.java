package fact.it.artistservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fact.it.artistservice.dto.ArtistRequest;
import fact.it.artistservice.service.ArtistService;

@RestController
@RequestMapping("/api/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Object findAll() {
        return artistService.findAll();
    }

    @PutMapping("update/{artistId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateArtist(
            @PathVariable String artistId,
            @RequestBody ArtistRequest artistRequest) {
        artistService.updateArtist(artistId, artistRequest);
    }

    @DeleteMapping("delete/{artistId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable Long artistId) {
        artistService.deleteArtist(artistId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createArtist(
            @RequestBody ArtistRequest artistRequest) {
        artistService.createArtist(artistRequest);
    }
}