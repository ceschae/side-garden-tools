/**
 * Project Euler: Problem 2
 * 'Even Fibonacci Numbers'
 * Finds the sum of evan Fibonacci numbers up to MAX. 
 *
 * @author  Caitlin Schaefer
 * @version 2.0
 * @since   16-June-2015
 */

public class Euler002 {
   public static final int MAX = 4000000;
   public static final int N_1 = 1; // starting term n_1
   public static final int N_2 = 2; // starting term n_2
   
   public static void main(String[] args) {
      version1();
      version2();
   }
   
   /**
    * First attempt. Brute force calculates every Fibonacci
    * number, and adds to the sum if it is even. Prints solution
    * to console.
    */
   public static void version1() {
      int sum = 0;
      int n1 = N_1;
      int n2 = N_2;
      
      sum += n2;

      int n3 = n1 + n2;
      while (n3 < MAX) {
         n3 = n1 + n2;
         if (n3 % 2 == 0) 
            sum += n3;
         
         n1 = n2;
         n2 = n3;
      }
      System.out.println(sum);
   }
   
   /** 
    * Second attempt (best solution). Calculates each successive even
    * Fibonacci number with knowledge that F(n) = 4*F(n-1) + F(n-2),
    * summing these up. Prints solution to console.
    */
   public static void version2() {
      int n1 = 0;
      int n2 = N_2;
      int sum = n2;
      
      int n3 = 0;
      while (n3 < MAX) {
         n3 = n2 * 4 + n1;
         sum += n3;
         n1 = n2;
         n2 = n3;
      }
      sum -= n3;
      System.out.println(sum);
   }
}