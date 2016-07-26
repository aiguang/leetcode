package cci.pra1;

/**
 * Created by Administrator on 15-7-30.
 * 1.4 将字符串中的空格全部替换为%20，如果是java用字符串数组
 * me：看上去就是扫一遍啊
 */
public class cci1_4 {
    /**
     *
     * @param source   标注数组
     * @param tobeReplaced  标志要被替换成的字符串
     */
    public void replace(String[] source, String tobeReplaced ){
        for(int i = 0 ; i < source.length ; i++){
            if(" ".equals(source[i])){
                source[i] = tobeReplaced;
            }
        }
    }
}
