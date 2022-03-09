/**
 * Generates an HTML report of the test results.  The report is divided into three
 * sections: passed, failed, and exception.
 */
import java.io.IOException;
import java.util.List;

public interface TestReporter {
    
    /**
     * Generate a report in HTML format and write it to an HTML file.
     * @param passed A list of test results of the passed tests
     * @param failed A list of test results of the failed tests
     * @param exception A list of test results of the exception tests
     * @throws IOException
     */
    public void generateHtml(List<TestResult> passed, 
                             List<TestResult> failed, 
                             List<TestResult> exception) throws IOException;
}
