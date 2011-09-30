package automatedTest.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	PropertyServiceTest.class,
	EventServiceTest.class,
	})
public class ServiceTestSuite {

}