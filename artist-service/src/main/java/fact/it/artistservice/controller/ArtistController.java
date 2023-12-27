package fact.it.artistservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fact.it.artistservice.model.Artist;
import fact.it.artistservice.service.ArtistService;

import java.util.List;

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

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }
}