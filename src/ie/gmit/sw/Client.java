package ie.gmit.sw;

import java.util.Scanner;

import ie.gmit.sw.parser.ParseManager;
import ie.gmit.sw.parser.ParseType;
import ie.gmit.sw.parser.ParserFactory;
import ie.gmit.sw.wordcloud.WordCloud;

public class Client {
	private Scanner sc = new Scanner(System.in);

	private ParseManager manager;

	public void run() throws Exception {
		System.out.println("Select option: 1 (File Parsing) , 2 (UrlParsing)");
		int option = sc.nextInt();

		switch (option) {

		case 1:
			System.out.print("Enter Your File Name to Parse with  .txt extension. "
					+ " myfile.txt has been included with the project for testing: ");
			String fileName = sc.next();
			manager = new ParseManager(ParserFactory.getParser(ParseType.FileParser), fileName);
			new WordCloud(manager.getWordsToDraw());
			break;
		case 2:
			System.out.print("Enter url: ");
			String url = sc.next();

			manager = new ParseManager(ParserFactory.getParser(ParseType.URLParse), url);
			new WordCloud(manager.getWordsToDraw());
			break;
		}

	}

}
