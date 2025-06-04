import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class C081 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int socksCount = Integer.parseInt(sc.nextLine());

    HashMap<String, List<String>> socksInfo = new HashMap<>();

    int result = 0;

    for (int i = 0; i < socksCount; i++) {
      String[] input = sc.nextLine().split(" ");
      String type = input[0];
      String r_l = input[1];

      if (socksInfo.containsKey(type)) {
        List<String> r_l_List = socksInfo.get(type);
        result = count_r_and_l_as_a_set(r_l_List, result, r_l);
      } else {
        List<String> r_l_list = new ArrayList<>();
        r_l_list.add(r_l);
        socksInfo.put(type, r_l_list);
      }
    }
    sc.close();

    System.out.println(result);
  }

  private static int count_r_and_l_as_a_set(List<String> r_l_List, int result, String r_l) {
    String target_r_l = "";
    if (r_l.equals("R"))
      target_r_l = "L";
    if (r_l.equals("L"))
      target_r_l = "R";

    if (r_l_List.contains(target_r_l)) {
      result++;
      int targetIndex = r_l_List.indexOf(target_r_l);
      r_l_List.remove(targetIndex);
    } else {
      r_l_List.add(r_l);
    }

    return result;
  }
}
