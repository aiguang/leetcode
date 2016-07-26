package cci.pra1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 15-7-30.
 * 1.1 实现一个算法，确定一个字符串中的所有字符是否都不相同。如果不可以使用额外的数据结构，该如何处理。
 * 也可以排序nlogn
 */
public class cci1_1 {
    public boolean isAllSame(String test){
        if(test == null || test.length() == 0 ) return true;
        if(test.length() > 256) return false;
        //排序，然后比较  复杂度可以做到nlogn 或者用 ascII字符一共256，如果超过256就是false，否则用个bool数组去存
        int[] result = new int[256];
        char[] array = test.toCharArray();
        for(Character character : array){
            if(result[character.charValue()] == 0){
                result[character.charValue()]++;
            }else{
                return false;
            }
        }
        return true;
    }
}
