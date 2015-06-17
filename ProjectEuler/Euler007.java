/**
 * Project Euler: Problem 7
 * '10001st Prime'
 * Finds the TARGET prime number.  
 *
 * @author  Caitlin Schaefer
 * @version 1.0
 * @since   16-June-2015
 */
import java.util.*;
 
public class Euler007 {
   public static final int TARGET = 10001;
   
   public static void main(String[] args) {
      version2();
   }
   
   /**
    * Attempt 2. Slightly more strategic version to find TARGETth prime, 
    * uses an improved isPrime method. Prints TARGETth prime to console.
    */
   public static void version2() {
      int count = 1;
      int candidate = 1;
      while (count != TARGET) {
         candidate += 2;
         if (isPrimev2(candidate)) {
            count++;
         }
      }
      System.out.println(candidate);
   }  
   
   /**
    * Determines if n is prime using some known prime qualities.
    *
    * @param n the number to determine if prime or not
    * @return boolean True if n is prime, false otherwise
    */
   private static boolean isPrimev2(int n) {
      if (n == 1) { // 1 is not prime
         return false;
      } else if (n < 4) { // 2 and 3 are prime
         return true;
      } else if (n % 2 == 0) { // no evens prime
         return false;
      } else if (n < 9) { // 5 and 7 prime (4, 6, 8 ruled out)
         return true;
      } else if (n % 3 == 0) { // no multiples of 3 prime
         return false;
      } else {
         int r = (int) Math.sqrt(n);
         int f = 5;
         // either prime is in the form 6k +/- 1
         // or greater than sqrt(n) 
         while (f <= r) {
            if (n % f == 0 || n % (f + 2) == 0) {
               return false;
            }
            f += 6;
         } 
         return true; 
      }
   }
   
   /**
    * Attempt 1. Semi-brute force method of finding primes, guesses 
    * all odds against existing primes until the TARGET prime is found.
    * Prints TARGET prime to console. 
    */
   public static void version1() {
      List<Integer> primes = new ArrayList<Integer>();
      primes.add(2);
      int lastPrime = 1; // to prime the loop correctly
      while (primes.size() < TARGET) {
         boolean notFound = true;
         int guess = lastPrime + 2;
         while (!isPrimev1(guess, primes)) {
            guess += 2;
         }
         lastPrime = guess;
         primes.add(lastPrime);
      }
      System.out.println(primes.get(primes.size() - 1));
   }
   
   /**
    * Checks to see if n is prime by comparing against list of
    * primes less than n. 
    * 
    * @param n Number to be checked if prime
    * @param primes List of primes less than n
    * @return boolean True if n is prime, false otherwise
    */ 
   public static boolean isPrimev1(int n, List<Integer> primes) {
      for (int i : primes) {
         if (n % i == 0) {
            return false;
         }
      }
      return true;
   }
}