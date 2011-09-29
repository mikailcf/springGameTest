package automatedTest.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	PropertyTest.class,
	PropertyValueTest.class,
	EntityPropertiesTest.class,
	EventTest.class,
	ItemTest.class,
	InventoryTest.class,
	UserTest.class })
public class ModelTestSuite {

}
