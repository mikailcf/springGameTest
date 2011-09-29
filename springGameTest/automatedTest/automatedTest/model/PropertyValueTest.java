package automatedTest.model;

import java.util.Date;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.model.PropertyType;
import springGameTest.model.PropertyValue;
import springGameTest.model.WrongTypeException;

public class PropertyValueTest {

	private PropertyValue nullInteger = new PropertyValue(PropertyType.Integer);
	private PropertyValue nullFloat = new PropertyValue(PropertyType.Float);
	private PropertyValue nullString = new PropertyValue(PropertyType.String);
	private PropertyValue nullDate = new PropertyValue(PropertyType.Date);

	private PropertyValue integer0 = new PropertyValue(0);
	private PropertyValue integer1 = new PropertyValue(1);
	private PropertyValue integerMinus1 = new PropertyValue(-1);
	private PropertyValue integer2 = new PropertyValue(2);
	private PropertyValue integer1Other = new PropertyValue(PropertyType.Integer);
	private PropertyValue integer2Other = new PropertyValue(PropertyType.Integer);

	private PropertyValue float0 = new PropertyValue(0.0);
	private PropertyValue float1 = new PropertyValue(1.0);
	private PropertyValue floatMinus1 = new PropertyValue(-1.0);
	private PropertyValue float2 = new PropertyValue(2.0);
	private PropertyValue floatHalf = new PropertyValue(0.5);
	private PropertyValue float2Other = new PropertyValue(PropertyType.Float);
	private PropertyValue floatHalfOther = new PropertyValue(PropertyType.Float);

	private PropertyValue stringEmpty = new PropertyValue("");
	private PropertyValue stringA = new PropertyValue("a");
	private PropertyValue stringAz = new PropertyValue("az");
	private PropertyValue stringAOther = new PropertyValue(PropertyType.String);
	private PropertyValue stringAzOther = new PropertyValue(PropertyType.String);

	Date now = new Date();
	private PropertyValue dateNow = new PropertyValue(now);
	private PropertyValue dateNowOther = new PropertyValue(PropertyType.Date);
	
	@Before
	public void setUp() {
		integer1Other.setIntValue(1);
		integer2Other.setIntValue(2);
		float2Other.setFloatValue(2.0);
		floatHalfOther.setFloatValue(0.5);
		stringAOther.setStringValue("a");
		stringAzOther.setStringValue("az");
		dateNowOther.setDateValue(now);
	}
	
	@After
	public void close() {
		
	}

	@Test public final void test001() {
	    assertFalse(nullInteger.equals(nullFloat));
	}

	@Test public final void test002() {
	    assertFalse(nullInteger.equals(nullString));
	}

	@Test public final void test003() {
	    assertFalse(nullInteger.equals(nullDate));
	}

	@Test public final void test004() {
	    assertTrue(nullInteger.equals(integer0));
	}

	@Test public final void test005() {
	    assertFalse(nullInteger.equals(integer1));
	}

	@Test public final void test006() {
	    assertFalse(nullInteger.equals(integerMinus1));
	}

	@Test public final void test007() {
	    assertFalse(nullInteger.equals(integer2));
	}

	@Test public final void test008() {
	    assertFalse(nullInteger.equals(integer1Other));
	}

	@Test public final void test009() {
	    assertFalse(nullInteger.equals(integer2Other));
	}

	@Test public final void test010() {
	    assertFalse(nullInteger.equals(float0));
	}

	@Test public final void test011() {
	    assertFalse(nullInteger.equals(float1));
	}

	@Test public final void test012() {
	    assertFalse(nullInteger.equals(floatMinus1));
	}

	@Test public final void test013() {
	    assertFalse(nullInteger.equals(float2));
	}

	@Test public final void test014() {
	    assertFalse(nullInteger.equals(floatHalf));
	}

	@Test public final void test015() {
	    assertFalse(nullInteger.equals(float2Other));
	}

	@Test public final void test016() {
	    assertFalse(nullInteger.equals(floatHalfOther));
	}

	@Test public final void test017() {
	    assertFalse(nullInteger.equals(stringEmpty));
	}

	@Test public final void test018() {
	    assertFalse(nullInteger.equals(stringA));
	}

