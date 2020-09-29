
package questionsimulator;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is the actual class to handle the voting.
 *
 * @author Khalil Hughes
 */
public class VotingService {

    private Question q;
    private Map<Student, Integer[]> m_students = new HashMap<>();
    Integer[] m_answers;

    /**
     * Constructor to initiate the voting system with the question.
     *
     * @param q the question to vote for
     */
    public VotingService(Question q) {
        this.q = q;
        // initiate the counters for the answers with zeros
        m_answers = new Integer[q.getCntAnswers()];

        for (int i = 0; i < q.getCntAnswers(); i++) {
            m_answers[i] = 0;
        }
    }

    /**
     * Function responsible for handling voting of a student.
     *
     * @param s student to vote
     * @param ans answer indeces of the student
     * @return true if this vote is valid
     */
    public boolean vote(Student s, Integer[] ans) {
        if (q.isType()) {
            if (ans.length < 1) {
                return false;
            }
            return voteOneAnswer(s, ans[0]);
        } else {
            return voteMultiAnswers(s, ans);
        }
    }

    /**
     * Function responsible for displaying the frequencies of answering the
     * questions
     */
    public void display() {
        String[] anss = q.getAnswers();
        for (int i = 0; i < q.getCntAnswers(); i++) {
            Integer freq = m_answers[i];
            String ans = anss[i];
            System.out.println("\"" + ans + "\": " + freq);
        }
    }

    /**
     * Function responsible for voting question with only one answer.
     *
     * @param s the student to vote
     * @param ans the one answer the student choose
     * @return true if this is a valid voting
     */
    private boolean voteOneAnswer(Student s, Integer ans) {
        if (ans >= q.getCntAnswers()) {
            return false;
        }
        if (m_students.containsKey(s)) {
            // set old answer cnt to -1
            m_answers[m_students.get(s)[0]]
                    = m_answers[m_students.get(s)[0]] - 1;
        }
        m_students.put(s, new Integer[]{ans});
        m_answers[ans] = m_answers[ans] + 1;
        return true;
    }

    /**
     * Function responsible for voting question with ةعمفهحمث answer.
     *
     * @param s the student to vote
     * @param ans the answers the student choose
     * @return true if this is a valid voting
     */
    private boolean voteMultiAnswers(Student s, Integer[] ans) {
        if (ans.length == 0) {
            return false;
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] >= q.getCntAnswers()) {
                return false;
            }
        }

        if (m_students.containsKey(s)) {
            // set old answer cnt to -1
            for (int i = 0; i < m_students.get(s).length; i++) {
                m_answers[m_students.get(s)[i]]
                        = m_answers[m_students.get(s)[i]] - 1;
            }
        }
        m_students.put(s, ans);

        for (int i = 0; i < m_students.get(s).length; i++) {
            m_answers[ans[i]] = m_answers[ans[i]] + 1;
        }
        return true;
    }
}
