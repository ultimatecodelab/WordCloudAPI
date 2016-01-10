package ie.gmit.sw.parser;

import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.wordcloud.Word;

public class ParseManager {
	/**
	 * This is the facade class. This class consist of multiple subsystems that
	 * are needed to develop the full application. This provides easy interface
	 * for the client. Complexity is hidden from the client and all they have to
	 * do is call the constructor of this ParseManager{@link ParseManager}.
	 * 
	 * @author Arjun Kharel
	 */

	private Parsable parsable; // depending on abstraction (interface).

	private List<Word> listOfWordsToBeDrawn = new ArrayList<>();;
	private StopWordsParser wordsToIgnore; // Stop word parser
	private static final int MIN_WORD_LENGTH = 3;
	boolean validTextFile = false;
	boolean validStopWordsFile = false;

	// constructor
	public ParseManager(Parsable parsable, String textFileToParse, String ignoreWords) throws Exception {
		this.parsable = parsable;
		wordsToIgnore = new StopWordsParser();
		
		validStopWordsFile = wordsToIgnore.parse(ignoreWords);
		validTextFile = parsable.parse(textFileToParse);
		
		if (validTextFile && validStopWordsFile) {
			wordsToBeDrawn();
		} 
	}
	/**
	 * 
	 * @return returns boolean to notify whether the parsing was successful.
	 */
	public boolean parsingStatus() {
		return (validTextFile && validStopWordsFile);
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
