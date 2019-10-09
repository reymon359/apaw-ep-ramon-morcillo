package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Film;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class FilmBasicDto {

    private String id;

    private String name;

    private String genre;

    public FilmBasicDto() {
        // Empty for framework
    }

    public FilmBasicDto(Film film) {
        this.id = film.getId();
        this.name = film.getName();
        this.genre = film.getGenre();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void validateNick() {
        if (this.name == null || this.name.isEmpty() || this.genre == null || this.genre.isEmpty()) {
            throw new BadRequestException("Incomplete, lost name or genre");
        }
    }

    @Override
    public String toString() {
        return "UserBasicDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
