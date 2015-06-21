/**
 * Project Euler: Problem 9
 * 'Special Pythagorean Triplet'
 * Solves a*b*c for a + b + c = TARGET and a^2 + b^2 = c^2 
 *
 * @author  Caitlin Schaefer
 * @version 1.0
 * @since   17-June-2015
 */

public class Euler009 {
   public static final int TARGET = 1000;
   
   public static void main(String[] args) {
      version1();
   }
   
   /**
    * Attempt 1. Brute force attempt at solving for a, b, c. 
    * Prints result(s) to console. 
    */
   public static void version1() {
      for (int a = 0; a < TARGET; a++) {
         for (int b = a; b < TARGET - a; b++) {
            if (a*a + b*b == Math.pow(TARGET - a - b, 2) && (a < b) && (b < (TARGET - a - b))) {
               System.out.println(a * b * (TARGET - a - b));
            }
         }
      }
   }
}