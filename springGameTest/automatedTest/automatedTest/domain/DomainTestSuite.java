package automatedTest.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	GameVOTest.class,
//	HomeVOTest.class,
	MarketVTest.class,
	CraftVOTest.class,
	})
public class DomainTestSuite {

}