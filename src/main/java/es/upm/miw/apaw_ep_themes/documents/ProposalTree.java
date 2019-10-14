package es.upm.miw.apaw_ep_themes.documents;


public interface ProposalTree {

    String name();

    String description();

    boolean isComposite();

    void add(ProposalTree proposalTree);

    void remove(ProposalTree proposalTree);

}
