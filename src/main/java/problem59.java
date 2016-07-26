/**
 Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class problem59 {
  public static void main(String[] args){
    int n = 2;
    new problem59().generateMatrix(n);
  }
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int levelNum = n / 2;
    int num = 1;
    for(int level = 0; level < levelNum; level++){
      for(int i = level;i < n - level - 1;i++){
        matrix[level][i] = num++;
      }
      for(int i = level; i < n - level - 1;i++){
        matrix[i][n - level - 1] = num++;
      }
      for(int i = n - level - 1;i > level;i--){
        matrix[n - level - 1][i] = num++;
      }
      for(int i = n - level - 1;i > level;i--){
        matrix[i][level] = num++;
      }
    }
    if(n % 2 == 1){
      matrix[levelNum][levelNum] = num;
    }
    return matrix;
  }
}
