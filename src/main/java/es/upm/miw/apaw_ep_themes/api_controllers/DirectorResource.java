package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.DirectorBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.DirectorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DirectorResource.DIRECTORS)
public class DirectorResource {

    static final String DIRECTORS = "/directors";

    private DirectorBusinessController directorBusinessController;

    @Autowired
    public DirectorResource(DirectorBusinessController directorBusinessController) {
        this.directorBusinessController = directorBusinessController;
    }

    @PostMapping
    public DirectorDto create(@RequestBody DirectorDto directorDto) {
        directorDto.validate();
        return this.directorBusinessController.create(directorDto);
    }

}