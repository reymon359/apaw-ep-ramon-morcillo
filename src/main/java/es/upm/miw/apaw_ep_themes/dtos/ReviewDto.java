package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Review;

public class ReviewDto {
    private String author;
    private String description;

    public ReviewDto() {
        // Empty for framework
    }

    public ReviewDto(String author, String description) {
        this.author = author;
        this.description = description;
    }

    public ReviewDto(Review review) {
        this.author = review.getAuthor();
        this.description = review.getDescription();
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "ReviewDto{" +
                "author='" + author + '\'' +
                ", description=" + description + '\'' +
                '}';
    }
}
