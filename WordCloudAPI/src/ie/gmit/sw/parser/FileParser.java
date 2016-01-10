package ie.gmit.sw.parser;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ie.gmit.sw.frequencyAnalyzor.FrequencyAnalyzer;
import ie.gmit.sw.wordcloud.Word;

public class FileParser implements Parsable {
	// list of Words
	private static List<Word> parsedWords = new ArrayList<>();

	private static StringBuilder wordsSb = new StringBuilder();

	private FrequencyAnalyzer wordsFreq; // dependency on interface
											// (abstraction)

	public FileParser(FrequencyAnalyzer freqAnalyzer) {
		this.wordsFreq = freqAnalyzer;
	}

	// this method is invoked when we are parsing the text file...
	int duplicateCounter = 0;

	@Override
	public boolean parse(String fileName) throws Exception {

		parsedWords.clear();
		try {
			RandomAccessFile aFile = new RandomAccessFile(fileName, "r");
			FileChannel inChannel = aFile.getChannel();
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
			buffer.load();

			while (buffer.hasRemaining()) {
				char charRead = (char) buffer.get();
				if ((charRead >= 'A' && charRead <= 'z')) {
					wordsSb.append(charRead);
				}
				// if I encounter space or newline character then I know for

				else if (charRead == ' ' || charRead == '\n') {
					wordsFreq.put(wordsSb.toString().trim());
					wordsSb.setLength(0);
				}
			}
			buffer.clear();
			inChannel.close();
			aFile.close();
			System.out.println("\nFinished Parsing...");
		} catch (Exception e) {
			System.out.println("File Name not matched.. plz enter your file with txt extension");
			return false;
		}
		return true;
	}

	// now we are putting the words and their frequencies values
	public List<Word> listOfParsedWords() {
		for (Map.Entry<String, Integer> entry : wordsFreq.getWordMap().entrySet()) {
			String word = entry.getKey();
			Integer value = entry.getValue();
			parsedWords.add(new Word(word, value));

		}
		return new ArrayList<Word>(parsedWords);
	}

}
