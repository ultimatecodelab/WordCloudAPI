##Developer : Arjun Kharel (G00298984) - WordCloudAPI
﻿
﻿![Alt text](https://github.com/ultimatecodelab/WordCloudAPI/blob/master/WordCloud.png "Optional title")

**Clone: https://github.com/ultimatecodelab/WordCloudAPI.git**

**Source Code. https://github.com/ultimatecodelab/WordCloudAPI**

**G00298984 (Zip archive contains the following)**
- **wordcloud.jar** (wordcloudapi)
- **lib** Folder contains jsoup library. Please make sure **"wordcloud.jar"** and **lib** folder are in the same folder. 
- **src** (contains all the source code)
- **test** (contails all the Junit test cases)
- **docs** (Java docs)
- **WordCloud UML**
- **stopwords.txt** (contains stopwords / words to ignore) **stopwords.txt** must be on the same directory as the **wordcloud.jar**
- **myfile.txt** (sample file provided for parsing - you could use your own file.)
- **build.xml** 





**How to Run ?**

1: Open command prompt and cd into G00298984 folder.

2: Please ensure  **"stopwords.txt"**, **"wordcloud.jar"** and **lib** folder are on the same location, i.e( the same folder).

3: Run WordCloud api using the one of the following command (first one is recommended )
	
		java -cp "./wordcloud.jar;lib/*" ie.gmit.sw.Runner (Windows) //this way it compiles jsoup in lib folder  too.
		
		java -cp "./wordcloud.jar:lib/*" ie.gmit.sw.Runner (Linux)

4: Enter 1 for file parsing /  2 for URL Parsing.

5: One sample file has been provided (myfile.txt) but you could use your own file too.

6: If you would like to parse the URL please copy and paste the link from your browser. 
  URL parsing was tested using this URL http://www.bbc.com/news/world-middle-east-35214536

**Features** 

The project is fully functional and is comprises of the following features / Technologies

1: URL Parsing (JSoup)

2: File Parsing (NIO)

3: **Advanced word placements with collision detections feature**

3: Ability to save the wordclould image in png format.


**Project Description - Packages/classes**

1: **ie.gmit.sw**

	- Client.java (Options selections, i.e File Parsing / URL Parsing
	- Runner.java - Runner class
	
2: **ie.gmit.sw.collisionDetection** 

	- CollisionDetector (interface)
	- RectCollisionChecker (implementation of collision detections algorithms)

3: **ie.gmit.sw.frequencyAnalyzor**

	- FrequencyAnalyzer (interface)
	- ComputeFrequency (implementation) compute the frequency of the words

4: **ie.gmit.sw.paint**

	- Graphicator (interface) contains ONLY the necessary Graphics methods needed for the application.
	- WordCloudGraphics(implementation) 

5: **ie.gmit.sw.parser**

	- Parsable.java (interface)
	- FileParser.java (implementation of Parsable) - Parses the file
	- URLParser.java(implementation of Parsable) - parses the URL
	- StopWordsParser.java (implementation of Parsable) - Words to Ignore
	- ParseType.java: Enum for parse Type i.e FileParsing / URL Parsing
	- ParseFactory.java Chooses the parse type in runtime. Returns Parsable object(fileParser or URLParser)
	- ParseManager.java (manages the parsing)

6: **ie.gmit.sw.randomStrategy**

	- CoordinateGenerator(interface) 
	- Coordinate.java - implement the CoordinateGenerator (Returns xAxisVal and yAxisVal)
	- WordCloudRandomiser.java (interface) - Random selection of Fonts and Color
	- WordCloudStrategy implements the WordCloudRandomiser interface. Font Size logic, Colors, managed by this class.

7: **ie.gmit.sw.wordCloud**

	- Word.java (Class for storing words and Frequency) **Overides .equals()/hashCode() and Implements Comparable interface for 	comparing the frequency. Override .equals() for the equality check of generic objects...
	- WordCloud.java (Creates the wordCloud)
	- 
8: **test** contains all the junit test cases. New folder **test** was created in eclipse for writing junit test cases...

	- AllTestsSuit.java
	- CollisionDetectionTest.java
	- CoordinateTest.java
	- CreateWordCloud.Test.java
	- FileParserTest.java
	- FrequencyanalyzorTest.java
	- URLParserTest.java
	- WordCloudGraphics.Test
	- WordCloudStrategy.java
	- WordTest.java

**UML Diagram: Off course you can zoom in :) **
![Alt text](https://github.com/ultimatecodelab/WordCloudAPI/blob/master/wordcloudapiuml.png "Optional title")

