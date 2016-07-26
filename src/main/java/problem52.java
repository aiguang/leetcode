import java.util.ArrayList;
import java.util.List;

/**
 Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.


 */
public class problem52 {
  public int totalNQueens(int n) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    res.add(0);
    helper(n,0,new int[n],res);
    return res.get(0);
  }
  private void helper(int n, int row, int[] columnForRow, ArrayList<Integer> res) {
    if(row == n) {
      res.set(0,res.get(0)+1);
      return;
    }
    for(int i=0;i<n;i++) {
      columnForRow[row]=i;
      if(check(row,columnForRow)){
        helper(n,row+1,columnForRow,res);
      }
    }
  }
  private boolean check(int row, int[] columnForRow) {
    for(int i=0;i<row;i++) {
      if(columnForRow[i]==columnForRow[row] || Math.abs(columnForRow[row]-columnForRow[i])==row-i)
        return false;
    }
    return true;
  }
}
