package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class FilmCreationDto {

    private String name;

    private String genre;

    private String directorId;

    private Integer value;

    private Integer votes;

    public FilmCreationDto() {
        // Empty for framework
    }

    public FilmCreationDto(String name, String genre, String directorId, Integer value, Integer votes) {
        this.name = name;
        this.genre = genre;
        this.directorId = directorId;
        this.value = value;
        this.votes = votes;
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

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public void validate() {
        if (this.name == null || this.name.isEmpty() || this.genre == null || this.genre.isEmpty()
                || this.directorId == null || this.directorId.isEmpty() || this.value == null || this.value < 0
                || this.votes == null || this.votes < 0) {
            throw new BadRequestException("Incomplete FilmCreationDto");
        }
    }

    @Override
    public String toString() {
        return "FilmCreationDto{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", directorId='" + directorId + '\'' +
                ", value='" + value + '\'' +
                ", votes='" + votes + '\'' +
                '}';
    }

}
