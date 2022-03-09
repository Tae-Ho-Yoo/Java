import java.io.IOException;

/**
 * The TestController is the interface describing the essential flow for managing a test suite.
 */
public interface TestController {
    
    /**
     * Add the given test to the test suite.  
     * @param test Test to be added
     * @param rank Ordering for when to run the test
     */
    public void addTest(Test test, double rank);

    /**
     * Run all tests in the test suite and collect the results.
     * The results are not returned but stored internally.
     */
    public void runTests();

    /**
     * Create a report of all the results of the tests that have been run.
     * @throws IOException
     */
    public void createReport() throws IOException;
}
