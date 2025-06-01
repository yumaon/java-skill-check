import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C053 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();
    sc.nextLine();
    List<Integer> points = new ArrayList<>();

    boolean exists_x10 = false;
    boolean exists_0 = false;
    String[] inputs = sc.nextLine().split(" ");
    for (String input : inputs) {
      if (input.equals("x10")) {
        exists_x10 = true;
        continue;
      }
      if (input.equals("0")) {
        exists_0 = true;
        continue;
      }

      try {
        int point = Integer.parseInt(input);
        points.add(point);
      } catch (NumberFormatException e) {
        System.out.println(e.getMessage());
      }
    }

    Integer max = Collections.max(points);
    if (exists_0)
      points.remove(max);

    int totalPoinst = points.stream().reduce(0, (a, b) -> a + b);
    if (exists_x10) {
      totalPoinst *= 10;
    }
    System.out.println(totalPoinst);
    sc.close();
  }
}
