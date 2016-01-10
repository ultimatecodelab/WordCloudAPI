package ie.gmit.sw;

import java.util.Scanner;

import ie.gmit.sw.collisionDetection.RectCollisionChecker;
import ie.gmit.sw.parser.ParseManager;
import ie.gmit.sw.parser.ParseType;
import ie.gmit.sw.parser.ParserFactory;
import ie.gmit.sw.randomStrategy.Coordinate;
import ie.gmit.sw.randomStrategy.WordCloudStrategy;
import ie.gmit.sw.wordcloud.WordCloud;

/**
 * This class displays the menu.
 * 
 * @author Arjun Kharel
 *
 */
public class Menu {
	private Scanner sc = new Scanner(System.in);

	private ParseManager manager;

	public void displayMenu() throws Exception {
		System.out.print("Select option: 1 (File Parsing) , 2 (UrlParsing): ");
		int option = 0;
		try {
			option = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid option selected, please choose 1 or 2.");
		}

		switch (option) {

		case 1:
			System.out.print("\nEnter Your File Name to Parse with  .txt extension. "
					+ "\nYou can enter myfile.txt or your own text file: ");
			String fileName = sc.next();
			System.out.print("\nEnter Stop words file name, stopwords.txt or your own: ");
			String wordToIgnore = sc.next();

			manager = new ParseManager(ParserFactory.getParser(ParseType.FileParser), fileName, wordToIgnore);
			if (manager.parsingStatus()) {
				System.out.println("Please Wait...");
				beginProcess();
			}
			break;
		case 2:
			System.out.print("Enter url: ");
			String url = sc.next();
			System.out.print("\nEnter Stop words file name, stopwords.txt or your own: ");
			String wordToIgnore2 = sc.next();
			manager = new ParseManager(ParserFactory.getParser(ParseType.URLParse), url, wordToIgnore2);

			if (manager.parsingStatus()) {
				System.out.println("Please Wait...");
				beginProcess();
			}
			break;
		default:
			System.out.println("Invalid option selected, please choose 1 or 2.");
		}

	}

	private void beginProcess() throws Exception {
		new WordCloud(manager.getWordsToDraw(), 
						new RectCollisionChecker(), 
						new WordCloudStrategy(), 
						new Coordinate());
	}

}
