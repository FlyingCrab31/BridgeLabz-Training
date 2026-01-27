package EduResults;

// MergeSortRankStrategy.java
import java.util.ArrayList;
import java.util.List;

public class MergeSortRankStrategy implements RankSortingStrategy {

    @Override
    public void sort(List<Student> students) {
        if (students == null || students.size() <= 1) return;
        mergeSort(students, 0, students.size() - 1);
    }

    private void mergeSort(List<Student> list, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(list, left, mid);
        mergeSort(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    private void merge(List<Student> list, int left, int mid, int right) {
        List<Student> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            // Descending by score; stable for equal scores
            if (list.get(i).getScore() >= list.get(j).getScore()) {
                temp.add(list.get(i++));
            } else {
                temp.add(list.get(j++));
            }
        }
        while (i <= mid) temp.add(list.get(i++));
        while (j <= right) temp.add(list.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }
}

