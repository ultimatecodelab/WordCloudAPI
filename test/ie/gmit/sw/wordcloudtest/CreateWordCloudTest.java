package ie.gmit.sw.wordcloudtest;

import org.junit.Test;

import ie.gmit.sw.wordcloud.WordCloud;

public class CreateWordCloudTest {
	WordCloud wordCloud;
	
	@Test(expected = NullPointerException.class)
	public void test() throws Exception {
		wordCloud = new WordCloud(null); //test passed when null is passed
	}

}
