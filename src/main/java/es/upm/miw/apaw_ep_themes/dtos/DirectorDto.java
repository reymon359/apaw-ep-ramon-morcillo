package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Director;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class DirectorDto {

    private String id;

    private String name;

    private Integer age;

    private Boolean alive;

    public DirectorDto() {
        // empty for framework
    }

    public DirectorDto(String name, Integer age, Boolean alive) {
        this.name = name;
        this.age = age;
        this.alive = alive;
    }

    public DirectorDto(Director director) {
        this.id = director.getId();
        this.name = director.getName();
        this.age = director.getAge();
        this.alive = director.getAlive();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }


    public void validate() {
        if (name == null || name.isEmpty() || age == null || age <= 0 || alive == null) {
            throw new BadRequestException("Incomplete DirectorDto. ");
        }
    }

    @Override
    public String toString() {
        return "DirectorDto{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", age='" + age + '\'' +
                ", alive='" + alive + '\'' +
                '}';
    }
}