	@Test public final void test019() {
	    assertFalse(nullInteger.equals(stringAz));
	}

	@Test public final void test020() {
	    assertFalse(nullInteger.equals(stringAOther));
	}

	@Test public final void test021() {
	    assertFalse(nullInteger.equals(stringAzOther));
	}

	@Test public final void test022() {
	    assertFalse(nullInteger.equals(dateNow));
	}

	@Test public final void test023() {
	    assertFalse(nullInteger.equals(dateNowOther));
	}

	@Test public final void test024() {
	    assertFalse(nullFloat.equals(nullString));
	}

	@Test public final void test025() {
	    assertFalse(nullFloat.equals(nullDate));
	}

	@Test public final void test026() {
	    assertFalse(nullFloat.equals(integer0));
	}

	@Test public final void test027() {
	    assertFalse(nullFloat.equals(integer1));
	}

	@Test public final void test028() {
	    assertFalse(nullFloat.equals(integerMinus1));
	}

	@Test public final void test029() {
	    assertFalse(nullFloat.equals(integer2));
	}

	@Test public final void test030() {
	    assertFalse(nullFloat.equals(integer1Other));
	}

	@Test public final void test031() {
	    assertFalse(nullFloat.equals(integer2Other));
	}

	@Test public final void test032() {
	    assertTrue(nullFloat.equals(float0));
	}

	@Test public final void test033() {
	    assertFalse(nullFloat.equals(float1));
	}

	@Test public final void test034() {
	    assertFalse(nullFloat.equals(floatMinus1));
	}

	@Test public final void test035() {
	    assertFalse(nullFloat.equals(float2));
	}

	@Test public final void test036() {
	    assertFalse(nullFloat.equals(floatHalf));
	}

	@Test public final void test037() {
	    assertFalse(nullFloat.equals(float2Other));
	}

	@Test public final void test038() {
	    assertFalse(nullFloat.equals(floatHalfOther));
	}

	@Test public final void test039() {
	    assertFalse(nullFloat.equals(stringEmpty));
	}

	@Test public final void test040() {
	    assertFalse(nullFloat.equals(stringA));
	}

	@Test public final void test041() {
	    assertFalse(nullFloat.equals(stringAz));
	}

	@Test public final void test042() {
	    assertFalse(nullFloat.equals(stringAOther));
	}

	@Test public final void test043() {
	    assertFalse(nullFloat.equals(stringAzOther));
	}

	@Test public final void test044() {
	    assertFalse(nullFloat.equals(dateNow));
	}

	@Test public final void test045() {
	    assertFalse(nullFloat.equals(dateNowOther));
	}

	@Test public final void test046() {
	    assertFalse(nullString.equals(nullDate));
	}

	@Test public final void test047() {
	    assertFalse(nullString.equals(integer0));
	}

	@Test public final void test048() {
	    assertFalse(nullString.equals(integer1));
	}

	@Test public final void test049() {
	    assertFalse(nullString.equals(integerMinus1));
	}

	@Test public final void test050() {
	    assertFalse(nullString.equals(integer2));
	}

	@Test public final void test051() {
	    assertFalse(nullString.equals(integer1Other));
	}

	@Test public final void test052() {
	    assertFalse(nullString.equals(integer2Other));
	}

	@Test public final void test053() {
	    assertFalse(nullString.equals(float0));
	}

	@Test public final void test054() {
	    assertFalse(nullString.equals(float1));
	}

	@Test public final void test055() {
	    assertFalse(nullString.equals(floatMinus1));
	}

	@Test public final void test056() {
	    assertFalse(nullString.equals(float2));
	}

	@Test public final void test057() {
	    assertFalse(nullString.equals(floatHalf));
	}

	@Test public final void test058() {
	    assertFalse(nullString.equals(float2Other));
	}

	@Test public final void test059() {
	    assertFalse(nullString.equals(floatHalfOther));
	}

	@Test public final void test060() {
	    assertFalse(nullString.equals(stringEmpty));
	}

	@Test public final void test061() {
	    assertFalse(nullString.equals(stringA));
	}

	@Test public final void test062() {
	    assertFalse(nullString.equals(stringAz));
	}

