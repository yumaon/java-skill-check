import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;

public class C116 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer[] input = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    int iceCount = input[0];
    int checkPeriod = input[1];
    List<Integer> iceList = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    sc.close();

    boolean isOk = true;
    outer: while (iceList.size() >= checkPeriod) {
      if (iceList.get(0) == 1) {
        iceList.remove(0);
        continue;
      }

      for (int i = 0; i < checkPeriod; i++) {
        if (iceList.get(i) == 1) {
          iceList.remove(0);
          break;
        }

        if (i == checkPeriod - 1) {
          isOk = false;
          break outer;
        }
      }
    }

    if (isOk) {
      System.out.println("OK");
    } else {
      System.out.println("NG");
    }
  }
}
