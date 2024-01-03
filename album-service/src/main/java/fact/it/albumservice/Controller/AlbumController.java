package fact.it.albumservice.controller;

import fact.it.albumservice.dto.AlbumRequest;
import fact.it.albumservice.dto.AlbumResponse;
import fact.it.albumservice.service.AlbumService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createAlbum(
            @RequestBody AlbumRequest albumRequest) {
        albumService.createAlbum(albumRequest);
    }

    @GetMapping
    public String showAlbums(Model model) {
        List<AlbumResponse> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        return "index";
    }

    @PutMapping("/{albumId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAlbum(
            @PathVariable String albumId,
            @RequestBody AlbumRequest albumRequest) {
        albumService.updateAlbum(albumId, albumRequest);
    }

    @DeleteMapping("/{albumId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable String albumId) {
        albumService.deleteAlbum(albumId);
    }
}
