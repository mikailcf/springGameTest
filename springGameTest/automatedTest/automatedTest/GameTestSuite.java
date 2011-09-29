package automatedTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import automatedTest.domain.DomainTestSuite;
import automatedTest.model.ModelTestSuite;
import automatedTest.service.ServiceTestSuite;


@RunWith(Suite.class)
@SuiteClasses({
	ModelTestSuite.class,
	DomainTestSuite.class,
	ServiceTestSuite.class,
	})
public class GameTestSuite {

}
