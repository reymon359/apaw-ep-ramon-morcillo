package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.FilmBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.FilmBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.FilmCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FilmResource.FILMS)
public class FilmResource {

    public static final String FILMS = "/films";

    private FilmBusinessController filmBusinessController;

    @Autowired
    public FilmResource(FilmBusinessController filmBusinessController) {
        this.filmBusinessController = filmBusinessController;
    }

    @PostMapping
    public FilmBasicDto create(@RequestBody FilmCreationDto filmCreationDto) {
        filmCreationDto.validate();
        return this.filmBusinessController.create(filmCreationDto);
    }

}