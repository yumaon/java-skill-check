import java.util.*;

public class C105 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = Integer.parseInt(sc.nextLine());
    Integer[] scores = Arrays.stream(sc.nextLine().split(" "))
        .map(Integer::parseInt)
        .toArray(Integer[]::new);
    sc.close();
    Arrays.sort(scores);

    List<List<Integer>> groupScoreList = new ArrayList<>();

    for (int i = 0; i < count; i++) {
      if (groupScoreList.size() == 0) {
        List<Integer> scoreGroup = new ArrayList<>();
        scoreGroup.add(scores[i]);
        groupScoreList.add(scoreGroup);
        continue;
      }

      int targetScore = groupScoreList.get(groupScoreList.size() - 1)
          .get(groupScoreList.get(groupScoreList.size() - 1).size() - 1);

      if (scores[i] - 1 == targetScore) {
        groupScoreList.get(groupScoreList.size() - 1).add(scores[i]);
      } else {
        List<Integer> scoreGroup = new ArrayList<>();
        scoreGroup.add(scores[i]);
        groupScoreList.add(scoreGroup);
      }
    }

    int totalScore = 0;
    for (List<Integer> gropScore : groupScoreList) {
      int max = Collections.max(gropScore);
      totalScore += max;
    }

    System.out.println(totalScore);
  }
}
