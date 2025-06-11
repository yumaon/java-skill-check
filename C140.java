import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C140 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int lensTypeCount = Integer.parseInt(sc.nextLine());
    Map<Integer, Integer> lensMap = new HashMap<>();
    for (int i = 1; i <= lensTypeCount; i++) {
      lensMap.put(i, Integer.parseInt(sc.nextLine()));
    }
    int customerCount = Integer.parseInt(sc.nextLine());

    int result = 0;
    for (int i = 0; i < customerCount; i++) {
      Integer[] orderInput = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
      int r_order = orderInput[0];
      int l_order = orderInput[1];

      if (r_order != l_order) {
        int currentR_count = lensMap.get(r_order);
        int currentL_count = lensMap.get(l_order);
        if (currentR_count > 0 && currentL_count > 0) {
          result++;
          lensMap.put(r_order, currentR_count - 1);
          lensMap.put(l_order, currentL_count - 1);
        }
      } else {
        int currentLensCount = lensMap.get(r_order);
        if (currentLensCount > 1) {
          result++;
          lensMap.put(r_order, currentLensCount - 2);
        }
      }
    }
    sc.close();
    System.out.println(result);
  }
}
