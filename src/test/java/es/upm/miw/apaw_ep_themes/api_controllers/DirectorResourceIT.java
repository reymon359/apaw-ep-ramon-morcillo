package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.DirectorDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
class DirectorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        DirectorDto directorDto = this.webTestClient
                .post().uri(DirectorResource.DIRECTORS)
                .body(BodyInserters.fromObject(new DirectorDto("name", 25, false)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(DirectorDto.class).returnResult().getResponseBody();
        assertNotNull(directorDto);
        assertEquals("name", directorDto.getName());
        assertEquals(Integer.valueOf(25), directorDto.getAge());
        assertFalse(directorDto.getAlive());
    }

    @Test
    void testCreateDirectorException() {
        DirectorDto directorDto = new DirectorDto(null, null, false);
        this.webTestClient
                .post().uri(DirectorResource.DIRECTORS)
                .body(BodyInserters.fromObject(directorDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

}
