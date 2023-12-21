package fact.it.artistservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fact.it.artistservice.model.Artist;
import fact.it.artistservice.service.ArtistService;

import java.util.List;

@RestController
@RequestMapping("/api/artist")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.createArtist(artist);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }
}