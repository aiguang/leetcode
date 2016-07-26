package GeeksforGeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 16-3-9.
 */
public class GFG {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()){
      int num = sc.nextInt();
      System.out.println(GFG.IsTriangular(num));
    }
  }
  public static int IsTriangular(int num){
    int sum = 0;
    for(int i = 1; sum < num;i++){
      sum += i;
    }
    return sum == num ? 1 : 0;
  }

}
