public class Euler001 {
   public static final int MAX = 1000;
   
   public static void main(String[] args) {
      version1();
      version2();
   }
   
   public static void version1() {
      int sum = 0;
      for (int i = 0; i < MAX; i++) {
         if (i % 3 == 0 || i % 5 == 0) {
            sum += i;
         }
      }
      System.out.println(sum);
   }
   
   public static void version2() {
      int sum = sumDivisibleBy(3) + sumDivisibleBy(5) - sumDivisibleBy(15);
      System.out.println(sum);
   }
   
   private static int sumDivisibleBy(int n) {
      int p = MAX / n;
      return n * p * (p + 1) / 2;
   }
}
