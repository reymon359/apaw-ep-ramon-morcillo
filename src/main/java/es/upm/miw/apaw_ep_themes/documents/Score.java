package es.upm.miw.apaw_ep_themes.documents;

public class Score {

    private Integer value;

    private Integer votes;


    public Score(Integer value, Integer votes) {
        this.value = value;
        this.votes = votes;
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
        this.value = votes;
    }

    @Override
    public String toString() {
        return "Score{" +
                "value='" + value + '\'' +
                ", votes='" + votes + '\'' +
                '}';
    }
}
