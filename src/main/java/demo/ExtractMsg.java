package demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 16-1-8.
 */
public class ExtractMsg {
  public static void main(String[] args) throws IOException {
    String path = "D:\\1231-0107error_detail\\yfq-error-detail-20160107.txt";
    Map<String, Integer> map = new HashMap<String, Integer>();
    File file = new File(path);

    BufferedReader reader = new BufferedReader(new FileReader(file));
    String tmp;
    boolean start = false;
    try {
      while ((tmp = reader.readLine()) != null){
        if(tmp.equals("CHECK KEYSTONE LOG")){
          start = true;
          continue;
        }
        if(!start) continue;
        if(!tmp.contains("]")){
          System.out.println("msg problem: " + tmp);
          continue;
        }
        String s = tmp.substring(tmp.indexOf("]") + 1, tmp.length());
        Integer count = map.get(s.toString());
        if(count == null){
          map.put(s.toString(), 1);
        }else {
          map.put(s.toString(), count + 1);
        }
      }
    }finally {
      reader.close();
    }
    String date = path.split("-|\\.")[4];
    BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\1231-0107error_detail\\error-stat."  + date));
    for(Map.Entry<String, Integer> entry : map.entrySet()){
      writer.write(entry.getKey() + "       " + entry.getValue());
      writer.newLine();
    }
    writer.close();
  }
}