	@Test public final void test063() {
	    assertFalse(nullString.equals(stringAOther));
	}

	@Test public final void test064() {
	    assertFalse(nullString.equals(stringAzOther));
	}

	@Test public final void test065() {
	    assertFalse(nullString.equals(dateNow));
	}

	@Test public final void test066() {
	    assertFalse(nullString.equals(dateNowOther));
	}

	@Test public final void test067() {
	    assertFalse(nullDate.equals(integer0));
	}

	@Test public final void test068() {
	    assertFalse(nullDate.equals(integer1));
	}

	@Test public final void test069() {
	    assertFalse(nullDate.equals(integerMinus1));
	}

	@Test public final void test070() {
	    assertFalse(nullDate.equals(integer2));
	}

	@Test public final void test071() {
	    assertFalse(nullDate.equals(integer1Other));
	}

	@Test public final void test072() {
	    assertFalse(nullDate.equals(integer2Other));
	}

	@Test public final void test073() {
	    assertFalse(nullDate.equals(float0));
	}

	@Test public final void test074() {
	    assertFalse(nullDate.equals(float1));
	}

	@Test public final void test075() {
	    assertFalse(nullDate.equals(floatMinus1));
	}

	@Test public final void test076() {
	    assertFalse(nullDate.equals(float2));
	}

	@Test public final void test077() {
	    assertFalse(nullDate.equals(floatHalf));
	}

	@Test public final void test078() {
	    assertFalse(nullDate.equals(float2Other));
	}

	@Test public final void test079() {
	    assertFalse(nullDate.equals(floatHalfOther));
	}

	@Test public final void test080() {
	    assertFalse(nullDate.equals(stringEmpty));
	}

	@Test public final void test081() {
	    assertFalse(nullDate.equals(stringA));
	}

	@Test public final void test082() {
	    assertFalse(nullDate.equals(stringAz));
	}

	@Test public final void test083() {
	    assertFalse(nullDate.equals(stringAOther));
	}

	@Test public final void test084() {
	    assertFalse(nullDate.equals(stringAzOther));
	}

	@Test public final void test085() {
	    assertFalse(nullDate.equals(dateNow));
	}

	@Test public final void test086() {
	    assertFalse(nullDate.equals(dateNowOther));
	}

	@Test public final void test087() {
	    assertFalse(integer0.equals(integer1));
	}

	@Test public final void test088() {
	    assertFalse(integer0.equals(integerMinus1));
	}

	@Test public final void test089() {
	    assertFalse(integer0.equals(integer2));
	}

	@Test public final void test090() {
	    assertFalse(integer0.equals(integer1Other));
	}

	@Test public final void test091() {
	    assertFalse(integer0.equals(integer2Other));
	}

	@Test public final void test092() {
	    assertFalse(integer0.equals(float0));
	}

	@Test public final void test093() {
	    assertFalse(integer0.equals(float1));
	}

	@Test public final void test094() {
	    assertFalse(integer0.equals(floatMinus1));
	}

	@Test public final void test095() {
	    assertFalse(integer0.equals(float2));
	}

	@Test public final void test096() {
	    assertFalse(integer0.equals(floatHalf));
	}

	@Test public final void test097() {
	    assertFalse(integer0.equals(float2Other));
	}

	@Test public final void test098() {
	    assertFalse(integer0.equals(floatHalfOther));
	}

	@Test public final void test099() {
	    assertFalse(integer0.equals(stringEmpty));
	}

	@Test public final void test100() {
	    assertFalse(integer0.equals(stringA));
	}

	@Test public final void test101() {
	    assertFalse(integer0.equals(stringAz));
	}

	@Test public final void test102() {
	    assertFalse(integer0.equals(stringAOther));
	}

	@Test public final void test103() {
	    assertFalse(integer0.equals(stringAzOther));
	}

	@Test public final void test104() {
	    assertFalse(integer0.equals(dateNow));
	}

	@Test public final void test105() {
	    assertFalse(integer0.equals(dateNowOther));
	}

	@Test public final void test106() {
	    assertFalse(integer1.equals(integerMinus1));
	}

