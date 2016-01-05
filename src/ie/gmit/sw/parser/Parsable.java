package ie.gmit.sw.parser;

import java.util.List;

import ie.gmit.sw.wordcloud.Word;

public interface Parsable {
	public abstract void parse(String parse) throws Exception;
	public abstract List<Word> listOfParsedWords();

}
