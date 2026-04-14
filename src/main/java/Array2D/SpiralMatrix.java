package Array2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given an m x n matrix, return all elements in spiral order
  (right → down → left → up, repeating inward).

 * Example:
    Input:  [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]

 * Logic:
    1. Maintain four boundaries: row (top), endRow (bottom), col (left), endCol (right).
    2. Traverse right along the top row, then down along the right column.
    3. If rows remain, traverse left along the bottom row.
    4. If columns remain, traverse up along the left column.
    5. Shrink boundaries inward and repeat until all elements are collected.

 * Time Complexity:  O(m * n) — every element is visited exactly once.
 * Space Complexity: O(1) — excluding the output list.
 */
public class SpiralMatrix {

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
        spiralOrder(matrix).forEach(x -> System.out.print(x + " "));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowSize = matrix.length - 1;
        int colSize = matrix[0].length - 1;

        // Initialize four boundaries
        int row = 0, endRow = rowSize, col = 0, endCol = colSize;
        List<Integer> result = new ArrayList<>();

        while(row <= endRow && col <= endCol) {

            // Traverse right along the top row
            for(int i = col; i <= endCol; i++) {
                result.add(matrix[row][i]);
            }
            // Traverse down along the right column
            for(int j = row + 1; j <= endRow; j++) {
                result.add(matrix[j][endCol]);
            }

            // Traverse left along the bottom row (only if there are remaining rows)
            if(row < endRow) {
                for(int j = endCol - 1; j >= col; j--) {
                    result.add(matrix[endRow][j]);
                }
            }
            // Traverse up along the left column (only if there are remaining columns)
            if(col < endCol) {
                for(int i = endRow - 1; i > row; i--) {
                    result.add(matrix[i][col]);
                }
            }
            // Shrink all four boundaries inward
            row++;
            col++;
            endRow--;
            endCol--;
        }
        return result;
    }

    public static List<Integer> spiralOrderClean(int[][] matrix) {
        int rowSize = matrix.length - 1;
        int colSize = matrix[0].length - 1;
        int row = 0, endRow = rowSize, col = 0, endCol = colSize;
        List<Integer> result = new ArrayList<>();
        while(row <= endRow && col <= endCol) {
            for(int i = col; i <= endCol; i++) result.add(matrix[row][i]);
            for(int j = row + 1; j <= endRow; j++) result.add(matrix[j][endCol]);
            if(row < endRow) {
                for(int j = endCol - 1; j >= col; j--) result.add(matrix[endRow][j]);
            }
            if(col < endCol) {
                for(int i = endRow - 1; i > row; i--) result.add(matrix[i][col]);
            }
            row++;
            col++;
            endRow--;
            endCol--;
        }
        return result;
    }
}
