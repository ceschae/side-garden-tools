/**
 * Approximates the reading level of a provided text.
 *
 * @author Caitlin Schaefer
 * @version 1.0
 * @date 20 June 2015
 */
 
public class ReadingLevel {
	private final String text;
	private final double textLevel;
	private final Map<String, Double> wordLevel;
	
	public ReadingLevel(Scanner input) {
		this.wordLevel = new HashMap<String, Integer>();
		// read in dictionary
		Scanner dict = new Scanner(new File("dict.txt"));
		while (dict.hasNextLine()) {
			Scanner pair = new Scanner(dict.nextLine());
			String word = pair.next();
			int frequency = pair.nextInt();
			this.wordLevel.put(word, frequency);
		}
		
		// read input text
		calculateReadingLevel(input);
	}
	
	public ReadingLevel(Scanner input, Map<String, Integer> wordLevel) {
		// read in dictionary
		this.wordLevel = wordLevel;
		
		// read input text
		calculateReadingLevel(input);
	}
	
	private void calculateReadingLevel(Scanner input) {
		int wordCount = 0;
		while (input.hasNext()) {
			String word = input.next().toLowerCase();
			wordCount++;
			this.text += word + " ";
			// TODO: perform calculation on word to determine 'reading level'
			// longer words should be considered 'harder' (increased length, increased difficulty)
			// less frequent words should be considered 'harder' (increased rank (less frequent), increased difficulty)
		}
		// TODO: figure out how overall text length figures into 'reading level'
		// more text, increased difficulty 
		this.textLevel = 0.0;
	}
	
	/** 
	 * Returns the approximate reading level of this ReadingLevel object.
	 * 
	 * @return double The approximate reading level of this ReadingLevel,
	 * rounded to the nearest tenth.
	 */
	public double getReadingLevel() {
		return Math.round(10.0 * this.textLevel) / 10.0;
	}
}