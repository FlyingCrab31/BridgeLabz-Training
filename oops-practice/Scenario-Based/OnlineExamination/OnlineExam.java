import java.time.LocalDateTime;
import java.util.*;

// Custom exception for exam timing
class ExamTimeExpiredException extends Exception {
    public ExamTimeExpiredException(String message) {
        super(message);
    }
}

class Student {
    private final int id;
    private final String name;
    private final String email;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Student{" + id + ", " + name + "}";
    }
}

enum QuestionType {
    OBJECTIVE,
    DESCRIPTIVE
}

class Question {
    private final int id;
    private final String text;
    private final QuestionType type;
    private final List<String> options;   // used only for OBJECTIVE
    private final String correctAnswer;   // for OBJECTIVE (e.g. "A" or full text)

    public Question(int id, String text, QuestionType type,
                    List<String> options, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.options = options != null ? new ArrayList<>(options) : Collections.emptyList();
        this.correctAnswer = correctAnswer;
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public QuestionType getType() { return type; }
    public List<String> getOptions() { return Collections.unmodifiableList(options); }
    public String getCorrectAnswer() { return correctAnswer; }
}

class Exam {
    private final int id;
    private final String title;
    private final List<Question> questions = new ArrayList<>();
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public Exam(int id, String title,
                LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }
}

// Strategy interface
interface EvaluationStrategy {
    double evaluate(Exam exam,
                    Map<Integer, String> studentAnswers) throws ExamTimeExpiredException;
}

// Objective evaluation: auto check MCQs
class ObjectiveEvaluationStrategy implements EvaluationStrategy {

    private final double marksPerQuestion;

    public ObjectiveEvaluationStrategy(double marksPerQuestion) {
        this.marksPerQuestion = marksPerQuestion;
    }

    @Override
    public double evaluate(Exam exam,
                           Map<Integer, String> studentAnswers) throws ExamTimeExpiredException {
        validateTime(exam);
        double score = 0.0;
        for (Question q : exam.getQuestions()) {
            if (q.getType() == QuestionType.OBJECTIVE) {
                String submitted = studentAnswers.get(q.getId());
                if (submitted != null &&
                        submitted.trim().equalsIgnoreCase(q.getCorrectAnswer().trim())) {
                    score += marksPerQuestion;
                }
            }
        }
        return score;
    }

    private void validateTime(Exam exam) throws ExamTimeExpiredException {
        if (LocalDateTime.now().isAfter(exam.getEndTime())) {
            throw new ExamTimeExpiredException("Exam time is over. Cannot evaluate.");
        }
    }
}

// Descriptive evaluation: teacher/manual, here mocked
class DescriptiveEvaluationStrategy implements EvaluationStrategy {

    @Override
    public double evaluate(Exam exam,
                           Map<Integer, String> studentAnswers) throws ExamTimeExpiredException {
        validateTime(exam);
        // In real system: NLP/teacher rubric; here simple length-based mock
        double score = 0.0;
        for (Question q : exam.getQuestions()) {
            if (q.getType() == QuestionType.DESCRIPTIVE) {
                String ans = studentAnswers.get(q.getId());
                if (ans != null && ans.length() > 20) {
                    score += 5.0; // arbitrary
                }
            }
        }
        return score;
    }

    private void validateTime(Exam exam) throws ExamTimeExpiredException {
        if (LocalDateTime.now().isAfter(exam.getEndTime())) {
            throw new ExamTimeExpiredException("Exam time is over. Cannot evaluate.");
        }
    }
}

class Submission {

    private final Exam exam;
    private final Student student;
    private final Map<Integer, String> answers = new HashMap<>();
    private Double score; // cached after evaluation

    public Submission(Exam exam, Student student) {
        this.exam = exam;
        this.student = student;
    }

    public void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
    }

    public double evaluate(EvaluationStrategy strategy)
            throws ExamTimeExpiredException {
        this.score = strategy.evaluate(exam, answers);
        return this.score;
    }

    public Double getScore() {
        return score;
    }

    public Student getStudent() { return student; }
    public Exam getExam() { return exam; }
}

class OnlineExamService {

