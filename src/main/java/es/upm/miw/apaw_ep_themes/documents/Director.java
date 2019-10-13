package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        this.alive = alive;
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