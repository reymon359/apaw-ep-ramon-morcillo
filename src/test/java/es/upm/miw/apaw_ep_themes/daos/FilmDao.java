package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Director;
import es.upm.miw.apaw_ep_themes.documents.Score;
import es.upm.miw.apaw_ep_themes.documents.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestConfig
class filmDaoIT {

    @Autowired
    private FilmDao filmDao;

    @Test
    void testCreate() {
        Film film = new Film(
                "name", "genre",
                new Director("name", 25, false),
                new Score(8, 50));
        this.filmDao.save(film);
        Film databaseFilm = this.filmDao.findById(film.getId()).orElseGet(Assertions::fail);
        assertEquals("name", databaseFilm.getName());
    }
}
