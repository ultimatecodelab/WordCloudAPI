##Developer : Arjun Kharel (G00298984) - WordCloudAPI

**Clone:**

**Source Code.**

**G00298984 (Zip archive contains the following)**
- **wordcloud.jar** (wordcloudapi)
- **lib** Folder contains jsoup library. Please make sure **"wordcloud.jar"** and **lib** folder are in the same folder. 
- **src** (contains all the source code)
- **test** (contains junit test cases)
- **docs** (Java docs)
- **WordCloud UML**
- **stopwords.txt** (contains stopwords / words to ignore) **stopwords.txt** must be on the same directory as the **wordcloud.jar**
- **myfile.txt** (sample file provided for parsing - you could use your own file.)
- **build.xml** 





**How to Run ?**

1: Open command prompt and cd into G00298984 folder.

2: Please ensure  "stopwords.txt", "wordcloud.jar"and lib folder are on the same location, i.e( the same folder).

3: Run WordCloud api using the one of the following command (first one is recommended )
	
		java -cp "./wordcloud.jar;lib/*" ie.gmit.sw.Runner (Windows)
		
		java –cp ./wordcloud.jar ie.gmit.sw.Runner
		
		java -cp "./wordcloud.jar:lib/*" ie.gmit.sw.Runner (Linux)

4: Enter 1 for file parsing /  2 for URL Parsing.

5: One sample file has been provided (myfile.txt) but you could use your own file too.

6: If you would like to parse the URL please copy and paste the link from your browser. 
  URL parsing was tested using this URL http://www.bbc.com/news/world-middle-east-35214536

**Features** 

The project is fully functional and is comprises of the following features / Technologies

1: URL Parsing (Jsoup)

2: File Parsing

3: **Advanced word placements with collision detections feature**

3: Ability to save the wordclould image in png format.
