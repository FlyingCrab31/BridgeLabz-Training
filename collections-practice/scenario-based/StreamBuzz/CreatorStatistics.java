import java.util.*;

public class CreatorStatistics{
    public  String creatorName;
    public double[] weeklyLikes;

    public static List<CreatorStatistics> engagementBoard = new ArrayList<>();

    public CreatorStatistics(String creatorName, double[] weeklyLikes) {
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }
}