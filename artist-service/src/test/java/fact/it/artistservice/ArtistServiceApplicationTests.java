package fact.it.artistservice;

import org.junit.jupiter.api.Test;

import fact.it.artistservice.model.Artist;
import fact.it.artistservice.repository.ArtistRepository;
import fact.it.artistservice.service.ArtistService;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArtistServiceApplicationTests {

	@InjectMocks
	private ArtistService artistService;

	@Mock
	private ArtistRepository artistRepository;

	@Test
	public void testGetArtists() {
		Artist artist1 = new Artist(1L, "artist1", null, null, null, null, null);
		Artist artist2 = new Artist(2L, "artist2", null, null, null, null, null);
		List<Artist> artists = Arrays.asList(artist1, artist2);

		when(artistRepository.findAll()).thenReturn(artists);

		List<Artist> result = artistService.findAll();

		assertEquals(2, result.size());
		assertEquals(artist1, result.get(0));
		assertEquals(artist2, result.get(1));
	}

	@Test
	public void testGetArtistById() {
		Artist artist1 = new Artist(1L, "artist1", null, null, null, null, null);

		when(artistRepository.findById(1L)).thenReturn(java.util.Optional.of(artist1));

		Artist result = artistService.getArtistById(1L);

		assertEquals(artist1, result);
	}

	@Test
	public void testAddActor() {
		Artist artist = new Artist();
		artist.setArtistId(1L);
		artist.setName("Test Artist");

		when(artistRepository.save(artist)).thenReturn(artist);

		Artist artistResponse = artistService.createArtist(artist);

		assertThat(artistResponse.getName()).isEqualTo("Test Artist");
	}

	@Test
	public void testDeleteActor() {
		artistService.deleteArtist(1L);
	}
}