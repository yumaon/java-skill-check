import java.util.Scanner;

public class C062 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = Integer.parseInt(sc.nextLine());

    int result = 0;
    boolean isLimit = false;
    int limitCount = 10;
    for (int i = 0; i < count; i++) {
      String neta = sc.nextLine();
      if (isLimit) {
        limitCount--;
        if (limitCount == 0) {
          isLimit = false;
          limitCount = 10;
        }
        continue;
      }
      if (neta.equals("melon")) {
        result++;
        isLimit = true;
      }
    }
    sc.close();
    System.out.println(result);
  }
}
