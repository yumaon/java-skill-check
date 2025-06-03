import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class B117 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int carCount = Integer.parseInt(sc.nextLine());
    LinkedList<Integer> cars = new LinkedList<>();
    for (int i = 0; i < carCount; i++) {
      cars.add(Integer.parseInt(sc.nextLine()));
    }
    sc.close();

    int max = Collections.max(cars);
    int result = 0;
    while (cars.size() > 0) {
      int min = Collections.min(cars);
      int currentCar = cars.get(0);
      if (currentCar != min) {
        if (currentCar == max)
          result++;

        cars.remove(0);
        cars.add(currentCar);
        continue;
      } else if (currentCar == min) {
        if (currentCar == max)
          break;

        cars.remove(0);
        continue;
      }
    }

    System.out.println(result);
  }
}
