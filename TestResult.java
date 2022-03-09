/**
 * Tracks the results of a single test.
 * Tests may optionally report some message describing the test or the result.
 * Each test is marked as having passed, failed, or caused an unexpected exception.
 */
public class TestResult {

    // Constants for printing each type of test result
    public static final String PASSED = "PASSED";
    public static final String FAILED = "FAILED";
    public static final String EXCEPTION = "EXCEPTION";
    String type;
    String description;

    public TestResult(String result, String msg){
        type = result;
        description = msg;
    }

    /**
     * Create a TestResult for a passed test.  No message is provided.
     * @return TestResult for a passed test
     */
    public static TestResult createPassedResult() {
        TestResult tResult = new TestResult(PASSED, "");
        return tResult;
    }

    /**
     * Create a TestResult for a passed test. 
     * @param msg Message describing the test result
     * @return TestResult for a passed test
     */
    public static TestResult createPassedResult(String msg) {
        TestResult tResult = new TestResult(PASSED, msg);
        return tResult;
    }

    /**
     * Create a TestResult for a failed test.  No message is provided.
     * @return TestResult for a failed test
     */
    public static TestResult createFailedResult() {
        TestResult tResult = new TestResult(FAILED, "");
        return tResult;
    }

    /**
     * Create a TestResult for a failed test.
     * @param msg Message describing the test result
     * @return TestResult for a failed test
     */
    public static TestResult createFailedResult(String msg) {
        TestResult tResult = new TestResult(FAILED, msg);
        return tResult;
    }

    /**
     * Create a TestResult for a test with an unexpected exception.  No message is provided.
     * @return TestResult for an exception test
     */
    public static TestResult createExceptionResult() {
        TestResult tResult = new TestResult(EXCEPTION, "");
        return tResult;
    }

    /**
     * Create a TestResult for a test with an unexpected exception.  
     * @param msg  Message describing the test result
     * @return TestResult for an exception test
     */
    public static TestResult createExceptionResult(String msg) {
        TestResult tResult = new TestResult(EXCEPTION, msg);
        return tResult;
    }

    /**
     * Test for whether this is a passed test
     * @return true if this is a passed test
     */
    public boolean isPassed() {
        return type.equals(PASSED);
    }

    /**
     * Test for whether this is a failed test
     * @return true if this is a failed test
     */
    public boolean isFailed() {
        return type.equals(FAILED);
    }

    /**
     * Test for whether this is an exception test
     * @return true if this is an exception test
     */
    public boolean isException() {
        return type.equals(EXCEPTION);
    }
}
