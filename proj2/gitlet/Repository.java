package gitlet;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /** A repository is where all the files and their history versions exist,
     * thus needs to come with all the branch indications 'branches' as a map
     * <key: branch name, value: corresponding commit's sha1>
     * and the current branch we are working on 'currBranch'
     */
    /** A definition here: a branch is like a pointer to a certain commit,
     * each commit is referred by a unique sha1,
     * when giving the commit a name, we create a branch pointing to that commit. */

    /** A map of all the branches. */
    private Map<String, String> branches;

    /** The current working branch referred by its name (as the unique key in the map). */
    private String currBranch;

    /** Constructor for Repository class. */
    public Repository(Map<String, String> branches, String currBranch) {
        this.branches = branches;
        this.currBranch = currBranch;
    }

    /* TODO: fill in the rest of this class. */
    /** Initial commit init command */
    public static void init() {
        if (GITLET_DIR.exists()) {
            throw new GitletException("A Gitlet version-control system already exists in the current directory.");
        }
        if (!GITLET_DIR.mkdirs()) {
            throw new GitletException("Cannot init .gitlet.");
        }

        /** Create the Commit class 'initialCommit',
         * create the 'master' branch in the repository,
         * and commit the initialCommit into the master branch in the repository
         */
        Commit initialCommit = new Commit("initial commit", new Date(0));
        // serialize the Commit into a byte array */
        byte[] content = Utils.serialize(initialCommit);
        // hash the serialized byte array into a hashcode
        String sha1 = Utils.sha1(content);
        // write the content of the commit into the file with its sha1 as name in the GITLET_DIR repository
        Utils.writeContents(new File(GITLET_DIR, sha1), content);
        // create a Repository with branches (currently only 'master' branch) and the current working branch ('master')
        Map<String, String> branches = new HashMap<>();
        branches.put("master", sha1);
        Repository repo = new Repository(branches, "master");
        // save the repository, same idea with, serialize it and write it into the file named 'repo')
        Utils.writeContents(new File(GITLET_DIR, "repo"), Utils.serialize(repo));
    }
}
