import java.util.Scanner;

public class C073 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int distance = Integer.parseInt(sc.nextLine());
    String[] input = sc.nextLine().split(" ");
    int u_speed = Integer.parseInt(input[0]);
    int handeDistance = Integer.parseInt(input[1]);
    int handeTime = Integer.parseInt(input[2]);
    int v_speed = Integer.parseInt(sc.nextLine());
    sc.close();

    int kameResult = v_speed * distance;
    int usagiResult = 0;
    for (int i = 0; i < distance; i++) {
      if (i % handeDistance == 0 && i != 0)
        usagiResult += handeTime;

      usagiResult += u_speed;
    }

    if (kameResult < usagiResult) {
      System.out.println("KAME");
    } else if (kameResult > usagiResult) {
      System.out.println("USAGI");

    } else {
      System.out.println("DRAW");
    }
  }
}
