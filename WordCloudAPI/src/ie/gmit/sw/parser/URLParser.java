package ie.gmit.sw.parser;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.gmit.sw.frequencyAnalyzor.FrequencyAnalyzer;
import ie.gmit.sw.wordcloud.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * URLParser implements {@link Parsable} interface. This class is responsible
 * for parsing the words from the web using Jsoup.
 * 
 * @author Arjun Kharel
 *
 */
public class URLParser implements Parsable {

	private static List<Word> parsedWords = new ArrayList<>();
	private FrequencyAnalyzer wordsFreq;

	public URLParser(FrequencyAnalyzer frequencyAnalyzor) {
		this.wordsFreq = frequencyAnalyzor;
	}

	/**
	 * @param parse
	 *            URL to parse
	 * @return returns boolean if the parsing was successful.
	 */
	public boolean parse(String parse) throws IOException {
		StringBuilder words = new StringBuilder();
		String url = parse;
		// System.out.println(url + "is");
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception e) {
			System.out.println("Error occured parsint the URL");
			System.out.println(e.getMessage());
			return false;
		}
		Elements paragraphs = doc.select("p");
		for (Element p : paragraphs) // retrieving the context in paragraph
			words.append(p.text().toString());
		// adding to the list
		addToList(words);
		return true;
	}

	// Parsig url and adding to the list
	private void addToList(StringBuilder words) {
		parsedWords.clear();
		StringBuilder wordsList = new StringBuilder();
		String temp = words.toString();
		for (int i = 0; i < temp.length(); i++) {
			char charRead = temp.charAt(i);
			if ((charRead >= 'A' && charRead <= 'z' && charRead != '.')) {
				wordsList.append(charRead);
			} else if (charRead == ' ' || charRead == '\n') {
				String word = wordsList.toString().trim();
				wordsFreq.put(word);
				wordsList.setLength(0);
			}
		}
	}

	/**
	 * @return returns List<Word> of parsed Words
	 */
	public List<Word> listOfParsedWords() {

		for (Map.Entry<String, Integer> entry : wordsFreq.getWordMap().entrySet()) {
			String word = entry.getKey();
			Integer value = entry.getValue();
			parsedWords.add(new Word(word, value));
		}
		return new ArrayList<Word>(parsedWords);
	}

}
