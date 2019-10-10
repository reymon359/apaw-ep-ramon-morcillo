package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ReviewDtoTest {

    private ReviewDto reviewDto;

    @BeforeEach
    void before() {
        this.reviewDto = new ReviewDto("author", "description");
}

    @Test
    void testGetters() {
        assertEquals("author", reviewDto.getAuthor());
        assertEquals("description", reviewDto.getDescription());
    }

    @Test
    void testSetters() {
        reviewDto.setAuthor("author2");
        reviewDto.setDescription("description2");
        assertEquals("author2", reviewDto.getAuthor());
        assertEquals("description2", reviewDto.getDescription());
    }

    @Test
    void testToString() {
        assertEquals("ReviewDto{author='author', description=description'}", reviewDto.toString());
    }

}