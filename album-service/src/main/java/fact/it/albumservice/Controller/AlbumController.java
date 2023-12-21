package fact.it.albumservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;

import fact.it.albumservice.Service.AlbumService;
import fact.it.albumservice.dto.AlbumRequest;
import fact.it.albumservice.dto.AlbumResponse;
import lombok.RequiredArgsConstructor;

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

    // get mapping for sku code
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumResponse> getAlbumBySkuCode(
            @RequestBody List<String> skuCode) {
        return albumService.getAlbumBySkuCode(skuCode);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumResponse> getAllAlbums() {
        return albumService.getAllAlbums();
    }
}
