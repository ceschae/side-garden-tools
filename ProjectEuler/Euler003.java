import java.util.*;

public class Euler003 {
   public static final long TARGET = 600851475143L;

   public static void main(String[] args) {
      version4();
   }
   
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
   
   public static void version3() {
      Set<Long> primes = new HashSet<Long>();
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
   
   private static boolean multiplePrimes(long i, Set<Long> primes) {
      for (Long l : primes) {
         if (i % l == 0) {
            return true;
         }
      }
      return false;
   }
      
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
   
   private static boolean isPrime(long n) {
      int i = 2;
      for (; i < n; i++) {
         if (n % i == 0) {
            return false;
         }
      }
      System.out.println(i);
      return true;
   }
}