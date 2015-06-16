import java.util.*;

public class Euler005 {
   public static final int TARGET = 20;
   
   public static void main(String[] args) {
      version2();
   }
   
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
   
   public static int[] generatePrimesUpTo(int n) {
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