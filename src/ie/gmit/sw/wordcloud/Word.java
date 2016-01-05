package ie.gmit.sw.wordcloud;

public class Word implements Comparable<Word> {

	private String word;
	private int frequency;
	
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

	@Override
	public int compareTo(Word wordFrequency) {
		return wordFrequency.frequency - frequency;
	}

	@Override
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
