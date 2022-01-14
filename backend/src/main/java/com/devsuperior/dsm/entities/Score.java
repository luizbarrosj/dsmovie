package com.devsuperior.dsm.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {
    @EmbeddedId
    private ScorePk id = new ScorePk();
    private Double value;

    public Score() {

    }

    public void setMovie(Movie movie) {

        id.setMovie(movie);

    }

    public void setUser(User user) {

        id.setUser(user);

    }

    /**
     * @return ScorePk return the id
     */
    public ScorePk getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ScorePk id) {
        this.id = id;
    }

    /**
     * @return Double return the value
     */
    public Double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Double value) {
        this.value = value;
    }

}
