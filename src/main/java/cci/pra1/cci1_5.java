package cci.pra1;

/**
 * Created by Administrator on 15-7-30.
 * 1.5 simulate zip,写一个方法模拟字符串压缩，比如aabbccdddd改为a2b2c3d4,如果压缩后没有变短则返回原字符串
 *
 * me：扫一遍
 */
public class cci1_5 {
    public String simulateZip(String test){
        if(test == null || test.length() == 0) return test;
        StringBuilder sb = new StringBuilder();

        char tmp = test.charAt(0);
        int result = 0;
        for(int i = 0 ; i < test.length(); i++){
            if(test.charAt(i) == tmp){
                result++;
            }else{
                sb.append(test.charAt(i - 1)).append(result);
                result = 0;
                tmp = test.charAt(i);
                i--;
            }
        }
        return sb.length() > test.length() ? test : sb.toString();
    }
}
