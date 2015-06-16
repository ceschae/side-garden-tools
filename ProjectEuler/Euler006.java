/**
 * Project Euler: Problem 6
 * 'Sum Square Difference'
 * Finds the difference between the square of sums of numbers 1 to TARGET and
 * the sum of squares of numbers 1 to TARGET.  
 *
 * @author  Caitlin Schaefer
 * @version 2.0
 * @since   16-June-2015
 */

public class Euler006 {
   public static final int TARGET = 100;
   
   public static void main(String[] args) {
      version2();
   }
   
   /**
    * Attepmt 2. Uses a newer version of the calculation of sum of squares
    * to make this an O(1) operation. 
    */
   public static void version2() {
      int result = squareOfSumsv1(TARGET) - sumOfSquaresv2(TARGET);
      System.out.println(result);
   }
   
   /**
    * Attempt 1. Uses a brute force version of the sum of squares calculation,
    * but an O(1) version of the square of sums calculation.
    */
   public static void version1() {
      int result = squareOfSumsv1(TARGET) - sumOfSquaresv1(TARGET);
      System.out.println(result);
   }
   
   /**
    * An O(1) efficiency sum of squares operation.
    *
    * @param n Calculates the sum of squares from 1 to n
    * @return int the sum of squares from 1 to n
    */
   private static int sumOfSquaresv2(int n) {
      return n * (2 * n + 1) * (n + 1) / 6;
   }
   
   /**
    * An O(n) efficiency sum of squares operation.
    *
    * @param n Calculates the sum of squares from 1 to n
    * @return int the sum of squares from 1 to n
    */
   private static int sumOfSquaresv1(int n) {
      int result = 0;
      for (int i = 1; i <= n; i++) {
         result += i * i;
      }
      return result;
   }
   
   /**
    * An O(1) efficiency square of sums operation.
    *
    * @param n Calculates the square of sums from 1 to n
    * @return int the square of sums from 1 to n
    */
   private static int squareOfSumsv1(int n) {
      int result = n * (n + 1) / 2;
      return result * result;
   }
}