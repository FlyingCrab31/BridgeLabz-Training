
import java.util.*;
class InvalidQuizSubmissionException extends Exception{
    public InvalidQuizSubmissionException(String messege){
        super(messege);
    }
}


class QuizProcess{

    public int calculateCores(String[] correctAnswers, String[] userAnswers)
        throws InvalidQuizSubmissionException{

            if(correctAnswers.length != userAnswers.length){
                throw new InvalidQuizSubmissionException(
                    "All answers not submitted"
                );
            }



            int score = 0;


            for(int i = 0;i <correctAnswers.length; i++){
                if(correctAnswers[i].equalsIgnoreCase(userAnswers[i])){
                    score++;
                }
            }
            return score;
        }
        public String getGrades(int score, int totalQuestions){
            double percentage = (score*100.0)/totalQuestions;

           
            if(percentage>=90) return "A";

            else if(percentage>=80) return "B";
            else if(percentage>=60) return "C";
            else if(percentage>=50) return "D";
           else return "F";
        }
}




public class OnlineQuiz{
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);

            QuizProcess quiz = new QuizProcess();


            List<Integer> scoreList = new ArrayList<>();


            String[] correctAnswers = {"A","B","C","C","D","A","B","A"};

            System.out.println("Enter number of users");
            int users = sc.nextInt();
            sc.nextLine();

            for(int u = 1;u <= users;u++){

                System.out.println("User "+u);
                String[] userAnswers=new String[correctAnswers.length];

                for(int i =0; i<userAnswers.length; i++){
                    System.out.println("Answer for question "+(i+1)+": ");
                    userAnswers[i] = sc.nextLine();
                }

                try{
                    int score = quiz.calculateCores(correctAnswers,userAnswers);
                    scoreList.add(score);
                    String grade = quiz.getGrades(score,correctAnswers.length);
                    System.out.println("Score: "+score);
                    System.out.println("Grade: "+grade);
                    System.out.println();


                }

                catch(InvalidQuizSubmissionException e){
                    System.out.println(e.getMessage());
                }
            }


            System.out.println("All scores");
            for(int i = 0;i<scoreList.size();i++){
                System.out.println("User "+(i+1)+": "+scoreList.get(i));
            }
        }
               

                


}
    