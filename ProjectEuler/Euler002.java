public class Euler002 {
   public static final int MAX = 4000000;
   public static final int N_1 = 1;
   public static final int N_2 = 2;
   
   public static void main(String[] args) {
      version1();
      version2();
   }
   
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