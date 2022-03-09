/**
 * An interface to encapsulate a single test
 */
public interface Test {

    /**
     * Run this test and return its results.
     * All of the code for a single test is in implementations of this method.
     * @return Whether this test passed or failed
     */
    public TestResult runTest();
}