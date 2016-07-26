package sprint;

/**
 * Created by Administrator on 16-4-28.
 */
public class MissingNumI {
  public static void main(String[] args){
    int[] a = {1,2,3,5};
    System.out.println(new MissingNumI().findMissing(a, 5));
  }
  public int findMissing(int[] array, int n){
    int ret = 0;

    for(int i = 0; i < array.length;i++){
      ret ^= (i + 1) ^ array[i];
    }
    return ret ^ n;
  }
}
