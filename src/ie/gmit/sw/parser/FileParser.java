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

	private static List<Word> parsedWords = new ArrayList<>();
	// private static Map<String,Integer > wordsAndFreq = new
	// HashMap<String,Integer>();
	private static StringBuilder words = new StringBuilder();

	private FrequencyAnalyzer wordsFreq;

	public FileParser(FrequencyAnalyzer freqAnalyzer) {
		this.wordsFreq = freqAnalyzer;
	}

	// this method is invoked when we are parsing the text file...
	int duplicateCounter = 0;

	@Override
	public void parse(String fileName) throws Exception {

		parsedWords.clear();
		try {
			RandomAccessFile aFile = new RandomAccessFile(fileName, "r");
			FileChannel inChannel = aFile.getChannel();
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
			buffer.load();

			while (buffer.hasRemaining()) {
				char charRead = (char) buffer.get();
				if ((charRead >= 'A' && charRead <= 'z')) {
					words.append(charRead);
				}
				// if I encounter space or newline character then I know for sure
				// for im either at
				// the new line or end of word.
				else if (charRead == ' ' || charRead == '\n') {

					// parsedWords.add(words.toString().trim());
					/*
					 * if(wordsAndFreq.containsKey(words.toString())){
					 * duplicateCounter++; int val =
					 * wordsAndFreq.get(words.toString())+1;
					 * wordsAndFreq.put(words.toString().trim(), val); }else{
					 * wordsAndFreq.put(words.toString(), 1); }
					 */
					wordsFreq.put(words.toString().trim());
					words.setLength(0);
				}
			}
			buffer.clear();
			inChannel.close();
			aFile.close();
			System.out.println("\nFinished Parsing...");
		} catch (Exception e) {
			System.out.println("File Name not matched.. plz enter your file with txt extension");
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
