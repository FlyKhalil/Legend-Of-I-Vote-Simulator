
package questionsimulator;

/**
 * This class represents the student id.
 * @author Khalil Hughes
 */
public class Student {
    private int id;
    private static int id_cnt = 0;

    /**
     * Constructor to initiate a student id. 
     */
    public Student() {
        id = id_cnt++;
    }

    /**
     * Get the current user id.
     * @return 
     */
    public int getId() {
        return id;
    }
}
