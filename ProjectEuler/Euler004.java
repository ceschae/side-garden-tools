/**
 * Project Euler: Problem 4
 * 'Largest Palindrome Product'
 * Finds the largest palindromic number that can be made from 
 * two 3-digit numbers.
 *
 * @author  Caitlin Schaefer
 * @version 2.0
 * @since   16-June-2015
 */

public class Euler004 {
   public static void main(String[] args) {
      version2();
   }
   
   /**
    * Second attempt (best solution). Stems from criteria that 
    * one of the numbers must be a multiple of 11 for the result to be
    * a palindrome, so we can skip many pairings. We can also stop early
    * if we find a palindrome for the first number 'a' and all subsequent
    * numbers 'b' for a pairing, given decreasing 'a' and 'b'. Prints
    * solution to console. 
    */
   public static void version2() {
      int largestPalindrome = 0;
      int a = 999;
      int b = 999;
      int db = 1;
      while (a >= 100) {
         if (a % 11 != 0) {
            b = 990;
            db = 11;
         }
         boolean go = true;
         while (go) {
            int result = a * b;
            if (result <= largestPalindrome) {
               go = false;
            } else {
               if (isPalindrome("" + result)) {
                  largestPalindrome = result;
               }
               b -= db;
            }
         }
         a--;
      }
      System.out.println(largestPalindrome);
   }
   
   /**
    * First attempt. This attempt brute forces all the mutliplications
    * of every pair of 3-digit numbers, and keeps track of a max
    * palindrome. Prints result to console. 
    */
   public static void version1() {
      int max = 0;
      for (int i = 999; i >= 100; i--) {
         for (int j = 999; j >= 100; j--) {
            int result = i * j;
            if (isPalindrome("" + result)) {
               if (result > max) {
                  max = result;
               }
            }
         }
      }
      System.out.println(max);
   }
   
   /**
    * Returns whether or not str is a Palindrome (same
    * forwards as it is backwards).
    *
    * @param str The String to be checked if it is a palindrome.
    * @return boolean True if str is a palindrome, false otherwise.
    */
   private static boolean isPalindrome(String str) {
      for (int i = 0; i < str.length() / 2; i++) {
         if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
            return false;
         }
      }
      return true;
   }
}