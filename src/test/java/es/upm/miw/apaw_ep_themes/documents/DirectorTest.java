package es.upm.miw.apaw_ep_themes.documents;

import es.upm.miw.apaw_ep_themes.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class DirectorTest {

    private Director director;

    @BeforeEach
    void before() {
        this.director = new Director("name", 25, false);
    }

    @Test
    void testSetters() {
        director.setName("name");
        director.setAge(34);
        director.setAlive(true);

        assertEquals("name", director.getName());
        assertEquals(Integer.valueOf(34), director.getAge());
        assertEquals(true, director.getAlive());
    }
    @Test
    void testToString() {
        assertEquals("Director{id='null', name=name', age=25', alive=false'}", director.toString());
    }

}
