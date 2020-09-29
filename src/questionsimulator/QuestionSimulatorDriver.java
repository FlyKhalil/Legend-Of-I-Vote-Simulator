
package questionsimulator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Khalil Hughes
 */
public class QuestionSimulatorDriver {

    private static Random r = new Random();
    private final static Map<Student, Integer[]> student_ans_map = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1- create a quesiton (one choice question)
        Question q = new Question("How many centimeters in a meter?",
                new String[]{"100", "200", "300", "400"}, true);

        // 2- Configure the question for the ivote service
        VotingService vs = new VotingService(q);

        // 3- randomly generate a number students and the answers;
        int numberOfStudents = r.nextInt(100);
        generateMap(numberOfStudents, q);
        
        // 4- submit all the students’ answers to iVote Service; 
        for (Map.Entry<Student, Integer[]> entrySet : student_ans_map.entrySet()) {
            Student key = entrySet.getKey();
            Integer[] value = entrySet.getValue();
            if (!vs.vote(key, value)) {
                System.out.println("something went wrong.");
            }
        }
        
        // 5- call the iVote Service output function to display the result.
        System.out.println(numberOfStudents + " student has voted."
                + " And this is the result:");
        vs.display();;
    }

    private static void generateMap(int numberOfStudents, Question q) {
        for (int i = 0; i < numberOfStudents; i++) {
            Student s = new Student();
            int numberOfAnswers = 1;
            if (!q.isType()) {
                numberOfAnswers = r.nextInt(q.getCntAnswers() - 1) + 1;
            }
            Integer[] answers = new Integer[numberOfAnswers];
            for (int j = 0; j < numberOfAnswers; j++) {
                answers[j] = r.nextInt(q.getCntAnswers());
            }
            student_ans_map.put(s, answers);
        }
    }
}
