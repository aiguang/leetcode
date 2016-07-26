package cci.pra1;

/**
 * Created by Administrator on 15-7-30.
 * 1.2 反转字符串
 */
public class cci1_2 {
    public String reverse(String test){
        if(test == null || test.length() == 0) return test;
        char[] array = new char[test.length()];
        for(int i = 0; i < test.length(); i++){
            array[test.length() - i - 1] = test.charAt(i);
        }
        return array.toString();
    }
}
