package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Director {

    @Id
    private String id;

    private String name;

    private Integer age;

    private Boolean alive;

    public Director(String name, Integer age, Boolean alive) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getAlive() {
        return alive;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", age=" + age + '\'' +
                ", alive=" + alive + '\'' +
                '}';
    }
}