	@Test public final void test107() {
	    assertFalse(integer1.equals(integer2));
	}

	@Test public final void test108() {
	    assertTrue(integer1.equals(integer1Other));
	}

	@Test public final void test109() {
	    assertFalse(integer1.equals(integer2Other));
	}

	@Test public final void test110() {
	    assertFalse(integer1.equals(float0));
	}

	@Test public final void test111() {
	    assertFalse(integer1.equals(float1));
	}

	@Test public final void test112() {
	    assertFalse(integer1.equals(floatMinus1));
	}

	@Test public final void test113() {
	    assertFalse(integer1.equals(float2));
	}

	@Test public final void test114() {
	    assertFalse(integer1.equals(floatHalf));
	}

	@Test public final void test115() {
	    assertFalse(integer1.equals(float2Other));
	}

	@Test public final void test116() {
	    assertFalse(integer1.equals(floatHalfOther));
	}

	@Test public final void test117() {
	    assertFalse(integer1.equals(stringEmpty));
	}

	@Test public final void test118() {
	    assertFalse(integer1.equals(stringA));
	}

	@Test public final void test119() {
	    assertFalse(integer1.equals(stringAz));
	}

	@Test public final void test120() {
	    assertFalse(integer1.equals(stringAOther));
	}

	@Test public final void test121() {
	    assertFalse(integer1.equals(stringAzOther));
	}

	@Test public final void test122() {
	    assertFalse(integer1.equals(dateNow));
	}

	@Test public final void test123() {
	    assertFalse(integer1.equals(dateNowOther));
	}

	@Test public final void test124() {
	    assertFalse(integerMinus1.equals(integer2));
	}

	@Test public final void test125() {
	    assertFalse(integerMinus1.equals(integer1Other));
	}

	@Test public final void test126() {
	    assertFalse(integerMinus1.equals(integer2Other));
	}

	@Test public final void test127() {
	    assertFalse(integerMinus1.equals(float0));
	}

	@Test public final void test128() {
	    assertFalse(integerMinus1.equals(float1));
	}

	@Test public final void test129() {
	    assertFalse(integerMinus1.equals(floatMinus1));
	}

	@Test public final void test130() {
	    assertFalse(integerMinus1.equals(float2));
	}

	@Test public final void test131() {
	    assertFalse(integerMinus1.equals(floatHalf));
	}

	@Test public final void test132() {
	    assertFalse(integerMinus1.equals(float2Other));
	}

	@Test public final void test133() {
	    assertFalse(integerMinus1.equals(floatHalfOther));
	}

	@Test public final void test134() {
	    assertFalse(integerMinus1.equals(stringEmpty));
	}

	@Test public final void test135() {
	    assertFalse(integerMinus1.equals(stringA));
	}

	@Test public final void test136() {
	    assertFalse(integerMinus1.equals(stringAz));
	}

	@Test public final void test137() {
	    assertFalse(integerMinus1.equals(stringAOther));
	}

	@Test public final void test138() {
	    assertFalse(integerMinus1.equals(stringAzOther));
	}

	@Test public final void test139() {
	    assertFalse(integerMinus1.equals(dateNow));
	}

	@Test public final void test140() {
	    assertFalse(integerMinus1.equals(dateNowOther));
	}

	@Test public final void test141() {
	    assertFalse(integer2.equals(integer1Other));
	}

	@Test public final void test142() {
	    assertTrue(integer2.equals(integer2Other));
	}

	@Test public final void test143() {
	    assertFalse(integer2.equals(float0));
	}

	@Test public final void test144() {
	    assertFalse(integer2.equals(float1));
	}

	@Test public final void test145() {
	    assertFalse(integer2.equals(floatMinus1));
	}

	@Test public final void test146() {
	    assertFalse(integer2.equals(float2));
	}

	@Test public final void test147() {
	    assertFalse(integer2.equals(floatHalf));
	}

	@Test public final void test148() {
	    assertFalse(integer2.equals(float2Other));
	}

	@Test public final void test149() {
	    assertFalse(integer2.equals(floatHalfOther));
	}

	@Test public final void test150() {
	    assertFalse(integer2.equals(stringEmpty));
	}

