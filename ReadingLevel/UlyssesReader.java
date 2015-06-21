/** 
 * Reads in James Joyce's Ulysses, gauges reading level to be 'highest' of
 * ReadingLevel scale. 
 *
 * @author Caitlin Schaefer
 * @version 1.0
 * @date 20 June 2015
 */ 

public class UlyssesReader {
	public static final int TARGET_DIFFICULTY = 20;
	
	public static void main(String[] args) {
		Scanner document = new Scanner(new File("Ulysses.txt"));
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		while (document.hasNext()) {
			String word = document.next();
			if (!wordCount.containsKey(word)) {
				wordCount.put(word, 0);
			}
			wordCount.put(word, wordCount.get(word) + 1);
		}
		
		
	}
}