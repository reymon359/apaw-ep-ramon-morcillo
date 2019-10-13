package es.upm.miw.apaw_ep_themes.documents;

public class DirectorBuilder {

    private Director director;

    public DirectorBuilder(String name, Integer age, Boolean alive) {
        this.director = new Director(name, age, alive);
    }

    public Director build() {
        return this.director;
    }
}