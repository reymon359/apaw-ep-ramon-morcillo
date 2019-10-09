package es.upm.miw.apaw_ep_themes.documents;

import es.upm.miw.apaw_ep_themes.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ScoreTest {

    private Score score;

    @BeforeEach
    void before() {
        this.score = new Score(3, 45);
    }

    @Test
    void testGetters() {
        assertEquals(Integer.valueOf(3), score.getValue());
        assertEquals(Integer.valueOf(45), score.getVotes());
    }

    @Test
    void testSetters() {
        score.setValue(5);
        score.setVotes(34);
        assertEquals(Integer.valueOf(5), score.getValue());
        assertEquals(Integer.valueOf(34), score.getVotes());
    }

    @Test
    void testToString() {
        assertEquals("Score{value='3', votes='45'}", score.toString());
    }

}
