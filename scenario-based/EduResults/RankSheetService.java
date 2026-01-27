package EduResults;

// RankSheetService.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankSheetService {

    private final RankSortingStrategy sortingStrategy;

    public RankSheetService(RankSortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    // If each district list is already sorted, use multi-way merge
    public List<Student> mergeDistrictLists(List<List<Student>> districtLists) {
        if (districtLists == null || districtLists.isEmpty()) {
            return Collections.emptyList();
        }
        List<Student> merged = new ArrayList<>(districtLists.get(0));

        for (int i = 1; i < districtLists.size(); i++) {
            merged = mergeTwoSortedLists(merged, districtLists.get(i));
        }
        return merged;
    }

    private List<Student> mergeTwoSortedLists(List<Student> a, List<Student> b) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i).getScore() >= b.get(j).getScore()) {
                result.add(a.get(i++));  // stable
            } else {
                result.add(b.get(j++));
            }
        }
        while (i < a.size()) result.add(a.get(i++));
        while (j < b.size()) result.add(b.get(j++));
        return result;
    }

    // If district lists are not guaranteed sorted, first concatenate then sort via strategy
    public List<Student> generateStateRankListUnsortedDistricts(List<List<Student>> districtLists) {
        List<Student> all = new ArrayList<>();
        for (List<Student> d : districtLists) {
            all.addAll(d);
        }
        sortingStrategy.sort(all);
        return all;
    }
}