	@Test public final void test151() {
	    assertFalse(integer2.equals(stringA));
	}

	@Test public final void test152() {
	    assertFalse(integer2.equals(stringAz));
	}

	@Test public final void test153() {
	    assertFalse(integer2.equals(stringAOther));
	}

	@Test public final void test154() {
	    assertFalse(integer2.equals(stringAzOther));
	}

	@Test public final void test155() {
	    assertFalse(integer2.equals(dateNow));
	}

	@Test public final void test156() {
	    assertFalse(integer2.equals(dateNowOther));
	}

	@Test public final void test157() {
	    assertFalse(integer1Other.equals(integer2Other));
	}

	@Test public final void test158() {
	    assertFalse(integer1Other.equals(float0));
	}

	@Test public final void test159() {
	    assertFalse(integer1Other.equals(float1));
	}

	@Test public final void test160() {
	    assertFalse(integer1Other.equals(floatMinus1));
	}

	@Test public final void test161() {
	    assertFalse(integer1Other.equals(float2));
	}

	@Test public final void test162() {
	    assertFalse(integer1Other.equals(floatHalf));
	}

	@Test public final void test163() {
	    assertFalse(integer1Other.equals(float2Other));
	}

	@Test public final void test164() {
	    assertFalse(integer1Other.equals(floatHalfOther));
	}

	@Test public final void test165() {
	    assertFalse(integer1Other.equals(stringEmpty));
	}

	@Test public final void test166() {
	    assertFalse(integer1Other.equals(stringA));
	}

	@Test public final void test167() {
	    assertFalse(integer1Other.equals(stringAz));
	}

	@Test public final void test168() {
	    assertFalse(integer1Other.equals(stringAOther));
	}

	@Test public final void test169() {
	    assertFalse(integer1Other.equals(stringAzOther));
	}

	@Test public final void test170() {
	    assertFalse(integer1Other.equals(dateNow));
	}

	@Test public final void test171() {
	    assertFalse(integer1Other.equals(dateNowOther));
	}

	@Test public final void test172() {
	    assertFalse(integer2Other.equals(float0));
	}

	@Test public final void test173() {
	    assertFalse(integer2Other.equals(float1));
	}

	@Test public final void test174() {
	    assertFalse(integer2Other.equals(floatMinus1));
	}

	@Test public final void test175() {
	    assertFalse(integer2Other.equals(float2));
	}

	@Test public final void test176() {
	    assertFalse(integer2Other.equals(floatHalf));
	}

	@Test public final void test177() {
	    assertFalse(integer2Other.equals(float2Other));
	}

	@Test public final void test178() {
	    assertFalse(integer2Other.equals(floatHalfOther));
	}

	@Test public final void test179() {
	    assertFalse(integer2Other.equals(stringEmpty));
	}

	@Test public final void test180() {
	    assertFalse(integer2Other.equals(stringA));
	}

	@Test public final void test181() {
	    assertFalse(integer2Other.equals(stringAz));
	}

	@Test public final void test182() {
	    assertFalse(integer2Other.equals(stringAOther));
	}

	@Test public final void test183() {
	    assertFalse(integer2Other.equals(stringAzOther));
	}

	@Test public final void test184() {
	    assertFalse(integer2Other.equals(dateNow));
	}

	@Test public final void test185() {
	    assertFalse(integer2Other.equals(dateNowOther));
	}

	@Test public final void test186() {
	    assertFalse(float0.equals(float1));
	}

	@Test public final void test187() {
	    assertFalse(float0.equals(floatMinus1));
	}

	@Test public final void test188() {
	    assertFalse(float0.equals(float2));
	}

	@Test public final void test189() {
	    assertFalse(float0.equals(floatHalf));
	}

	@Test public final void test190() {
	    assertFalse(float0.equals(float2Other));
	}

	@Test public final void test191() {
	    assertFalse(float0.equals(floatHalfOther));
	}

	@Test public final void test192() {
	    assertFalse(float0.equals(stringEmpty));
	}

	@Test public final void test193() {
	    assertFalse(float0.equals(stringA));
	}

	@Test public final void test194() {
	    assertFalse(float0.equals(stringAz));
	}

