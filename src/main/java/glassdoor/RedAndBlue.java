package glassdoor;

/**
 * Created by Administrator on 16-3-22.
 */
public class RedAndBlue {
  public static void main(String[] args){
    int[] array = {1,0,1,0,0,0,1,1,1,0};
    new RedAndBlue().sort(array);
    for(int i = 0; i < array.length;i++){
      System.out.print(array[i] + ",");
    }
  }

  public void swap(int[] a, int i, int j){
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  public void sort(int[] array){
    if(array == null || array.length == 0) return;
    int i=0,j=array.length - 1;
    while (i < j){
      while (array[i] == 0) i++;
      while (array[j] == 1) j--;
      if(i < j){
        swap(array, i, j);
      }
    }
  }
}
