
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class C107 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer[] input = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    int gameCount = input[0];
    int numberForScore = input[1];
    Map<Integer, List<Integer>> gameResult = new HashMap<>();
    NavigableMap<BigDecimal, Integer> calculationResult = new TreeMap<>();

    inputGemeResult(gameCount, sc, gameResult);

    for (Map.Entry<Integer, List<Integer>> result : gameResult.entrySet()) {
      List<BigDecimal> calcResultList = new ArrayList<>();

      while (result.getValue().size() >= numberForScore) {
        List<Integer> listforScore = new ArrayList<>();
        for (int i = 0; i < numberForScore; i++) {
          listforScore.add(result.getValue().get(i));
        }

        int scoreSum = listforScore.stream().mapToInt(Integer::intValue).sum();
        BigDecimal scoreSumDecimal = BigDecimal.valueOf(scoreSum);
        BigDecimal numberForScoreDecimal = BigDecimal.valueOf(numberForScore);
        BigDecimal scoreAverage = scoreSumDecimal.divide(numberForScoreDecimal, 2, RoundingMode.HALF_UP);

        calcResultList.add(scoreAverage);
        result.getValue().remove(0);
      }

      BigDecimal min = Collections.min(calcResultList);
      calculationResult.put(min, result.getKey());
    }
    BigDecimal minKey = calculationResult.firstKey();
    System.out.println(calculationResult.get(minKey));
  }

  private static void inputGemeResult(int gameCount, Scanner sc, Map<Integer, List<Integer>> gameResult) {
    for (int i = 1; i <= 3; i++) {
      List<Integer> rankList = new ArrayList<>();

      for (int j = 0; j < gameCount; j++) {
        int rank = Integer.parseInt(sc.nextLine());
        rankList.add(rank);
      }
      gameResult.put(i, rankList);
    }
  }
}
