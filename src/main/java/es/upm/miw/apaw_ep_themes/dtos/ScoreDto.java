package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Review;
import es.upm.miw.apaw_ep_themes.documents.Score;

import java.util.List;

public class ScoreDto {

    private Integer value;

    private Integer votes;

    public ScoreDto() {
        // empty for framework
    }

    public ScoreDto(Score score) {
        this.value = score.getValue();
        this.votes = score.getVotes();
    }

    public Integer getValue() {
        return value;
    }

    public Integer getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "ScoreDto{" +
                "value='" + value + '\'' +
                ", votes=" + votes + '\'' +
                '}';
    }
}