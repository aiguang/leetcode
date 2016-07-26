package sprint;

import org.omg.DynamicAny._DynArrayStub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-4-28.
 */
public class MissingNumII {
  public static void main(String[] args){
    int[] array = {1,2,5};
    List<Integer> result = new MissingNumII().findMissing(array, 5);
    System.out.println(result.get(0) + "____" + result.get(1));
  }
  public List<Integer> findMissing(int[] array, int n){
    if(array == null || array.length != n - 2) return new ArrayList<Integer>();
    if(n <= 0) return new ArrayList<Integer>();

    int ret = 0;
    for(int i = 0; i < array.length;i++){
      ret ^= (i + 1) ^ array[i];
    }
    ret ^= (n-1);
    ret ^= n;

    int missing1 = 0, missing2=0;
    int digit = ret - (ret & (ret - 1));
    for(int i = 0; i < array.length;i++){
      if((digit & array[i]) != 0){
        missing1 ^= array[i];
      }
      if((digit & (i+1)) != 0){
        missing1 ^= (i + 1);
      }
    }
    if(((n -1) & digit) != 0)
      missing1 ^= (n -1);
    if((n & digit) != 0){
      missing1 ^= n;
    }
    missing2 = ret ^ missing1;
    List<Integer> result = new ArrayList<Integer>();
    result.add(missing1);
    result.add(missing2);
    return result;
  }
}
