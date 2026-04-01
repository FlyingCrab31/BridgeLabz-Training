
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class JobRole {

    private final String title;

    public JobRole(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    // Each role defines its own matching logic
    public abstract boolean matchesSkills(java.util.List<String> skills);
}

class SoftwareEngineer extends JobRole {

    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public boolean matchesSkills(java.util.List<String> skills) {
        return skills.contains("Java") && skills.contains("Data Structures");
    }
}

class DataScientist extends JobRole {

    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public boolean matchesSkills(java.util.List<String> skills) {
        return skills.contains("Python") && skills.contains("Machine Learning");
    }
}

class ProductManager extends JobRole {

    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public boolean matchesSkills(java.util.List<String> skills) {
        return skills.contains("Roadmapping") && skills.contains("Stakeholder Management");
    }
}

class Resume<T extends JobRole> {

    private final String candidateName;
    private final java.util.List<String> skills;
    private final int yearsOfExperience;
    private final T targetRole;

    public Resume(String candidateName,
            java.util.List<String> skills,
            int yearsOfExperience,
            T targetRole) {
        this.candidateName = candidateName;
        this.skills = skills;
        this.yearsOfExperience = yearsOfExperience;
        this.targetRole = targetRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public java.util.List<String> getSkills() {
        return skills;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public T getTargetRole() {
        return targetRole;
    }

    @Override
    public String toString() {
        return "Resume{"
                + "name='" + candidateName + '\''
                + ", role='" + targetRole.getTitle() + '\''
                + ", experience=" + yearsOfExperience
                + ", skills=" + skills
                + '}';
    }
}

class ResumeScreeningEngine {

    // Generic method: screen a single resume of any JobRole subtype
    public static <T extends JobRole> boolean screenResume(Resume<T> resume) {
        T role = resume.getTargetRole();
        boolean skillsMatch = role.matchesSkills(resume.getSkills());
        boolean expOk = resume.getYearsOfExperience() >= 1; // simple rule
        return skillsMatch && expOk;
    }

    // Wildcard: handle resumes for any job role list in one pipeline
    public static void bulkScreen(
            java.util.List<? extends Resume<? extends JobRole>> resumes) {

        for (Resume<? extends JobRole> r : resumes) {
            boolean selected = screenAnyResume(r);
            System.out.println(r.getCandidateName()
                    + " applying for " + r.getTargetRole().getTitle()
                    + " -> " + (selected ? "SHORTLISTED" : "REJECTED"));
        }
    }

    // Helper using wildcard for a single resume
    private static boolean screenAnyResume(
            Resume<? extends JobRole> resume) {

        JobRole role = resume.getTargetRole(); // read as JobRole
        boolean skillsMatch = role.matchesSkills(resume.getSkills());
        boolean expOk = resume.getYearsOfExperience() >= 1;
        return skillsMatch && expOk;
    }
}

public class ResumeScreeningSystem {

    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>(
                "Amit",
                Arrays.asList("Java", "Spring", "Data Structures"),
                2,
                new SoftwareEngineer()
        );

        Resume<DataScientist> r2 = new Resume<>(
                "Neha",
                Arrays.asList("Python", "Machine Learning", "Pandas"),
                1,
                new DataScientist()
        );

        Resume<ProductManager> r3 = new Resume<>(
                "Rahul",
                Arrays.asList("Roadmapping", "Stakeholder Management"),
                3,
                new ProductManager()
        );

        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        resumes.add(r1);
        resumes.add(r2);
        resumes.add(r3);

        // bulk screening using wildcard method
        ResumeScreeningEngine.bulkScreen(resumes);
    }
}
