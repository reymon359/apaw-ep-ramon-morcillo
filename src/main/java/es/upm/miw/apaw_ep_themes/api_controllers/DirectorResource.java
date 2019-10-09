package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.DirectorBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.DirectorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DirectorResource.DIRECTORS)
public class DirectorResource {

    static final String DIRECTORS = "/directors";
    static final String ID_ID = "/{id}";

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

    @PutMapping(value = ID_ID)
    public DirectorDto update(@PathVariable String id, @RequestBody DirectorDto directorDto) {
        directorDto.validate();
        return this.directorBusinessController.update(id, directorDto);
    }

}