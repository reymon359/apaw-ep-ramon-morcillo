package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Proposal;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class ProposalDto {

    private String id;

    private String name;

    private String description;

    public ProposalDto() {
        // empty for framework
    }

    public ProposalDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProposalDto(Proposal proposal) {
        this.id = proposal.getId();
        this.name = proposal.getName();
        this.description = proposal.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void validate() {
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            throw new BadRequestException("Incomplete ProposalDto. ");
        }
    }

    @Override
    public String toString() {
        return "ProposalDto{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", description='" + description + '\'' +
                '}';
    }
}
