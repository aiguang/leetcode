/**
 * Created by Administrator on 15-7-15.
 *
 *
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

 For example:
 Given n = 13,
 Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        if(n <= 0){
            return 0;
        }
        int count = 0;
        while(n > 10){
            if(n % 10 == 1){
                count++;
            }
            n = n / 10;
        }


        return n == 10 ? count + 2 : count + 1;
    }
}
