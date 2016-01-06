package ie.gmit.sw.parser;

import java.util.List;

import ie.gmit.sw.wordcloud.Word;

public interface Parsable {
	// this interface is implemented by FileParser, URLParser , StopWordsParser
	public abstract void parse(String parse) throws Exception;

	public abstract List<Word> listOfParsedWords();

}
