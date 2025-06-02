import java.util.*;

public class C126 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int trainFee = Integer.parseInt(input[0]);
    int hotelNightFee = Integer.parseInt(input[1]);
    int internShipTimes = Integer.parseInt(input[2]);

    List<Integer[]> internPeriodArray = new ArrayList<>();
    for (int i = 0; i < internShipTimes; i++) {
      Integer[] internPeriod = Arrays.stream(sc.nextLine().split(" "))
          .map(Integer::parseInt)
          .toArray(Integer[]::new);

      internPeriodArray.add(internPeriod);
    }

    int totalCost = trainFee * 2;
    for (int i = 0; i < internShipTimes; i++) {
      if (i < internShipTimes - 1) {
        int periodUntilNextIntern = internPeriodArray.get(i + 1)[0] - internPeriodArray.get(i)[1];
        int possibleTrainFees = trainFee * 2;
        int possibleHotelCost = hotelNightFee * periodUntilNextIntern;
        if (possibleTrainFees < possibleHotelCost) {
          totalCost += possibleTrainFees;
        } else {
          totalCost += possibleHotelCost;
        }
      }
    }
    sc.close();

    System.out.println(totalCost);
  }
}
