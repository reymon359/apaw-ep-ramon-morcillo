package es.upm.miw.apaw_ep_themes.documents;

public class ProposalLeaf implements ProposalTree {

    private Proposal proposal;

    public ProposalLeaf(Proposal proposal) {
        this.proposal = proposal;
    }

    @Override
    public String name() {
        return this.proposal.getName();
    }

    @Override
    public String description() {
        return this.proposal.getDescription();
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(ProposalTree proposalTree) {
        // Do nothing because is leaf
    }

    @Override
    public void remove(ProposalTree proposalTree) {
        // Do nothing because is leaf
    }
}
