import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C119 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer[] input = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    int houseCount = input[0];
    int mensCount = input[1];
    int limit = input[2];

    Set<Integer> menStandbyLocationNums = new HashSet<>();
    inputMenStandbyLocationNums(sc, mensCount, menStandbyLocationNums);
    sc.close();

    int aliceResult = aliceGoesToGetCandy(houseCount, limit, menStandbyLocationNums);

    System.out.println(aliceResult);
  }

  private static void inputMenStandbyLocationNums(Scanner sc, int mensCount, Set<Integer> menStandbyLocationNums) {
    for (int i = 0; i < mensCount; i++) {
      int locationNumber = Integer.parseInt(sc.nextLine());
      menStandbyLocationNums.add(locationNumber);
    }
  }

  private static int aliceGoesToGetCandy(int houseCount, int limit, Set<Integer> menStandbyLocationNums) {
    int aliceResult = 0;
    int encounterTimes = 0;
    for (int i = 1; i <= houseCount; i++) {
      boolean isEncounter = menStandbyLocationNums.contains(i);
      if (isEncounter) {
        encounterTimes++;
        if (encounterTimes == limit)
          break;
      } else {
        aliceResult++;
        encounterTimes = 0;
      }
    }
    return aliceResult;
  }
}
