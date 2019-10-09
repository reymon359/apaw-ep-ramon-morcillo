package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
public class Film {

    @Id
    private String id;

    private String name;

    private String genre;

    private LocalDateTime date;

    private Score score;

    @DBRef
    private Director director;

    private List<Review> reviews;

    public Film(String name, String genre, Director director, Score score) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.date = LocalDateTime.now();
        this.score = score;
        this.reviews = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
