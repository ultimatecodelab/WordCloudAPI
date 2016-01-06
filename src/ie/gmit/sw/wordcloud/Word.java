package ie.gmit.sw.wordcloud;
/*Contains word(String ) and int frequency
 * Implements Comparable to compare the frequency of the word with another word
 * Overrides .equals() method to check the word againt the stopwords
 */

public class Word implements Comparable<Word> {

	private String word; //String word
	private int frequency; //frequency
	
	public Word(String word, int frequency) {
		setWord(word);
		setFrequency(frequency);
	}

	public Word(String word) {
		setWord(word);
	}

	public String getWord() {
		return word;
	}

	private void setWord(String word) {
		this.word = word;
	}

	private void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getFrequency() {
		return frequency;
	}
	//comparing the frequency
	public int compareTo(Word wordFrequency) {
		return wordFrequency.frequency - frequency;
	}

	//overriding .equals method to check of the word equals the stopwords word
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Word other = (Word) obj;
		if ((this.word == null) ? (other.getWord() != null) : !this.getWord().equalsIgnoreCase(other.getWord())) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + (this.word != null ? this.word.hashCode() : 0);
		return hash;
	}

}
