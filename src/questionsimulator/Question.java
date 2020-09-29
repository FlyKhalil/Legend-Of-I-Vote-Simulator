
package questionsimulator;

/**
 * This class is responsible for storing the question head and the answers for
 * it.
 *
 * @author Khalil Hughes
 */
public class Question {

    private String head;
    private String[] answers;
    private boolean type; // true for single choice

    /**
     * Constructor in initiate the question head and the answers and the type
     *
     * @param head head of the question
     * @param answers the string array of the answers
     * @param type true if one choice answer, false if multiple
     */
    public Question(String head, String[] answers, boolean type) {
        this.head = head;
        this.answers = answers;
        this.type = type;
    }

    /**
     * Get head of the question.
     *
     * @return the head of the question.
     */
    public String getHead() {
        return head;
    }

    /**
     * Get the array of answers string for this questions.
     *
     * @return the array of answers string for this questions.
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * Get number of answers for this question.
     *
     * @return number of answers for this question
     */
    public int getCntAnswers() {
        return answers.length;
    }

    /**
     * Return the type of this question
     * @return true if one choice question, false if multiple
     */
    public boolean isType() {
        return type;
    }
}
