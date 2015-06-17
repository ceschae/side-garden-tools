/**
 * Project Euler: Problem 8
 * 'Largest Product in a Series'
 * Finds the largest product in LENGTH adjacent numbers in SEQUENCE. 
 * DOES NOT WORK--CAN'T FIGURE OUT WHY 
 *
 * @author  Caitlin Schaefer
 * @version 2.0
 * @since   17-June-2015
 */

public class Euler008 {
   public static final int LENGTH = 13;
   public static final String SEQUENCE = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
   public static final int SUBSEQUENCE_LENGTH = 50;

   public static void main(String[] args) {
      version2();
   }
   
   /**
    * Attempt 2. Thought maybe they meant in a subsequence (the original formatting was 20 lines of 50 numbers)
    * so made something that computed that product instead. 
    */
   public static void version2() {
      int max = 1;
      for (int i = 0; i < SEQUENCE.length(); i += SUBSEQUENCE_LENGTH) {
         String subsequence = SEQUENCE.substring(i, i + SUBSEQUENCE_LENGTH);
         for (int j = 0; j < subsequence.length() - LENGTH; j++) {
            int result = 1;
            for (int k = 0; k < LENGTH; k++) {
               result *= subsequence.charAt(k + j) - '0';
            }
            if (result > max) {
               System.out.println((i / 50) + ", " + j);
               max = result;
            }
         }
      }
      System.out.println(max);
   }
   
   /**
    * Attempt 1. Finds resulting product based on finding the next subsequence
    * without a 0 in it (since that definitely won't be the greatest product). 
    */ 
   public static void version1() {
      int max = 1;
      int i = 0;
      while (i < SEQUENCE.length() - LENGTH - 1) {
         int result = 1;
         int startIndex = findNextSequence(i);
         if (startIndex != -1) {
            String sub = SEQUENCE.substring(startIndex, startIndex + LENGTH);
            for (int j = 0; j < LENGTH; j++) {
               result *= sub.charAt(j) - '0';
            }
            if (result > max) {
               max = result;
            }
            i = startIndex + 1;
         } else {
            break;
         }
      }
      System.out.println(max);
   }
   
   /**
    * Finds the next index of a sequence without a 0 in it. 
    *
    * @param index The index to start checking at
    * @return int The starting index of the next sequence without a 0 in it
    */ 
   private static int findNextSequence(int index) {
      if (SEQUENCE.length() - index < LENGTH) {
         throw new IllegalArgumentException("Index is too large, no valid subsequence");
      }
      while (index < SEQUENCE.length() - LENGTH) {
         String sub = SEQUENCE.substring(index, index + LENGTH);
         int zeroIndex = sub.indexOf('0');
         if (zeroIndex != -1) {
            index += zeroIndex + 1;
         } else {
            break;
         }
      }
      if (SEQUENCE.length() - LENGTH < index) {
         return -1;
      } else {
         return index;
      }
   }
}