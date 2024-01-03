package fact.it.albumservice;

import fact.it.albumservice.dto.AlbumResponse;
import fact.it.albumservice.model.Album;
import fact.it.albumservice.repository.AlbumRepository;
import fact.it.albumservice.service.AlbumService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlbumServiceApplicationTests {

	@InjectMocks
	private AlbumService albumService;

	@Mock
	private AlbumRepository albumRepository;

	@Test
	public void testGetAlbums() {
		Album album1 = new Album(
				"ALB001",
				"SKU001",
				"Album Title 1",
				"2022-01-01",
				10,
				"ART001",
				"GEN001");

		Album album2 = new Album(
				"ALB002",
				"SKU002",
				"Album Title 2",
				"2022-02-01",
				12,
				"ART002",
				"GEN002");

		List<Album> albums = Arrays.asList(album1, album2);

		when(albumRepository.findAll()).thenReturn(albums);

		List<AlbumResponse> result = albumService.getAllAlbums();

		assertEquals(2, result.size());
		assertEquals(new AlbumResponse(album1), result.get(0));
		assertEquals(new AlbumResponse(album2), result.get(1));
	}

	@Test
	void getAlbumByID_validId_returnsCorrectAlbum() throws Exception {
		Album album1 = new Album(
				"ALB001",
				"SKU001",
				"Album Title 1",
				"2022-01-01",
				10,
				"ART001",
				"GEN001");

		when(albumRepository.findById("ALB001")).thenReturn(Optional.of(album1));

		AlbumResponse result = albumService.getAlbumById("ALB001");

		assertEquals(new AlbumResponse(album1), result);
	}

	@Test
	void getAlbumByID_invalidId_throwsException() {
		when(albumRepository.findById("ALB001")).thenReturn(Optional.empty());

		assertThrows(Exception.class, () -> {
			albumService.getAlbumById("ALB001");
		});
	}
}
