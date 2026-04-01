package EduResults;

// Student.java
public class Student {
    private final String id;
    private final String name;
    private final int score;
    private final String district;

    public Student(String id, String name, int score, String district) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.district = district;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getScore() { return score; }
    public String getDistrict() { return district; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + score + " | " + district;
    }
}

