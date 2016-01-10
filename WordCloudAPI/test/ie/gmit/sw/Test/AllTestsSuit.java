package ie.gmit.sw.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CollisionDetectionTest.class, CoordinateTest.class, CreateWordCloudTest.class, FileParserTest.class,
		FrequencyAnalyzorTest.class, URLParserTest.class, WordCloudGraphicsTest.class, WordCloudStrategyTest.class,
		WordTest.class })
public class AllTestsSuit {
}

