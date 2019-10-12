package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.ProposalDao;
import es.upm.miw.apaw_ep_themes.documents.Proposal;
import es.upm.miw.apaw_ep_themes.dtos.ProposalDto;
import es.upm.miw.apaw_ep_themes.dtos.ProposalPatchDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProposalBusinessController {

    private ProposalDao proposalDao;

    @Autowired
    public ProposalBusinessController(ProposalDao proposalDao) {
        this.proposalDao = proposalDao;
    }


    public void delete(String id) {
        Proposal proposal = this.proposalDao.findById(id).orElseThrow(() -> new NotFoundException("Proposal id: " + id));
        this.proposalDao.delete(proposal);
    }

    public void patch(String id, ProposalPatchDto proposalPatchDto) {
        Proposal proposal = this.proposalDao.findById(id).orElseThrow(() -> new NotFoundException("Proposal id: " + id));
        switch (proposalPatchDto.getPath()) {
            case "name":
                proposal.setName(proposalPatchDto.getNewValue());
                break;
            case "description":
                proposal.setDescription(proposalPatchDto.getNewValue());
                break;
            default:
                throw new BadRequestException("ProposalPatchDto is invalid");
        }
        this.proposalDao.save(proposal);
    }


}
