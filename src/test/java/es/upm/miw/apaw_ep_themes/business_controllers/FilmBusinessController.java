package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.FilmDao;
import es.upm.miw.apaw_ep_themes.documents.Director;
import es.upm.miw.apaw_ep_themes.documents.Film;
import es.upm.miw.apaw_ep_themes.documents.Review;
import es.upm.miw.apaw_ep_themes.documents.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@TestConfig
class FilmBusinessControllerIT {

    @Autowired
    private FilmDao filmDao;

    @Autowired
    public FilmBusinessController filmBusinessController;

    private Film film;

    @BeforeEach
    void before() {
        this.film = new Film(
                "name", "genre",
                new Director("name", 25, false),
                new Score(8, 50));
    }


    @Test
    void testReadFilmReviews() {
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("author1", "desc1"));
        reviews.add(new Review("author2", "desc2"));
        this.film.setReviews(reviews);
        assertFalse(reviews.isEmpty());
    }


}