package ie.gmit.sw.parser;

import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.wordcloud.Word;

public class ParseManager {
	private Parsable parsable;
	private List<Word> listOfWordsToBeDrawn = new ArrayList<>();;
	private StopWordsParser wordsToIgnore2;
	private static final int MIN_WORD_LENGTH = 3;

	public ParseManager(Parsable parsable, String textFileToIgnore) throws Exception {
		this.parsable = parsable;
		wordsToIgnore2 = new StopWordsParser("stopwords.txt");
		parsable.parse(textFileToIgnore);
		wordsToBeDrawn();
	}

	private void wordsToBeDrawn() {

		List<Word> tempList = parsable.listOfParsedWords();
		System.out.println("List of parsed words : " + parsable.listOfParsedWords().size());
		for (int i = 0; i < tempList.size(); i++) {

			Word temp = parsable.listOfParsedWords().get(i);
			if (!wordsToIgnore2.listOfParsedWords().contains(temp) && temp.getWord().length() > MIN_WORD_LENGTH) {
				listOfWordsToBeDrawn.add(temp);
			}
		}
	}

	public List<Word> getWordsToDraw() {
		return new ArrayList<>(listOfWordsToBeDrawn);
	}

}
