package com.zxh.Hello_JUnit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zxh.Hello_JUnit.App;

/**
 * JUnit 5 (with JUnitPlatform.class)
 * 
 * Class-level Exercises:
 * <ol>
 * <li>Enable Eclipse JUnit support for this test class using the {@link org.junit.runner.RunWith @RunWith} and
 * {@link org.junit.platform.runner.JUnitPlatform
 * JUnitPlatform} class.</li>
 * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
 * report.</li>
 * </ol>
 *
 */
@Disabled
@RunWith(JUnitPlatform.class)
@DisplayName("Testing with JUnit5 Platform...")
public class AppTest {

  // Create a JDK Logger here
	private static final Logger log = LoggerFactory.getLogger(AppTest.class);
	
  // Create a fixture for the class under test
	private App classUnderTest;
  // Do something before ANY test is run in this class
	@BeforeAll
	public static void init() {
		log.info("@BeforeAll: init()");
  }

  // Do something after ALL tests in this class are run
	@AfterAll
	public static void done() {
	  log.info("@AfterAll: done()");
  }

  // Create an instance of the test class before each @Test method is executed
	@BeforeEach
	public void setUp() throws Exception {
		log.info("@BeforeEach: setUp()");
	    classUnderTest = new App();
	}
	// Destroy reference to the instance of the test class after each @Test method is executed
	// It is been a long time since I saw release. Does GC not work?
	@AfterEach
	public void tearDown() throws Exception{
		log.info("@AfterEach: tearDown()");
	}
  // Disabled test
	@Test
	@Disabled
	@DisplayName("A test will be skipped")
	void testNotRun() {
		log.info("This test is disabled, and will not be run. (Why ecsit :P )");
	}

  /**
   * testAdd() - Exercises:
   * <ol>
   * <li>Tell JUnit this method is a test method.</li>
   * <li>Give it a cool display name for the test report.</li>
   * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
   * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
   * <ol>
   * <li>1, 2, 3, 4</li>
   * <li>20, 934, 110</li>
   * <li>2, 4, 6</li>
   * </ol>
   * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers are
   * tested (i.e., if one fails, it should not fail the test method). Hint: use
   * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
   * </ol>
   */
	@Test
	@DisplayName("Test for add function ...")
	public void testAdd() {
    //
    // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see the
    // buttery smooth javadoc above.)
    //
		log.info("@Test:testAdd()");
		assertNotNull(classUnderTest);
		assertAll(
			() -> {
				// test No. 1
				long[] numbersToSum = { 1, 2, 3, 4 };
		        long expectedSum = 10;
		        long actualSum = classUnderTest.add(numbersToSum);
		        assertEquals(expectedSum, actualSum);
			},
			() -> {
				//Test No.2
				long[] numbersToSum = new long[] { 20, 934, 110 };
		        long expectedSum = 1064;
				long actualSum = classUnderTest.add(numbersToSum);
				assertEquals(expectedSum, actualSum);
			},
			() -> {
				// Test No.3
		        long[] numbersToSum = new long[] { 2, 4, 6 };
		        long expectedSum = 12;
		        long actualSum = classUnderTest.add(numbersToSum);
		        assertEquals(expectedSum, actualSum);
			}
				);
		//fail("Test not implemented!");
	}

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * <li>Create an instance of the {@link com.makotojava.learn.hellojunit5.App App} class specifically for this nested
   * class:
   * <ul>
   * <li>Set the <code>classUnderTest</code> variable in a method called <code>setUp()</code> that runs before the test
   * method does (hint: use {@link org.junit.jupiter.api.BeforeEach @BeforeEach})</li>
   * </ul>
   * <li>Set the <code>classUnderTest</code> variable to null in a method called <code>tearDown()</code> that runs after
   * the
   * test method does (hint: use {@link org.junit.jupiter.api.BeforeEach @AfterEach})</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("The Sum are less then 0...")
  class NegativeNumbersTest {

    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1, -2, -3, -4</li>
     * <li>-20, -934, -110</li>
     * <li>-2, -4, -6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
	  
	  private App classUnderTest;
	  
	  @BeforeEach
	  public void setUp() throws Exception{
		  classUnderTest = new App();
	  }
	  @AfterEach
	  public void tearDown() throws Exception{
		  classUnderTest = null;
	  }
	  @Test
	  @DisplayName("Three tests whoes sum are less than 0...")
	  public void testAdd() {
		  assertNotNull(classUnderTest);
		  assertAll(
				  () -> {
			            //
			            // Test #1
			            long[] numbersToSum = { -1, -2, -3, -4 };
			            long expectedSum = -10;
			            long actualSum = classUnderTest.add(numbersToSum);
			            assertEquals(expectedSum, actualSum);
			          },
			          () -> {
			            //
			            // Test #2
			            long[] numbersToSum = { -20, -934, -110 };
			            long expectedSum = -1064;
			            long actualSum = classUnderTest.add(numbersToSum);
			            assertEquals(expectedSum, actualSum);
			          },
			          () -> {
			            //
			            // Test #3
			            long[] numbersToSum = new long[] { -2, -4, -6 };
			            long expectedSum = -12;
			            long actualSum = classUnderTest.add(numbersToSum);
			            assertEquals(expectedSum, actualSum);
			          });
			    }
	}
     

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("When 0 < numbers > 0")
  class PositiveAndNegativeNumbersTest {

    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1, 2, -3, 4</li>
     * <li>-20, 934, -110</li>
     * <li>-2, -4, 6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
	  @Test
	    @DisplayName("Three tests with both positive and negative numbers")
	    public void testAdd() {
	      assertNotNull(classUnderTest);
	      assertAll(
	          () -> {
	            //
	            // Test #1
	            long[] numbersToSum = { -1, 2, -3, 4 };
	            long expectedSum = 2;
	            long actualSum = classUnderTest.add(numbersToSum);
	            assertEquals(expectedSum, actualSum);
	          },
	          () -> {
	            //
	            // Test #2
	            long[] numbersToSum = { -20, 934, -110 };
	            long expectedSum = 804;
	            long actualSum = classUnderTest.add(numbersToSum);
	            assertEquals(expectedSum, actualSum);
	          },
	          () -> {
	            //
	            // Test #3
	            long[] numbersToSum = new long[] { -2, -4, 6 };
	            long expectedSum = 0;
	            long actualSum = classUnderTest.add(numbersToSum);
	            assertEquals(expectedSum, actualSum);
	          });
	    }

