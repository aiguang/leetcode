import java.util.List;
import java.util.Set;

/**
 Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down.
 You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class problem329 {
  public int longestIncreasingPath(int[][] matrix) {
    if(matrix == null || matrix.length == 0) return 0;
    int max =  0;

    for(int i = 0; i < matrix.length;i++){
      for(int j = 0;j < matrix[0].length;j++){
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        max = Math.max(helper(matrix, visited, i, j), max);
      }
    }
    return max;
  }
  private int helper(int[][] matrix, boolean[][] visited, int row,int column){
    if(row >= matrix.length || column >= matrix[0].length || visited[row][column] ||
        row < 0 || column < 0){
      return 0;
    }
    visited[row][column] = true;
    int leftTop = 0, leftEnd = 0, rightTop = 0, rightEnd = 0;
    if(row >= 1 && matrix[row - 1][column] > matrix[row][column]){
      leftTop = 1 + helper(matrix, visited, row - 1, column);
    }
    if(row < matrix.length - 1 && matrix[row + 1][column] > matrix[row][column]){
      rightTop = 1 + helper(matrix, visited, row + 1, column);
    }
    if(column >= 1 && matrix[row][column - 1] > matrix[row][column]){
      leftEnd = 1 + helper(matrix, visited, row, column - 1);
    }
    if(column < matrix[0].length - 1 && matrix[row][column + 1] > matrix[row][column]){
      rightEnd = 1 + helper(matrix, visited, row + 1, column);
    }
    return Math.max(leftTop, Math.max(rightTop, Math.max(leftEnd, rightEnd)));
  }
}
