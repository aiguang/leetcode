/**
 Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */
public class problem165 {
  public static void main(String[] args){
    String version1 = "1";
    String version2 = "1.0.0";
    System.out.println(new problem165().compareVersion(version1, version2));
  }
  public int compareVersion(String version1, String version2) {
    if(version1 == null || version1.isEmpty() ||
       version2 == null || version2.isEmpty()) return 0;
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int length = v1.length < v2.length ? v2.length : v1.length;
    for(int i = 0; i < length;i++){
      Integer tmp1;
      if(i > v1.length - 1){
        tmp1 = null;
      }else{
        tmp1 = Integer.parseInt(v1[i]);
      }
      Integer tmp2 = null;
      if(i > v2.length - 1){
        tmp2 = null;
      }else{
        tmp2 = Integer.parseInt(v2[i]);
      }
      if(tmp1 != null && tmp2 != null){
        if(tmp1 < tmp2) return -1;
        else if(tmp1 > tmp2) return 1;
        else continue;
      }
      if(tmp1 == null && tmp2 != null){
        if(tmp2 == 0) continue;
        else return -1;
      }
      if(tmp1 != null && tmp2 == null){
        if(tmp1 == 0) continue;
        else return 1;
      }
    }
    return 0;
  }
}
