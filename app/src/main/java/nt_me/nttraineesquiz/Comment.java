package nt_me.nttraineesquiz;

import java.util.Date;

/**
 * Created by Mahmoud on 9/4/2016.
 */
public class Comment {
    String name;
    String comment;
    Date date;

    public Comment(String name, String comment, Date date) {
        this.name = name;
        this.comment = comment;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
