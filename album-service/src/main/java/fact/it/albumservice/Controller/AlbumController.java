package fact.it.albumservice.controller;

import fact.it.albumservice.dto.AlbumRequest;
import fact.it.albumservice.dto.AlbumResponse;
import fact.it.albumservice.service.AlbumService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/album")
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
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumResponse> getAllAlbumsBySkuCode(
            @RequestParam List<String> skuCode) {
        return albumService.getAllAlbumsBySkuCode(skuCode);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumResponse> getAllAlbums() {
        return albumService.getAllAlbums();
    }
}
