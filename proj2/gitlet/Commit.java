package gitlet;

// TODO: any imports you need here

import java.io.Serializable;
import java.util.Date; // TODO: You'll likely use this in this class

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** Instance variables: */
    /** The message of this Commit. */
    private String message;

    /* TODO: fill in the rest of this class. */

    /** The date of this Commit. */
    private Date date;

    /** Constructor of the Commit class.
     * each commit needs to come with a log message associated with it
     * and the timestamp of it */
    public Commit(String message, Date date) {
        this.message = message;
        this.date = date;
    }
}
