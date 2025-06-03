import java.util.Scanner;
import java.util.HashMap;
import java.util.*;

public class C026 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int carrotCount = Integer.parseInt(input[0]);
    int sugarIndication = Integer.parseInt(input[1]);
    int tolerance = Integer.parseInt(input[2]);

    HashMap<Integer, Integer> carrotData = new HashMap<>();

    for (int i = 1; i <= carrotCount; i++) {
      String[] inputCarrotInfo = sc.nextLine().split(" ");
      int mass = Integer.parseInt(inputCarrotInfo[0]);
      int actualSugar = Integer.parseInt(inputCarrotInfo[1]);

      if (isSugarAcceptableRange(sugarIndication, tolerance, actualSugar)) {
        carrotData.put(i, mass);
      }
    }

    sc.close();

    if (carrotData.isEmpty()) {
      System.out.println("not found");
      return;
    }

    int maxMass = Collections.max(carrotData.values());
    Integer resultMinKey = null;
    for (Map.Entry<Integer, Integer> carrotEntry : carrotData.entrySet()) {
      if (carrotEntry.getValue().equals(maxMass)) {
        if (resultMinKey == null || carrotEntry.getKey() < resultMinKey) {
          resultMinKey = carrotEntry.getKey();
        }
      }
    }

    System.out.println(resultMinKey);
  }

  private static boolean isSugarAcceptableRange(int sugarIndication, int tolerance, int actualSugar) {
    int min = sugarIndication - tolerance;
    int max = sugarIndication + tolerance;

    return min <= actualSugar && actualSugar <= max;
  }
}
