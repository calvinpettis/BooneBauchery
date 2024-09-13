package edu.appstate.cs.BooneBauchery.inventory;

/**
 * Hello world!
 *
 */
public class Inventory {
  public static int sum(int x, int y) {
    return x + y;
  }

  public static float computePercent(int numerator, int denominator) {
    if (denominator == 0) {
      return 0.0f;
    } else {
      return (numerator * 100.0f) / denominator;
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
