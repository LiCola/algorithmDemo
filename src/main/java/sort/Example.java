package sort;

/**
 * Created by LiCola on 2018/3/2.
 */
public class Example {

  public static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  public static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void show(Comparable[] a) {
//    StringBuilder stringBuilder = new StringBuilder();
//    for (int i = 0; i < a.length; i++) {
//      stringBuilder.append(a[i]).append(' ');
//    }
//    LLogger.d(stringBuilder.toString());
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }


}
