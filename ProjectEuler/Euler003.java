/**
 * Project Euler: Problem 2
 * 'Largest Prime Factor'
 * Finds the largest prime factor of TARGET.
 *
 * @author  Caitlin Schaefer
 * @version 4.0
 * @since   16-June-2015
 */

import java.util.*;

public class Euler003 {
   public static final long TARGET = 600851475143L;

   public static void main(String[] args) {
      version4();
   }
   
   /**
    * Attempt 4 (best solution). This solution is actually mathematically
    * efficient. Reduces TARGET by increasing prime factors, narrows down to
    * one largest prime (either a factor already found, or n if greater than
    * sqrt(n), since only one prime factor can exist above sqrt(n). Prints
    * result to console. 
    */
   public static void version4() {
      int lastFactor = 1;
      long n = TARGET;
      if (n % 2 == 0) {
         lastFactor = 2;
         while (n % 2 == 0) {
            n /= 2;
         }
      } 
      int factor = 3;
      int maxFactor = (int) Math.sqrt(n);
      while (n > 1 && factor <= maxFactor) {
         if (n % factor == 0) {
            lastFactor = factor;
            while (n % factor == 0) {
               n /= factor;
            }
            maxFactor = (int) Math.sqrt(n);
         }
         factor = factor + 2;
      }
      if (n == 1) {
         System.out.println(lastFactor);
      } else {
         System.out.println(n);
      }
   }
   
   /** 
    * Attempt 3. Different formatting of version1, except counts up from 2
    * rather than down from TARGET / 2. Prints all prime factors of TARGET
    * to console. 
    */
   public static void version3() {
      for (long i = 2; i < TARGET / 2; i++) {
         if (TARGET % i == 0) {
            long other = TARGET / i;
            if (isPrime(other)) {
               System.out.println(other);
               break;
            }
         }  
      }
   }
   
   /**
    * Second attempt. Tried to make a linked list of all numbers to consider,
    * by eliminating numbers from list as we go, however, ran into memory
    * overflow errors. Failed attempt.
    */    
   public static void version2() {
      NumNode front = null;
      for (long i = TARGET / 2; i >= 2; i--) {
         front = new NumNode(i, front);
      }
      long max = 1L;
      NumNode curr = front;
      while (curr != null) {
         if (TARGET % curr.data == 0 && isPrime(curr.data)) {
            System.out.println(curr.data);
            max = curr.data;
         } else {
            long num = curr.data;
            NumNode temp = curr;
            while (temp != null) {
               if (temp.next.data % num == 0) {
                  temp.next = temp.next.next;
               } else {
                  temp = temp.next;
               }
            }
         }
         curr = curr.next;
      }
   }
   
   /**
    * First attempt. Brute force searches down from TARGET / 2 (since 2 is
    * smallest potential prime factor, largest potential prime factor
    * (aside from TARGET) will be TARGET / 2) until it finds the first
    * prime factor (which will be largest by virtue of searching top-to-
    * bottom), prints result to console. 
    */
   public static void version1() {
      long i = TARGET / 2;
      while (true) {
         if (TARGET % i == 0 && isPrime(i)) {
            System.out.println("Real answer: " + i);
            break;
         }
         i--;
      }
   }
   
   /**
    * Determines if the passed long n is prime or not.
    *
    * @param n the long do determine if prime or not
    * @return boolean True if n is prime, false otherwise
    */
   private static boolean isPrime(long n) {
      int i = 2;
      for (; i < n; i++) {
         if (n % i == 0) {
            return false;
         }
      }
      return true;
   }
}