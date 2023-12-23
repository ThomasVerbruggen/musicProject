package fact.it.songservice.controller;


import fact.it.songservice.model.Song;
import fact.it.songservice.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;

    @GetMapping
    public Iterable<Song> getSongs() {
        return songService.findAll();
    }

    @GetMapping("/{id}")
    public Song getSong(@PathVariable long id) throws Exception {
        try {
            return songService.findById(id);
        } catch (Exception e) {
            // return 404 exception
            throw new Exception();
        }
    }
}
