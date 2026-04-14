package Array2D;

/**
 * Problem: Given an m x n matrix where each row is sorted in ascending order and the first
  element of each row is greater than the last element of the previous row, determine if
  a target value exists in the matrix.

 * Example:
    Input:  matrix = [[1,2,3],[4,5,6],[7,8,9]], target = 7
    Output: true

 * Logic:
    1. Treat the 2D matrix as a virtual 1D sorted array of length m * n.
    2. Apply standard binary search on indices 0 to (m*n - 1).
    3. Convert the 1D mid index to 2D coordinates: row = mid / n, col = mid % n.
    4. Compare matrix[row][col] with target and adjust low/high accordingly.

 * Time Complexity:  O(log(m * n)) — binary search over the flattened matrix.
 * Space Complexity: O(1) — only a few pointer variables used.
 */
public class BinarySearchInMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        // Binary search over the virtual 1D array
        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert 1D index to 2D row and column
            int row = mid / n;
            int col = mid % n;

            int val = matrix[row][col];

            if (val == target) return true;
            else if (val < target) low = mid + 1;   // Target is in the right half
            else high = mid - 1;                     // Target is in the left half
        }
        return false;
    }

    public static boolean searchMatrixClean(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            int val = matrix[row][col];
            if (val == target) return true;
            else if (val < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] matrix = new int[n][m];
        int index = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = index;
                index++;
            }
        }
        System.out.println(searchMatrix(matrix, 7));
    }
}
