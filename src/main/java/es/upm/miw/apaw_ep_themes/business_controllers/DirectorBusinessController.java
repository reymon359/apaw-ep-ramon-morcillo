package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.DirectorDao;
import es.upm.miw.apaw_ep_themes.documents.Director;
import es.upm.miw.apaw_ep_themes.dtos.DirectorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DirectorBusinessController {

    private DirectorDao directorDao;

    @Autowired
    public DirectorBusinessController(DirectorDao directorDao) {
        this.directorDao = directorDao;
    }


    public DirectorDto create(DirectorDto directorDto) {
        Director director = new Director(directorDto.getName(), directorDto.getAge(), directorDto.getAlive());
        this.directorDao.save(director);
        return new DirectorDto(director);
    }

}
