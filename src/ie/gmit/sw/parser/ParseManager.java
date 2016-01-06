package ie.gmit.sw.parser;

import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.wordcloud.Word;

public class ParseManager {
	private Parsable parsable; // dependant on abstraction (interface) that wont
								// change.
	private List<Word> listOfWordsToBeDrawn = new ArrayList<>();;
	private StopWordsParser wordsToIgnore; // Stop word parser
	private static final int MIN_WORD_LENGTH = 3;

	// constructor
	public ParseManager(Parsable parsable, String textFileToIgnore) throws Exception {
		this.parsable = parsable;
		wordsToIgnore = new StopWordsParser("stopwords.txt");
		parsable.parse(textFileToIgnore);
		wordsToBeDrawn();
	}

	private void wordsToBeDrawn() {
		List<Word> tempList = parsable.listOfParsedWords();
		System.out.println("List of parsed words : " + parsable.listOfParsedWords().size());
		for (int i = 0; i < tempList.size(); i++) {

			Word temp = parsable.listOfParsedWords().get(i);
			// stopwords checking //Word object overrides .equals method 
			if (!wordsToIgnore.listOfParsedWords().contains(temp) && temp.getWord().length() > MIN_WORD_LENGTH) {
				listOfWordsToBeDrawn.add(temp);
			}
		}
	}

	// returning list of words to be drawn
	public List<Word> getWordsToDraw() {
		return new ArrayList<>(listOfWordsToBeDrawn);
	}

}
