package fact.it.genreservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fact.it.genreservice.model.Genre;
import fact.it.genreservice.repository.GenreRepository;
import fact.it.genreservice.service.GenreService;

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
public class GenreServiceApplicationTests {

	@InjectMocks
	private GenreService genreService;

	@Mock
	private GenreRepository genreRepository;

	@Test
	public void testGetGenres() {
		Genre genre1 = new Genre(1L, "genre1", null, null);
		Genre genre2 = new Genre(2L, "genre2", null, null);
		List<Genre> genres = Arrays.asList(genre1, genre2);

		when(genreRepository.findAll()).thenReturn(genres);

		List<Genre> result = genreService.findAll();

		assertEquals(2, result.size());
		assertEquals(genre1, result.get(0));
		assertEquals(genre2, result.get(1));
	}

	@Test
	public void testGetGenreById() {
		Genre genre1 = new Genre(1L, "genre1", null, null);

		when(genreRepository.findById(1L)).thenReturn(java.util.Optional.of(genre1));

		Genre result = genreService.findById(1L);

		assertEquals(genre1, result);
	}
}