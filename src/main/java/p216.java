import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 15-8-10.
 *
 *
 Find all possible combinations of k numbers that add up to a number n,
 given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.


     Example 1:

     Input: k = 3, n = 7

     Output:

     [[1,2,4]]

     Example 2:

     Input: k = 3, n = 9

     Output:

     [[1,2,6], [1,3,5], [2,3,4]]
*/
public class p216 {
    public static void  main(String[] args){
        int k = 3;
        int n =15;
        List<List<Integer>> list = new p216().combinationSum3(k, n);
        for(List<Integer> tmp : list){
            for(Integer value : tmp){
                System.out.print(value + ",");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> tmpResult = new ArrayList<Integer>();
        calculate(n, 1, k, result, tmpResult);
        return result;
    }
    public void calculate(int target, int current, int num, List<List<Integer>> result, List<Integer> tmpResult){

        int value = sum(tmpResult);
        if(tmpResult.size() > num) return;
        if(value == target){
            if(tmpResult.size() != num) return;
            List<Integer> t = new ArrayList<Integer>(Arrays.asList(new Integer[tmpResult.size()]));
            Collections.copy(t, tmpResult);
            result.add(t);
            return;
        }else if(value > target){
            return;
        }else{
            for(int i = current; i <= target && i <= 9; i++){
                tmpResult.add(i);
                calculate(target, i + 1, num, result, tmpResult);
                tmpResult.remove(tmpResult.size() - 1);
            }
        }


    }
    private int sum(List<Integer> list){
        int result = 0;
        for(Integer value : list){
            result += value;
        }
        return result;
    }
}
