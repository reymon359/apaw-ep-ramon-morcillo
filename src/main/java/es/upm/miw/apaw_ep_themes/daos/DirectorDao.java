package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Director;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DirectorDao extends MongoRepository<Director, String> {
}
