package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.FilmBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.FilmBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.FilmCreationDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(FilmResource.FILMS)
public class FilmResource {

    public static final String FILMS = "/films";
    static final String SEARCH = "/search";

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

    @GetMapping(value = SEARCH)
    public List<FilmBasicDto> find(@RequestParam String q) {
        if (!"genre".equals(q.split(":")[0])) {
            throw new BadRequestException("query param q is incorrect, missing 'genre:'");
        }
        return this.filmBusinessController.findByGenre(q.split(":")[1]);
    }
}