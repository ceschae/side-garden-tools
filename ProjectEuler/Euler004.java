public class Euler004 {
   public static void main(String[] args) {
      version2();
   }
   
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
   
   public static void version1() {
      int max = 0;
      for (int i = 999; i >= 100; i--) {
         for (int j = 999; j >= 100; j--) {
            int result = i * j;
            if (isPalindrome("" + result)) {
               if (result > max) {
                  max = result;
                  System.out.println("i = " + i);
                  System.out.println("j = " + j);
               }
            }
         }
      }
      System.out.println(max);
   }
   
   public static boolean isPalindrome(String str) {
      for (int i = 0; i < str.length() / 2; i++) {
         if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
            return false;
         }
      }
      return true;
   }
}