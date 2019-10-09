package es.upm.miw.apaw_ep_themes.documents;

import es.upm.miw.apaw_ep_themes.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ReviewTest {

    private Review review;

    @BeforeEach
    void before() {
        this.review = new Review("author", "description");
    }

    @Test
    void testGetters() {
        assertEquals("author", review.getAuthor());
        assertEquals("description", review.getDescription());
    }

    @Test
    void testSetters() {
        review.setAuthor("author2");
        review.setDescription("description2");
        assertEquals("author2", review.getAuthor());
        assertEquals("description2", review.getDescription());
    }

    @Test
    void testToString() {
        assertEquals("Review{author='author', description='description'}", review.toString());
    }

}
