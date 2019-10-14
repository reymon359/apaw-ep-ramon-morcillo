package es.upm.miw.apaw_ep_themes.documents;

public class DirectorBuilder {
    private String name;
    private Integer age;
    private Boolean alive;

      public DirectorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DirectorBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public DirectorBuilder setAlive(Boolean alive) {
        this.alive = alive;
        return this;
    }

    public Director createDirector() {
        return new Director(name, age, alive);
    }
}