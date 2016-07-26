import java.util.ArrayList;
import java.util.List;

/**
 Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                   | 0 0 1 |
 */
public class problem311SparseMatrixMultiplication {
  class Element {
    int i;
    int val;
    Element(int idx, int value) {
      i=idx;
      val=value;
    }
  }
  public int[][] multiply(int[][] A, int[][] B) {
    if (A==null || B==null || A.length==0 || B.length == 0) return new int[0][0];
    List[] vectorB = new List[B.length];
    int[][] ret = new int[A.length][B[0].length];
    for (int i=0; i< B.length; i++) {
      for (int j=0; j< B[0].length; j++) {
        if (B[i][j] != 0) {
          List<Element> list = (List<Element>)vectorB[i] != null ? vectorB[i] : new ArrayList<Element>();
          list.add( new Element( j, B[i][j]) );
          vectorB[i] = list;
        }
      }
    }
    for (int i=0; i< A.length; i++) {
      for (int j=0; j< A[0].length; j++) {
        if ( ( A[i][j] != 0)  && (vectorB[j] != null) ) {
          for (Element elmB: (List<Element>)vectorB[j] ) {
            ret[i][elmB.i] += A[i][j]*elmB.val;
          }
        }
      }
    }
    return ret;
  }
}
