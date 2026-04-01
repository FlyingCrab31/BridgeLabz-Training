package EduResults;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {



        public static void main(String[] args) {

            List<Student> districtA = Arrays.asList(
                    new Student("A101", "Ravi", 95, "DistrictA"),
                    new Student("A102", "Sneha", 90, "DistrictA"),
                    new Student("A103", "Aman", 88, "DistrictA")
            );

            List<Student> districtB = Arrays.asList(
                    new Student("B201", "Priya", 98, "DistrictB"),
                    new Student("B202", "Karan", 92, "DistrictB"),
                    new Student("B203", "Neha", 88, "DistrictB")
            );

            List<Student> districtC = Arrays.asList(
                    new Student("C301", "Vikram", 96, "DistrictC"),
                    new Student("C302", "Anita", 89, "DistrictC")
            );

            List<List<Student>> districtLists = new ArrayList<>();
            districtLists.add(new ArrayList<>(districtA));
            districtLists.add(new ArrayList<>(districtB));
            districtLists.add(new ArrayList<>(districtC));

            RankSortingStrategy strategy = new MergeSortRankStrategy();
            RankSheetService rankService = new RankSheetService(strategy);

            // Case 1: District lists already sorted -> merge them
            List<Student> stateRankList = rankService.mergeDistrictLists(districtLists);

            // If district lists were unsorted, you would instead call:
            // List<Student> stateRankList = rankService.generateStateRankListUnsortedDistricts(districtLists);

            System.out.println("Final State-wise Rank List (score desc):");
            int rank = 1;
            for (Student s : stateRankList) {
                System.out.println(rank + " -> " + s);
                rank++;
            }
        }
    }
