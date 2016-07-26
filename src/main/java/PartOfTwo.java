/**
 * Created by Administrator on 15-7-15.
 */

/**
 * 求是否为2的幂
 * 2的幂有个很显著的特征就是转为二进制的时候第一位是1，其他都是0；如果将其减1，则所有位都是1，
 * 所以按位与就可以进行判断
 */
public class PartOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        return  (n & n-1) == 0;
    }
}
