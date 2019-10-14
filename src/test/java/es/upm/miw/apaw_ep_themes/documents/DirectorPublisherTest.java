package es.upm.miw.apaw_ep_themes.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class DirectorPublisherTest {

    private DirectorPublisher directorPublisher;

    @BeforeEach
    void before() {
        this.directorPublisher = new DirectorPublisher("name", 25, false);
    }

    @Test
    void testDirectorPublisher() {
        StepVerifier
                .create(directorPublisher.publisher())
                .then(() -> new DirectorPublisher("name", 22, false))
                .expectNext("Director Created")
                .thenCancel()
                .verify();
    }
}
