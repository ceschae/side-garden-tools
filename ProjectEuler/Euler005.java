/**
 * Project Euler: Problem 5
 * 'Smallest Multiple'
 * Finds the smallest number that is evenly divisible by all  
 * numbers from 1 to TARGET. 
 *
 * @author  Caitlin Schaefer
 * @version 2.0
 * @since   16-June-2015
 */

import java.util.*;

public class Euler005 {
   public static final int TARGET = 20;
   
   public static void main(String[] args) {
      version2();
   }
   
   /**
    * Second attempt (best solution). Given that the result can be
    * factored into a multiple of primes, this computes the result
    * based on the fact that some numbers (like 10) can be represented
    * by primes (2 and 5, say) that are already represented in the 
    * division check. Prints result to console. 
    */ 
   public static void version2() {
      int[] primes = generatePrimesUpTo(TARGET);
      int n = 1;
      int i = 0;
      boolean go = true;
      int limit = (int) Math.sqrt(TARGET);
      for (int p : primes) {
         int factor = 1;
         if (go) {
            if (p <= limit) {
               factor = (int) (Math.log10(TARGET) / Math.log10(p));
            } else {
               go = false;
            }
         }
         n *= (int) Math.pow(p, factor);
         i++;
      }
      System.out.println(n);
   }
   
   /**
    * Generates all primes from 2 to n. 
    *
    * @param n The number to which all primes are generated.
    * @return int[] The collection of all primes from 2 to n. 
    */
   private static int[] generatePrimesUpTo(int n) {
      List<Integer> list = new ArrayList<Integer>();
      for (int i = 2; i <= n; i++) {
         boolean isPrime = true;
         for (int j = 2; j < i; j++) {
            if (i % j == 0) {
               isPrime = false;
            }
         }
         if (isPrime) {
            list.add(i);
         }
      }
      int[] result = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
         result[i] = list.get(i);
      }
      return result;
   }
   
   /**
    * First attempt. Brute forces all numbers from TARGET up
    * until it finds a solution (first solution being smallest), 
    * testing if number is divisible by all numbers from 1 to
    * TARGET. Prints solution to console. 
    */
   public static void version1() {
      int i = TARGET;
      while (true) {
         boolean match = true;
         int j = 1;
         while (match && j <= TARGET) {
            if (i % j != 0) {
               match = false;
            } else if (j == TARGET) {
               System.out.println(i);
               break;
            } else {
               j++;
            }
         }
         i++;
      }
   }
}