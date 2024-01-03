package fact.it.albumservice;

import fact.it.albumservice.dto.AlbumResponse;
//import fact.it.albumservice.model.ArtistItem;
import fact.it.albumservice.repository.AlbumRepository;
import fact.it.albumservice.service.AlbumService;

//import fact.it.albumservice.service.AlbumService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AlbumServiceApplicationTests {

	@InjectMocks 
	private AlbumService albumService;

	@Mock
	private AlbumRepository albumRepository;

	@Test
	public void testGetAlbums() {
		AlbumResponse album1 = new AlbumResponse(1L, "album1", "artist1");
		AlbumResponse album2 = new AlbumResponse(2L, "album2", "artist2");
		List<AlbumResponse> albums = Arrays.asList(album1, album2);

		when(albumRepository.findAll()).thenReturn(albums);

		List<AlbumResponse> result = albumService.getAlbums();

		assertEquals(2, result.size());
		assertEquals(album1, result.get(0));
		assertEquals(album2, result.get(1));
	}

	@Test
	public void testGetAlbumById() {
		AlbumResponse album1 = new AlbumResponse(1L, "album1", "artist1");

		when(albumRepository.findById(1L)).thenReturn(java.util.Optional.of(album1));

		AlbumResponse result = albumService.getAlbumById(1L);

		assertEquals(album1, result);
	}
}
