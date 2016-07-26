/**
 * Created by Administrator on 16-2-18.
 */
public class problem50_1 {
  public static void main(String[] args){
    System.out.println(new problem50_1().myPow(34.00515, -3));
  }
  public double myPow(double x, int n) {
    if(n == 0) return 1;
    if(x == 1) return 1;
    if(n == 1) return x;

    if(n < 0) return 1.0/(myPow(x, Math.abs(n)));
    double tmp = myPow(x, n / 2);
    if(n % 2 == 0){
      return tmp * tmp;
    }else{
      return tmp * tmp * x;
    }
  }
}