	@Test public final void test195() {
	    assertFalse(float0.equals(stringAOther));
	}

	@Test public final void test196() {
	    assertFalse(float0.equals(stringAzOther));
	}

	@Test public final void test197() {
	    assertFalse(float0.equals(dateNow));
	}

	@Test public final void test198() {
	    assertFalse(float0.equals(dateNowOther));
	}

	@Test public final void test199() {
	    assertFalse(float1.equals(floatMinus1));
	}

	@Test public final void test200() {
	    assertFalse(float1.equals(float2));
	}

	@Test public final void test201() {
	    assertFalse(float1.equals(floatHalf));
	}

	@Test public final void test202() {
	    assertFalse(float1.equals(float2Other));
	}

	@Test public final void test203() {
	    assertFalse(float1.equals(floatHalfOther));
	}

	@Test public final void test204() {
	    assertFalse(float1.equals(stringEmpty));
	}

	@Test public final void test205() {
	    assertFalse(float1.equals(stringA));
	}

	@Test public final void test206() {
	    assertFalse(float1.equals(stringAz));
	}

	@Test public final void test207() {
	    assertFalse(float1.equals(stringAOther));
	}

	@Test public final void test208() {
	    assertFalse(float1.equals(stringAzOther));
	}

	@Test public final void test209() {
	    assertFalse(float1.equals(dateNow));
	}

	@Test public final void test210() {
	    assertFalse(float1.equals(dateNowOther));
	}

	@Test public final void test211() {
	    assertFalse(floatMinus1.equals(float2));
	}

	@Test public final void test212() {
	    assertFalse(floatMinus1.equals(floatHalf));
	}

	@Test public final void test213() {
	    assertFalse(floatMinus1.equals(float2Other));
	}

	@Test public final void test214() {
	    assertFalse(floatMinus1.equals(floatHalfOther));
	}

	@Test public final void test215() {
	    assertFalse(floatMinus1.equals(stringEmpty));
	}

	@Test public final void test216() {
	    assertFalse(floatMinus1.equals(stringA));
	}

	@Test public final void test217() {
	    assertFalse(floatMinus1.equals(stringAz));
	}

	@Test public final void test218() {
	    assertFalse(floatMinus1.equals(stringAOther));
	}

	@Test public final void test219() {
	    assertFalse(floatMinus1.equals(stringAzOther));
	}

	@Test public final void test220() {
	    assertFalse(floatMinus1.equals(dateNow));
	}

	@Test public final void test221() {
	    assertFalse(floatMinus1.equals(dateNowOther));
	}

	@Test public final void test222() {
	    assertFalse(float2.equals(floatHalf));
	}

	@Test public final void test223() {
	    assertTrue(float2.equals(float2Other));
	}

	@Test public final void test224() {
	    assertFalse(float2.equals(floatHalfOther));
	}

	@Test public final void test225() {
	    assertFalse(float2.equals(stringEmpty));
	}

	@Test public final void test226() {
	    assertFalse(float2.equals(stringA));
	}

	@Test public final void test227() {
	    assertFalse(float2.equals(stringAz));
	}

	@Test public final void test228() {
	    assertFalse(float2.equals(stringAOther));
	}

	@Test public final void test229() {
	    assertFalse(float2.equals(stringAzOther));
	}

	@Test public final void test230() {
	    assertFalse(float2.equals(dateNow));
	}

	@Test public final void test231() {
	    assertFalse(float2.equals(dateNowOther));
	}

	@Test public final void test232() {
	    assertFalse(floatHalf.equals(float2Other));
	}

	@Test public final void test233() {
	    assertTrue(floatHalf.equals(floatHalfOther));
	}

	@Test public final void test234() {
	    assertFalse(floatHalf.equals(stringEmpty));
	}

	@Test public final void test235() {
	    assertFalse(floatHalf.equals(stringA));
	}

	@Test public final void test236() {
	    assertFalse(floatHalf.equals(stringAz));
	}

	@Test public final void test237() {
	    assertFalse(floatHalf.equals(stringAOther));
	}

	@Test public final void test238() {
	    assertFalse(floatHalf.equals(stringAzOther));
	}

