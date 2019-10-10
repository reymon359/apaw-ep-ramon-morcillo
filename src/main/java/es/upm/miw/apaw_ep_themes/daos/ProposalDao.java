package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Proposal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProposalDao extends MongoRepository<Proposal, String> {
}
