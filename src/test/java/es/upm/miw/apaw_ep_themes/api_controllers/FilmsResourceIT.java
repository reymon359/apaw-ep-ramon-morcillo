package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.FilmBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.FilmCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.DirectorDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ApiTestConfig
class FilmsResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    private String filmId;

    @Test
    void testCreate() {
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
                new FilmCreationDto("name", "genre", directorId, 5, 34);
        this.filmId = this.webTestClient
                .post().uri(FilmResource.FILMS)
                .body(BodyInserters.fromObject(filmCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FilmBasicDto.class)
                .returnResult().getResponseBody().getId();
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
                new FilmCreationDto("name2", "genre2","no",5,22);
        this.webTestClient
                .post().uri(FilmResource.FILMS)
                .body(BodyInserters.fromObject(filmCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }


}