	@Test public final void test239() {
	    assertFalse(floatHalf.equals(dateNow));
	}

	@Test public final void test240() {
	    assertFalse(floatHalf.equals(dateNowOther));
	}

	@Test public final void test241() {
	    assertFalse(float2Other.equals(floatHalfOther));
	}

	@Test public final void test242() {
	    assertFalse(float2Other.equals(stringEmpty));
	}

	@Test public final void test243() {
	    assertFalse(float2Other.equals(stringA));
	}

	@Test public final void test244() {
	    assertFalse(float2Other.equals(stringAz));
	}

	@Test public final void test245() {
	    assertFalse(float2Other.equals(stringAOther));
	}

	@Test public final void test246() {
	    assertFalse(float2Other.equals(stringAzOther));
	}

	@Test public final void test247() {
	    assertFalse(float2Other.equals(dateNow));
	}

	@Test public final void test248() {
	    assertFalse(float2Other.equals(dateNowOther));
	}

	@Test public final void test249() {
	    assertFalse(floatHalfOther.equals(stringEmpty));
	}

	@Test public final void test250() {
	    assertFalse(floatHalfOther.equals(stringA));
	}

	@Test public final void test251() {
	    assertFalse(floatHalfOther.equals(stringAz));
	}

	@Test public final void test252() {
	    assertFalse(floatHalfOther.equals(stringAOther));
	}

	@Test public final void test253() {
	    assertFalse(floatHalfOther.equals(stringAzOther));
	}

	@Test public final void test254() {
	    assertFalse(floatHalfOther.equals(dateNow));
	}

	@Test public final void test255() {
	    assertFalse(floatHalfOther.equals(dateNowOther));
	}

	@Test public final void test256() {
	    assertFalse(stringEmpty.equals(stringA));
	}

	@Test public final void test257() {
	    assertFalse(stringEmpty.equals(stringAz));
	}

	@Test public final void test258() {
	    assertFalse(stringEmpty.equals(stringAOther));
	}

	@Test public final void test259() {
	    assertFalse(stringEmpty.equals(stringAzOther));
	}

	@Test public final void test260() {
	    assertFalse(stringEmpty.equals(dateNow));
	}

	@Test public final void test261() {
	    assertFalse(stringEmpty.equals(dateNowOther));
	}

	@Test public final void test262() {
	    assertFalse(stringA.equals(stringAz));
	}

	@Test public final void test263() {
	    assertTrue(stringA.equals(stringAOther));
	}

	@Test public final void test264() {
	    assertFalse(stringA.equals(stringAzOther));
	}

	@Test public final void test265() {
	    assertFalse(stringA.equals(dateNow));
	}

	@Test public final void test266() {
	    assertFalse(stringA.equals(dateNowOther));
	}

	@Test public final void test267() {
	    assertFalse(stringAz.equals(stringAOther));
	}

	@Test public final void test268() {
	    assertTrue(stringAz.equals(stringAzOther));
	}

	@Test public final void test269() {
	    assertFalse(stringAz.equals(dateNow));
	}

	@Test public final void test270() {
	    assertFalse(stringAz.equals(dateNowOther));
	}

	@Test public final void test271() {
	    assertFalse(stringAOther.equals(stringAzOther));
	}

	@Test public final void test272() {
	    assertFalse(stringAOther.equals(dateNow));
	}

	@Test public final void test273() {
	    assertFalse(stringAOther.equals(dateNowOther));
	}

	@Test public final void test274() {
	    assertFalse(stringAzOther.equals(dateNow));
	}

	@Test public final void test275() {
	    assertFalse(stringAzOther.equals(dateNowOther));
	}

	@Test public final void test276() {
	    assertTrue(dateNow.equals(dateNowOther));
	}

	@Test public final void test277() {
	    assertTrue(nullInteger.equals(nullInteger.copy()));
	}

	@Test public final void test278() {
	    assertTrue(nullFloat.equals(nullFloat.copy()));
	}

	@Test public final void test279() {
	    assertTrue(nullString.equals(nullString.copy()));
	}

	@Test public final void test280() {
	    assertTrue(nullDate.equals(nullDate.copy()));
	}

