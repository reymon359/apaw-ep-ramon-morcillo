package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.documents.Proposal;
import es.upm.miw.apaw_ep_themes.dtos.ProposalDto;
import es.upm.miw.apaw_ep_themes.dtos.ProposalPatchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiTestConfig
class ProposalResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    ProposalDto createProposal(String name) {
        return new ProposalDto(new Proposal(name, "descriptionFrom" + name));

    }


    @Test
    void testProposalUpdateIdException() {
        this.webTestClient
                .patch().uri(ProposalResource.PROPOSALS + ProposalResource.ID_ID, "no")
                .body(BodyInserters.fromObject(new ProposalPatchDto("description", "otherDesc")))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }


}
