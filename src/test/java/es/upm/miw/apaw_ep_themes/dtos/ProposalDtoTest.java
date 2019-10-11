package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ProposalDtoTest {

    private ProposalDto proposalDto;

    @BeforeEach
    void before() {
        this.proposalDto = new ProposalDto("name", "description");
    }

    @Test
    void testGetters() {
        assertEquals("name", proposalDto.getName());
        assertEquals("description", proposalDto.getDescription());
    }

    @Test
    void testSetters() {
        proposalDto.setName("name2");
        proposalDto.setDescription("description2");
        assertEquals("name2", proposalDto.getName());
        assertEquals("description2", proposalDto.getDescription());
    }

    @Test
    void testToString() {
        assertEquals("ProposalDto{id='null', name=name, description='description'}", proposalDto.toString());
    }

}