	@Test public final void test281() {
	    assertTrue(integer0.equals(integer0.copy()));
	}

	@Test public final void test282() {
	    assertTrue(integer1.equals(integer1.copy()));
	}

	@Test public final void test283() {
	    assertTrue(integerMinus1.equals(integerMinus1.copy()));
	}

	@Test public final void test284() {
	    assertTrue(integer2.equals(integer2.copy()));
	}

	@Test public final void test285() {
	    assertTrue(integer1Other.equals(integer1Other.copy()));
	}

	@Test public final void test286() {
	    assertTrue(integer2Other.equals(integer2Other.copy()));
	}

	@Test public final void test287() {
	    assertTrue(float0.equals(float0.copy()));
	}

	@Test public final void test288() {
	    assertTrue(float1.equals(float1.copy()));
	}

	@Test public final void test289() {
	    assertTrue(floatMinus1.equals(floatMinus1.copy()));
	}

	@Test public final void test290() {
	    assertTrue(float2.equals(float2.copy()));
	}

	@Test public final void test291() {
	    assertTrue(floatHalf.equals(floatHalf.copy()));
	}

	@Test public final void test292() {
	    assertTrue(float2Other.equals(float2Other.copy()));
	}

	@Test public final void test293() {
	    assertTrue(floatHalfOther.equals(floatHalfOther.copy()));
	}

	@Test public final void test294() {
	    assertTrue(stringEmpty.equals(stringEmpty.copy()));
	}

	@Test public final void test295() {
	    assertTrue(stringA.equals(stringA.copy()));
	}

	@Test public final void test296() {
	    assertTrue(stringAz.equals(stringAz.copy()));
	}

	@Test public final void test297() {
	    assertTrue(stringAOther.equals(stringAOther.copy()));
	}

	@Test public final void test298() {
	    assertTrue(stringAzOther.equals(stringAzOther.copy()));
	}

	@Test public final void test299() {
	    assertTrue(dateNow.equals(dateNow.copy()));
	}

	@Test public final void test300() {
	    assertTrue(dateNowOther.equals(dateNowOther.copy()));
	}

	@Test public final void test301() {
		long value = 37;
		nullInteger.setIntValue(value);
	    assertTrue(value == nullInteger.getIntValue());
	}

	@Test public final void test302() {
		double value = 49.0;
		nullFloat.setFloatValue(value);
	    assertTrue(value == nullFloat.getFloatValue());
	}

	@Test public final void test303() {
		String value = "Bananas";
		nullString.setStringValue(value);
	    assertTrue(value == nullString.getStringValue());
	}

	@Test public final void test304() {
		Date value = new Date();
		nullDate.setDateValue(value);
	    assertTrue(value.equals(nullDate.getDateValue()));
	}

	@Test (expected = WrongTypeException.class)
	public final void test305() {
		nullInteger.setFloatValue(0.0);
	}

	@Test (expected = WrongTypeException.class)
	public final void test306() {
		nullInteger.setStringValue("a");
	}

	@Test (expected = WrongTypeException.class)
	public final void test307() {
		nullInteger.setDateValue(new Date());
	}

	@Test (expected = WrongTypeException.class)
	public final void test308() {
		nullFloat.setIntValue(0);
	}

	@Test (expected = WrongTypeException.class)
	public final void test309() {
		nullFloat.setStringValue("a");
	}

	@Test (expected = WrongTypeException.class)
	public final void test310() {
		nullFloat.setDateValue(new Date());
	}

	@Test (expected = WrongTypeException.class)
	public final void test311() {
		nullString.setIntValue(0);
	}

	@Test (expected = WrongTypeException.class)
	public final void test312() {
		nullString.setFloatValue(0.0);
	}

	@Test (expected = WrongTypeException.class)
	public final void test313() {
		nullString.setDateValue(new Date());
	}

	@Test (expected = WrongTypeException.class)
	public final void test314() {
		nullDate.setIntValue(0);
	}

	@Test (expected = WrongTypeException.class)
	public final void test315() {
		nullDate.setFloatValue(0.0);
	}

	@Test (expected = WrongTypeException.class)
	public final void test316() {
		nullDate.setStringValue("a");
	}
}
