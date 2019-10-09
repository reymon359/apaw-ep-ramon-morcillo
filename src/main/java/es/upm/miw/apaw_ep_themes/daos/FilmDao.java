package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Film;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmDao extends MongoRepository<Film, String> {
}
