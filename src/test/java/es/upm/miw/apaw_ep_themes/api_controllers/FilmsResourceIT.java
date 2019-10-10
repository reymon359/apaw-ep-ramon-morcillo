package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.documents.Score;
import es.upm.miw.apaw_ep_themes.dtos.FilmBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.FilmCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.DirectorDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiTestConfig
class FilmsResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    private String filmId;


    String createFilm(String name, String genre) {
        DirectorDto directorDto =
                new DirectorDto("name", 25, false);
        String directorId = this.webTestClient
                .post().uri(DirectorResource.DIRECTORS)
                .body(BodyInserters.fromObject(directorDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(DirectorDto.class)
                .returnResult().getResponseBody().getId();
        FilmCreationDto filmCreationDto =
                new FilmCreationDto(name, genre, directorId, 5, 34);
        String filmId = this.webTestClient
                .post().uri(FilmResource.FILMS)
                .body(BodyInserters.fromObject(filmCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FilmBasicDto.class)
                .returnResult().getResponseBody().getId();
        return filmId;
    }

    @Test
    void testCreate() {
        this.createFilm("film-1", "genre-1");
    }

    @Test
    void testCreateFilmException() {
        FilmCreationDto filmCreationDto =
                new FilmCreationDto("", "", "no", null, null);
        this.webTestClient
                .post().uri(FilmResource.FILMS)
                .body(BodyInserters.fromObject(filmCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testCreateDirectorIdException() {
        FilmCreationDto filmCreationDto =
                new FilmCreationDto("name2", "genre2", "no", 5, 22);
        this.webTestClient
                .post().uri(FilmResource.FILMS)
                .body(BodyInserters.fromObject(filmCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testSearch() {
        this.createFilm("film-3", "comedy");
        List<FilmBasicDto> films = this.webTestClient
                .get().uri(uriBuilder ->
                        uriBuilder.path(FilmResource.FILMS + FilmResource.SEARCH)
                                .queryParam("q", "genre:comedy")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FilmBasicDto.class)
                .returnResult().getResponseBody();
        assertFalse(films.isEmpty());
    }

    @Test
    void testReadFilmScore() {
        String filmId = createFilm("film-4", "genre-4");

        Score score = this.webTestClient
                .get().uri(FilmResource.FILMS + FilmResource.ID_ID + FilmResource.SCORE, filmId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Score.class)
                .returnResult().getResponseBody();

        assert score != null;
        assertEquals(Integer.valueOf(5), score.getValue());
        assertEquals(Integer.valueOf(34), score.getVotes());
    }

    @Test
    void testReadFilmScoreException() {
        this.webTestClient
                .get().uri(FilmResource.FILMS + FilmResource.ID_ID + FilmResource.SCORE, "no")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }
}
