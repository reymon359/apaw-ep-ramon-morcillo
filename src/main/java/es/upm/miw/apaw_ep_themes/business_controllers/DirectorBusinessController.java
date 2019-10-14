package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.DirectorDao;
import es.upm.miw.apaw_ep_themes.documents.Director;
import es.upm.miw.apaw_ep_themes.documents.DirectorBuilder;
import es.upm.miw.apaw_ep_themes.dtos.DirectorDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

@Controller
public class DirectorBusinessController {

    private DirectorDao directorDao;

    private EmitterProcessor<String> newDirectoFlux;

    @Autowired
    public DirectorBusinessController(DirectorDao directorDao) {
        this.directorDao = directorDao;  this.newDirectoFlux = EmitterProcessor.create();
    }
    public Flux<String> publisher(){
        return this.newDirectoFlux;
    }

    private Director findDirectorByIdAssured(String id) {
        return this.directorDao.findById(id).orElseThrow(() -> new NotFoundException("Director id: " + id));
    }

    public DirectorDto create(DirectorDto directorDto) {
        Director director = new Director(directorDto.getName(), directorDto.getAge(), directorDto.getAlive());
        this.directorDao.save(director);
        this.newDirectoFlux.onNext("New Director");
        return new DirectorDto(director);
    }

    public DirectorDto update(String id, DirectorDto directorDto) {
        directorDto.validate();
        Director director = this.findDirectorByIdAssured(id);
        director.setName(directorDto.getName());
        director.setAge(directorDto.getAge());
        director.setAlive(directorDto.getAlive());
        this.directorDao.save(director);
        return new DirectorDto(director);
    }

}

