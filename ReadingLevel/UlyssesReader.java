/** 
 * Reads in any text file FILE, gauges reading level to be TARGET_DIFFICULTY of
 * ReadingLevel scale (0 - 20). 
 *
 * @author Caitlin Schaefer
 * @version 1.0
 * @date 20 June 2015
 */ 

public class UlyssesReader {
	public static final int TARGET_DIFFICULTY = 20;
	public static final String FILE = "Ulysses.txt";
	
	public static void main(String[] args) {
		Scanner document = new Scanner(new File(FILE));
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		int totalWordCount = 0;
		while (document.hasNext()) {
			String word = document.next();
			if (!wordCount.containsKey(word)) {
				wordCount.put(word, 0);
			}
			wordCount.put(word, wordCount.get(word) + 1);
			totalWordCount++;
		}
		System.out.println("Total word count: " + totalWordCount);
		
		// 20 = sum(word difficulties) * length of text * constant
		// word difficulty = frequency * length
		double wordDifficultiesSum = 0.0;
		for (String word : wordCount.keySet()) {
			wordDifficultiesSum += wordCount.get(word) * word.length();
		}
		System.out.println("Sum of all word difficulties: " + wordDifficultiesSum);
		
		double constant = TARGET_DIFFICULTY / wordDifficultiesSum / totalWordCount;
		System.out.println("Projected constant: " + constant);
	}
}