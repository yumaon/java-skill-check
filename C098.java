import java.util.LinkedHashMap;
import java.util.Scanner;

public class C098 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int peopeleCount = Integer.parseInt(sc.nextLine());
    LinkedHashMap<Integer, Integer> playerBallCounts = new LinkedHashMap<>();
    for (int i = 1; i <= peopeleCount; i++) {
      Integer ballCount = Integer.parseInt(sc.nextLine());
      playerBallCounts.put(i, ballCount);
    }

    int passInfoCount = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < passInfoCount; i++) {
      String[] input = sc.nextLine().split(" ");
      int senderUserNumber = Integer.parseInt(input[0]);
      int receiverUserNumber = Integer.parseInt(input[1]);
      int declarationBallCount = Integer.parseInt(input[2]);
      int countOfBallsActuallySent = declarationBallCount;
      int countBallHasSender = playerBallCounts.get(senderUserNumber);
      int countBallHasReceiver = playerBallCounts.get(receiverUserNumber);

      if (countBallHasSender < declarationBallCount) {
        countOfBallsActuallySent = playerBallCounts.get(senderUserNumber);
        playerBallCounts.put(senderUserNumber, 0);
      } else {
        playerBallCounts.put(senderUserNumber, countBallHasSender - declarationBallCount);
      }

      playerBallCounts.put(receiverUserNumber, countBallHasReceiver + countOfBallsActuallySent);
    }

    for (int value : playerBallCounts.values()) {
      System.out.println(value);
    }
  }
}
