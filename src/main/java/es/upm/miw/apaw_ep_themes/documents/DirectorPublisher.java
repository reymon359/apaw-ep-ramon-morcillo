package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.EmitterProcessor;

@Document
public class DirectorPublisher {

    @Id
    private String id;

    private String name;

    private Integer age;

    private Boolean alive;

    private EmitterProcessor<String> emitter;

    public DirectorPublisher(String name, Integer age, Boolean alive) {
        this.emitter = EmitterProcessor.create();
        this.name = name;
        this.age = age;
        this.alive = alive;
        this.emitter.onNext("Director Created");
    }

    public EmitterProcessor<String> publisher() {
        return this.emitter;
    }


}