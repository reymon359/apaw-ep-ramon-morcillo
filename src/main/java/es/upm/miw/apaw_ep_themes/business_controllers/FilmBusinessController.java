package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.FilmDao;
import es.upm.miw.apaw_ep_themes.daos.DirectorDao;
import es.upm.miw.apaw_ep_themes.documents.Film;
import es.upm.miw.apaw_ep_themes.documents.Director;
import es.upm.miw.apaw_ep_themes.documents.Score;
import es.upm.miw.apaw_ep_themes.dtos.FilmBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.FilmCreationDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FilmBusinessController {

    private FilmDao filmDao;

    private DirectorDao directorDao;

    @Autowired
    public FilmBusinessController(FilmDao filmDao, DirectorDao directorDao) {
        this.filmDao = filmDao;
        this.directorDao = directorDao;
    }

    public FilmBasicDto create(FilmCreationDto filmCreationDto) {
        Director director = this.directorDao.findById(filmCreationDto.getDirectorId())
                .orElseThrow(() -> new NotFoundException("Director id: " + filmCreationDto.getDirectorId()));
        Film film = new Film(filmCreationDto.getName(), filmCreationDto.getGenre(), director,
                new Score(filmCreationDto.getValue(), filmCreationDto.getVotes()));
        this.filmDao.save(film);
        return new FilmBasicDto(film);
    }

    public List<FilmBasicDto> findByGenre(String genre) {
        System.out.println(this.filmDao.findAll().stream()
                .filter(film -> film.getGenre().equals(genre))
                .map(FilmBasicDto::new)
                .collect(Collectors.toList()));
        return this.filmDao.findAll().stream()
                .filter(film -> film.getGenre().equals(genre))
                .map(FilmBasicDto::new)
                .collect(Collectors.toList());
    }

}
