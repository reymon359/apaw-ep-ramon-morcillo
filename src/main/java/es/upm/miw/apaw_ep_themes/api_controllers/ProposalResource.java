package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.ProposalBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.ProposalPatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProposalResource.PROPOSALS)
public class ProposalResource {

    static final String PROPOSALS = "/proposals";
    static final String ID_ID = "/{id}";

    private ProposalBusinessController proposalBusinessController;

    @Autowired
    public ProposalResource(ProposalBusinessController proposalBusinessController) {
        this.proposalBusinessController = proposalBusinessController;
    }

    @DeleteMapping(value = ID_ID )
    public void delete(@PathVariable String id) {
        this.proposalBusinessController.delete(id);
    }

    @PatchMapping(value = ID_ID)
    public void patch(@PathVariable String id, @RequestBody ProposalPatchDto proposalPatchDto) {
        proposalPatchDto.validate();
        this.proposalBusinessController.patch(id, proposalPatchDto);
    }
}