    /**
     * testAdd_OnlyOnFriday - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumeTrue(boolean) assumeTrue()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the test is skipped.</li>
     * <li>Pass the following numbers as operands to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
	@Test
	@DisplayName("This test is only run on Fridays")
    public void testAdd_OnlyOnFriday() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
    	assertNotNull(classUnderTest);
    	LocalDateTime ldt = LocalDateTime.now();
    	assumeTrue(ldt.getDayOfWeek().getValue() == 5, "Test skipped... it's not Friday!");
        assumeTrue(ldt.getDayOfWeek().getValue() == 5);
        
        long[] operands = { 1, 2, 3, 4, 5 };
        long expectedSum = 15;
        long actualSum = classUnderTest.add(operands);
        assertEquals(expectedSum, actualSum);
      }

    /**
     * testAdd_OnlyOnFriday_WithLambda - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumingThat(boolean, org.junit.jupiter.api.function.Executable)
     * assumingThat()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the test is skipped.</li>
     * <li>Pass the following numbers as operands to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
	@Test
    @DisplayName("This test is only run on Fridays (with lambda)")
    public void testAdd_OnlyOnFriday_WithLambda() {
      assertNotNull(classUnderTest);
      LocalDateTime ldt = LocalDateTime.now();
      assumingThat(ldt.getDayOfWeek().getValue() == 5,
          () -> {
            long[] operands = { 1, 2, 3, 4, 5 };
            long expectedSum = 15;
            long actualSum = classUnderTest.add(operands);
            assertEquals(expectedSum, actualSum);
          });
    }

  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("When using a single operand")
  class JUnit5AppSingleOperandTest {

    /**
     * testAdd_NumbersGt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>1</li>
     * <li>0</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
	  @Test
	    @DisplayName("Numbers > 0")
	    public void testAdd_NumbersGt0() {
	      assertNotNull(classUnderTest);
	      assertAll(
	          () -> {
	            long[] numbersToSum = { 1 };
	            long expectedSum = 1;
	            long actualSum = classUnderTest.add(numbersToSum);
	            assertEquals(expectedSum, actualSum);
	          },
	          () -> {
	            long[] numbersToSum = { 0 };
	            long expectedSum = 0;
	            long actualSum = classUnderTest.add(numbersToSum);
	            assertEquals(expectedSum, actualSum);
	          });
	    }
    /**
     * testAdd_NumbersLt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1</li>
     * <li>-10</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
	  @Test
	    @DisplayName("Numbers < 0")
	    public void testAdd_NumbersLt0() {
	      assertNotNull(classUnderTest);
	      assertAll(
	          () -> {
	            long[] numbersToSum = { -1 };
	            long expectedSum = -1;
	            long actualSum = classUnderTest.add(numbersToSum);
	            assertEquals(expectedSum, actualSum);
	          },
	          () -> {
	            long[] numbersToSum = { -10 };
	            long expectedSum = -10;
	            long actualSum = classUnderTest.add(numbersToSum);
	            assertEquals(expectedSum, actualSum);
	          });
	    }
	  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("When zero operands")
  class JUnit5AppZeroOperandsTest {

    /**
     * testAdd_ZeroOperands_EmptyArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Pass an empty array as operands argument to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * </ol>
     */
	  @Test()
	    @DisplayName("Empty argument")
	    public void testAdd_ZeroOperands_EmptyArgument() {
	      assertNotNull(classUnderTest);
	      long[] numbersToSum = {};
	      assertThrows(IllegalArgumentException.class, () -> classUnderTest.add(numbersToSum));
	    }

    /**
     * testAdd_ZeroOperands_NullArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Pass an empty array as operands argument to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * <li>The test should fail if the message in the exception is not "Operands argument cannot be null".</li>
     * </ol>
     */
	  @Test
	    @DisplayName("Null argument")
	    public void testAdd_ZeroOperands_NullArgument() {
	      assertNotNull(classUnderTest);
	      long[] numbersToSum = null;
	      Throwable expectedException = assertThrows(IllegalArgumentException.class,
	          () -> classUnderTest.add(numbersToSum));
	      assertEquals("Operands argument cannot be null", expectedException.getLocalizedMessage());
	    }

	  }

	}