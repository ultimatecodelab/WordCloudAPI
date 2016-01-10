package ie.gmit.sw.parser;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.wordcloud.Word;

/**
 * This class is responsible for filtering out the stopwords.
 * 
 * @author Arjun Kharel
 */
public class StopWordsParser implements Parsable {
	private List<Word> wordsToIgnore = new ArrayList<>();

	private StringBuilder words = new StringBuilder();

	// default constructor
	public StopWordsParser() {

	}

	public StopWordsParser(String fileName) throws Exception {
		parse(fileName);
	}

	/**
	 * This method is responsible for parsing the file.
	 * 
	 * @param fileName
	 *            File Name to parse.
	 * @return Returns boolean if the parsing was successful.
	 */
	public boolean parse(String fileName) throws Exception {
		wordsToIgnore.clear();

		try {
			RandomAccessFile aFile = new RandomAccessFile(fileName, "r");
			FileChannel inChannel = aFile.getChannel();
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
			buffer.load();

			while (buffer.hasRemaining()) {
				char charRead = (char) buffer.get();
				if ((charRead >= 'A' && charRead <= 'z')) {
					words.append(charRead);
				} else if (charRead == ' ' || charRead == '\n') {

					wordsToIgnore.add(new Word(words.toString().trim()));
					words.setLength(0);
				}
			}
			buffer.clear();
			inChannel.close();
			aFile.close();

		} catch (Exception e) {
			System.out.println("could not found stopwords file with filename: " + fileName);
			return false;
		}
		return true;
	}

	@Override
	public List<Word> listOfParsedWords() {
		return new ArrayList<Word>(wordsToIgnore);
	}
}
