public class MatrixAdvanced {
    
    // Method to create a random matrix
    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10); // Random 0-9
            }
        }
        
        return matrix;
    }
    
    // Method to find transpose of a matrix
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        
        return result;
    }
    
    // Method to find determinant of 2x2 matrix
    public static double determinant2x2(double[][] matrix) {
        // determinant = ad - bc
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }
    
    // Method to find determinant of 3x3 matrix
    public static double determinant3x3(double[][] matrix) {
        // det(M) = a(ei - fh) - b(di - fg) + c(dh - eg)
        double a = matrix[0][0], b = matrix[0][1], c = matrix[0][2];
        double d = matrix[1][0], e = matrix[1][1], f = matrix[1][2];
        double g = matrix[2][0], h = matrix[2][1], i = matrix[2][2];
        
        return a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g);
    }
    
    // Method to find inverse of 2x2 matrix
    public static double[][] inverse2x2(double[][] matrix) {
        double det = determinant2x2(matrix);
        
        if (det == 0) {
            System.out.println("Matrix is singular, inverse doesn't exist");
            return null;
        }
        
        double[][] inverse = new double[2][2];
        
        // Inverse formula for 2x2: (1/det) * [d -b; -c a]
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;
        
        return inverse;
    }
    
    // Method to find inverse of 3x3 matrix
    public static double[][] inverse3x3(double[][] matrix) {
        double det = determinant3x3(matrix);
        
        if (det == 0) {
            System.out.println("Matrix is singular, inverse doesn't exist");
            return null;
        }
        
        double[][] inverse = new double[3][3];
        
        // Calculate adjoint matrix and divide by determinant
        inverse[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) / det;
        inverse[0][1] = (matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2]) / det;
        inverse[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]) / det;
        
        inverse[1][0] = (matrix[1][2] * matrix[2][0] - matrix[1][0] * matrix[2][2]) / det;
        inverse[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]) / det;
        inverse[1][2] = (matrix[0][2] * matrix[1][0] - matrix[0][0] * matrix[1][2]) / det;
        
        inverse[2][0] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]) / det;
        inverse[2][1] = (matrix[0][1] * matrix[2][0] - matrix[0][0] * matrix[2][1]) / det;
        inverse[2][2] = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) / det;
        
        return inverse;
    }
    
    // Method to display a matrix
    public static void displayMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%.2f\t", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // Test with 2x2 matrix
        System.out.println("===== 2x2 Matrix Operations =====");
        double[][] matrix2x2 = {{4, 7}, {2, 6}};
        
        System.out.println("Original Matrix:");
        displayMatrix(matrix2x2);
        
        System.out.println("\nTranspose:");
        double[][] transpose2x2 = transpose(matrix2x2);
        displayMatrix(transpose2x2);
        
        double det2x2 = determinant2x2(matrix2x2);
        System.out.println("\nDeterminant: " + det2x2);
        
        System.out.println("\nInverse:");
        double[][] inverse2x2 = inverse2x2(matrix2x2);
        if (inverse2x2 != null) {
            displayMatrix(inverse2x2);
        }


        // Test with 3x3 matrix
        System.out.println("\n===== 3x3 Matrix Operations =====");
        double[][] matrix3x3 = {{6, 1, 1}, {4, -2, 5}, {2, 8, 7}};

        System.out.println("Original Matrix:");
        displayMatrix(matrix3x3);
        System.out.println("\nTranspose:");

        double[][] transpose3x3 = transpose(matrix3x3);
        displayMatrix(transpose3x3);
        double det3x3 = determinant3x3(matrix3x3);
        System.out.println("\nDeterminant: " + det3x3);
        System.out.println("\nInverse:");
        double[][] inverse3x3 = inverse3x3(matrix3x3);
        if (inverse3x3 != null) {
            displayMatrix(inverse3x3);
        }
    }
}


