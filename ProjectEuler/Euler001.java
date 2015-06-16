/**
 * Project Euler: Problem 1
 * 'Multiples of 3 and 5'
 * Finds the sum of all multiples of 3 or 5 below MAX.
 *
 * @author  Caitlin Schaefer
 * @version 2.0
 * @since   16-June-2015
 */

public class Euler001 {
   public static final int MAX = 1000;
   
   public static void main(String[] args) {
      version1();
      version2();
   }
   
   /**
    * First attempt. Brute force method of adding number
    * to sum if it is a mutliple of 3 or 5, checking up 
    * to MAX. Prints solution to console.
    */
   public static void version1() {
      int sum = 0;
      for (int i = 0; i < MAX; i++) {
         if (i % 3 == 0 || i % 5 == 0) {
            sum += i;
         }
      }
      System.out.println(sum);
   }
   
   /**
    * Second attempt (best solution). Finds sums of numbers
    * divisible by 3 and 5, and subtracts sum of numbers
    * divisible by 15 (to eliminate repeats). Prints solution
    * to console.
    */
   public static void version2() {
      int sum = sumDivisibleBy(3) + sumDivisibleBy(5) - sumDivisibleBy(15);
      System.out.println(sum);
   }
   
   /**
    * Calculates sum of numbers up to MAX that are divisible by n.
    * 
    * @param n This is the number of which multiples should be added
    * to the suum.
    * @return int This is the sum of numbers up to MAX that are 
    * divisible by n.
    */
   private static int sumDivisibleBy(int n) {
      int p = MAX / n;
      return n * p * (p + 1) / 2;
   }
}
