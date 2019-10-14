package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.DirectorDao;
import es.upm.miw.apaw_ep_themes.documents.Director;
import es.upm.miw.apaw_ep_themes.documents.DirectorBuilder;
import es.upm.miw.apaw_ep_themes.dtos.DirectorDto;
import es.upm.miw.apaw_ep_themes.business_controllers.DirectorBusinessController;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class DirectorBusinessControllerIT {

    @Autowired
    private DirectorDao directorDao;

    @Autowired
    private DirectorBusinessController directorBusinessController;

    private Director director;

    @BeforeEach
    void before() {
        this.director = new DirectorBuilder().setName("name").setAge(25).setAlive(false).createDirector();
        this.directorDao.save(director);
    }

    @Test
    void testPutDirectorBadRequestException() {
        DirectorDto directorDto = new DirectorDto(null, 34, null);
        assertThrows(BadRequestException.class, () -> directorBusinessController.update(director.getId(), directorDto));
    }

    @Test
    void testPutDirectorNotFoundException() {
        DirectorDto directorDto = new DirectorDto("name", 34, false);
        assertThrows(NotFoundException.class, () -> directorBusinessController.update("no", directorDto));
    }

    @Test
    void testUpdateDirector() {
        Director director2 = new DirectorBuilder().setName("name2").setAge(22).setAlive(true).createDirector();
        this.directorDao.save(director2);

        DirectorDto directorDto = new DirectorDto(director);
        DirectorDto directorDto2 = new DirectorDto(director2);
        directorDto = this.directorBusinessController.update(directorDto.getId(), directorDto2);

        assertEquals("name2", directorDto.getName());
        assertEquals(Integer.valueOf(22), directorDto.getAge());
        assertTrue(directorDto.getAlive());

    }

    @Test
    void testDirectorPublisher(){
        DirectorDto directorDto = new DirectorDto("name3", 23,true);
        StepVerifier
                .create(directorBusinessController.publisher())
                .then(() -> directorBusinessController.create
                        (directorDto))
                .expectNext("New Director")
                .thenCancel()
                .verify();
    }
}