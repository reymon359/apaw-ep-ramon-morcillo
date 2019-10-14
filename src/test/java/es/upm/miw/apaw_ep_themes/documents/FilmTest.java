package es.upm.miw.apaw_ep_themes.documents;

import es.upm.miw.apaw_ep_themes.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class FilmTest {

    private Film film;

    @BeforeEach
    void before() {
        this.film = new Film(
                "name", "genre",
                new DirectorBuilder().setName("name").setAge(25).setAlive(false).createDirector(),
                new Score(8, 50));
    }

    @Test
    void testGetters() {
        assertEquals("name", film.getName());
        assertEquals("genre", film.getGenre());
    }

    @Test
    void testSetters() {
        film.setName("name2");
        film.setGenre("genre2");

        assertEquals("name2", film.getName());
        assertEquals("genre2", film.getGenre());
    }


}

