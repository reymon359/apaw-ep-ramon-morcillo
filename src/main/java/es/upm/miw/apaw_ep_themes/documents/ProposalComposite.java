package es.upm.miw.apaw_ep_themes.documents;

import java.util.ArrayList;
import java.util.List;

public class ProposalComposite implements ProposalTree {

    private String name;

    private String description;

    private List<ProposalTree> proposalTreeList;

    public ProposalComposite(String name, String description) {
        this.name = name;
        this.description = description;
        this.proposalTreeList = new ArrayList<>();
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public  String description(){
        return this.description;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(ProposalTree proposalTree) {
        proposalTreeList.add(proposalTree);
    }

    @Override
    public void remove(ProposalTree proposalTree) {
        proposalTreeList.remove(proposalTree);
    }

}