    private final Map<Integer, Exam> exams = new HashMap<>();
    private final Map<Integer, Student> students = new HashMap<>();
    private final Map<Integer, List<Student>> examEnrollments = new HashMap<>();
    private final Map<String, Submission> submissions = new HashMap<>();
    // key: examId + "-" + studentId

    // Exam creation (C in CRUD)
    public void createExam(Exam exam) {
        exams.put(exam.getId(), exam);
    }

    public Exam getExam(int examId) {
        Exam e = exams.get(examId);
        if (e == null) throw new IllegalArgumentException("Exam not found");
        return e;
    }

    // Student CRUD (simplified to register)
    public void registerStudent(Student s) {
        students.put(s.getId(), s);
    }

    public Student getStudent(int studentId) {
        Student s = students.get(studentId);
        if (s == null) throw new IllegalArgumentException("Student not found");
        return s;
    }

    // Enrollment
    public void enrollStudent(int examId, int studentId) {
        Exam exam = getExam(examId);
        Student student = getStudent(studentId);
        examEnrollments
                .computeIfAbsent(exam.getId(), k -> new ArrayList<>())
                .add(student);
    }

    // Answer submission
    public Submission startSubmission(int examId, int studentId) {
        Exam exam = getExam(examId);
        Student student = getStudent(studentId);
        String key = key(examId, studentId);
        Submission submission = new Submission(exam, student);
        submissions.put(key, submission);
        return submission;
    }

    public Submission getSubmission(int examId, int studentId) {
        Submission s = submissions.get(key(examId, studentId));
        if (s == null) throw new IllegalArgumentException("Submission not found");
        return s;
    }

    // Result generation using chosen strategy
    public double generateResult(int examId, int studentId,
                                 EvaluationStrategy strategy)
            throws ExamTimeExpiredException {
        Submission submission = getSubmission(examId, studentId);
        return submission.evaluate(strategy);
    }

    private String key(int examId, int studentId) {
        return examId + "-" + studentId;
    }
}

public class OnlineExam {
    public static void main(String[] args) {
        OnlineExamService service = new OnlineExamService();

        // Create student
        Student s1 = new Student(1, "Rishabh", "rishabh@example.com");
        service.registerStudent(s1);

        // Create exam with start/end times
        LocalDateTime start = LocalDateTime.now().minusMinutes(1);
        LocalDateTime end = LocalDateTime.now().plusMinutes(30);
        Exam exam = new Exam(101, "Java Basics Exam", start, end);

        // Add questions (objective + descriptive)
        Question q1 = new Question(
                1,
                "Which keyword is used to inherit a class in Java?",
                QuestionType.OBJECTIVE,
                Arrays.asList("A) implements", "B) extends", "C) inherit", "D) super"),
                "B"
        );
        Question q2 = new Question(
                2,
                "Explain the concept of polymorphism in Java.",
                QuestionType.DESCRIPTIVE,
                null,
                null
        );
        exam.addQuestion(q1);
        exam.addQuestion(q2);

        service.createExam(exam);
        service.enrollStudent(exam.getId(), s1.getId());

        // Student starts submission
        Submission submission = service.startSubmission(exam.getId(), s1.getId());
        submission.submitAnswer(1, "B"); // correct
        submission.submitAnswer(2, "Polymorphism allows one interface, many implementations...");

        // Choose strategies
        EvaluationStrategy objectiveStrategy = new ObjectiveEvaluationStrategy(2.0);
        EvaluationStrategy descriptiveStrategy = new DescriptiveEvaluationStrategy();

        try {
            double objectiveScore =
                    service.generateResult(exam.getId(), s1.getId(), objectiveStrategy);
            double descriptiveScore =
                    service.generateResult(exam.getId(), s1.getId(), descriptiveStrategy);

            double total = objectiveScore + descriptiveScore;
            System.out.println("Student: " + s1.getName());
            System.out.println("Objective score: " + objectiveScore);
            System.out.println("Descriptive score: " + descriptiveScore);
            System.out.println("Total score: " + total);
        } catch (ExamTimeExpiredException e) {
            System.out.println("Cannot evaluate: " + e.getMessage());
        }
    }
}


