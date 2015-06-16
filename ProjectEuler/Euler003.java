import java.util.*;

public class Euler003 {
   public static final long TARGET = 600851475143L;

   public static void main(String[] args) {
      version3();
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
         if (i % 1000000 == 0) {
            System.out.println("not yet, at " + i);
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