package es.upm.miw.apaw_ep_themes.documents;

public class Review {

    private String  author;

    private String description;

    public Review(String author,String description) {
        this.author= author;
        this.description= description;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

}
