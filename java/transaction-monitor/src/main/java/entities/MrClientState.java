package entities;

import java.io.Serializable;


public class MrClientState implements Serializable {

    private static final long serialVersionUID = -6712453155939398201L;

    private Long id;
    private String state;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
