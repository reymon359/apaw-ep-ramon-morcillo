package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.ProposalDao;
import es.upm.miw.apaw_ep_themes.documents.Proposal;
import es.upm.miw.apaw_ep_themes.dtos.ProposalDto;
import es.upm.miw.apaw_ep_themes.dtos.ProposalPatchDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ProposalBusinessControllerIT {

    @Autowired
    private ProposalDao proposalDao;

    @Autowired
    private ProposalBusinessController proposalBusinessController;

    private Proposal proposal;

    @BeforeEach
    void before() {
        this.proposal = new Proposal("name", "description");
        this.proposalDao.save(proposal);
    }

    @Test
    void testDeleteProposal() {
        String proposalId = new ProposalDto(this.proposal).getId();
        proposalBusinessController.delete(proposalId);
        assertFalse(proposalDao.findById(proposalId).isPresent());
    }


    @Test
    void testPatchName() {
        ProposalPatchDto proposalPatchDto = new ProposalPatchDto("name", "newName");
        proposalBusinessController.patch(this.proposal.getId(), proposalPatchDto);
        assertEquals("newName", this.proposalDao.findById(proposal.getId()).get().getName());
    }
    @Test
    void testPatchDescription() {
        ProposalPatchDto proposalPatchDto = new ProposalPatchDto("description", "newDesc");
        proposalBusinessController.patch(this.proposal.getId(), proposalPatchDto);
        assertEquals("newDesc", this.proposalDao.findById(proposal.getId()).get().getDescription());
    }

    @Test
    void testPatchException() {
        ProposalPatchDto proposalPatchDto = new ProposalPatchDto("invalid", "newDescription");
        assertThrows(BadRequestException.class, () -> proposalBusinessController.patch(proposal.getId(), proposalPatchDto));
    }

}