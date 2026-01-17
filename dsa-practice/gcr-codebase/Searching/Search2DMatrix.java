
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / cols;   // map 1D index to row
            int col = mid % cols;   // map 1D index to col

            int midVal = matrix[row][col];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;     // search right half
            } else {
                right = mid - 1;    // search left half
            }
        }

        return false; // not found
    }

    // main method for testing
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target)); // Output: true

        target = 13;
        System.out.println(searchMatrix(matrix, target)); // Output: false
    }
}
