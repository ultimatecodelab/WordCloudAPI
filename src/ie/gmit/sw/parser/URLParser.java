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

public class URLParser implements Parsable {

	private static List<Word> parsedWords = new ArrayList<>();
	private FrequencyAnalyzer wordsFreq;

	
	public URLParser(FrequencyAnalyzer frequencyAnalyzor) {
		this.wordsFreq = frequencyAnalyzor;
	}

	@Override
	public void parse(String parse) throws IOException {
		StringBuilder words = new StringBuilder();
		try {
			String url = parse;
			// System.out.println(url + "is");
			Document doc = Jsoup.connect(url).get();
			Elements paragraphs = doc.select("p");
			for (Element p : paragraphs)
				words.append(p.text().toString());
		} catch (IOException ex) {
			System.out.println("Error parsing the URL");

		}
		addToList(words);
	}

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

	@Override
	public List<Word> listOfParsedWords() {

		for (Map.Entry<String, Integer> entry : wordsFreq.getWordMap().entrySet()) {
			String word = entry.getKey();
			Integer value = entry.getValue();
			parsedWords.add(new Word(word, value));

		}
		return new ArrayList<Word>(parsedWords);
	}

}