package es.upm.miw.apaw_ep_themes.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProposalCompositeTest {
    private ProposalTree root;

    private ProposalTree sub11;

    private ProposalTree leaf;

    @BeforeEach
    void ini() {
        ProposalTree sub1;
        ProposalTree sub12;
        this.root = new ProposalComposite("root", "rootdesc");

        this.leaf = new ProposalLeaf(new Proposal("name", "desc"));
        this.root.add(leaf);

        this.root.add(new ProposalLeaf(new Proposal("name2", "desc2")));

        sub1 = new ProposalComposite("sub1", "sub1desc");
        this.root.add(sub1);
        sub1.add(new ProposalLeaf(new Proposal("name3", "desc3")));

        this.sub11 = new ProposalComposite("sub11", "sub11desc");
        sub1.add(sub11);
        this.sub11.add(new ProposalLeaf(new Proposal("name4", "desc4")));
        this.sub11.add(new ProposalLeaf(new Proposal("name5", "desc5")));


        sub12 = new ProposalComposite("sub12", "sub12desc");
        sub1.add(sub12);
        sub12.add(new ProposalLeaf(new Proposal("name6", "desc6")));
        sub12.add(new ProposalLeaf(new Proposal("name7", "desc7")));
    }

    @Test
    void testProposalOfProposalTreeIfLeaf() {
        assertEquals("desc", this.leaf.description());
    }

    @Test
    void testProposalOfProposalTreeIfComposite() {
        assertEquals("root", this.root.name());
        assertEquals("sub11", this.sub11.name());
    }

    @Test
    void testProposalIfLeaf() {
        assertEquals("name", this.leaf.name());
    }

}
