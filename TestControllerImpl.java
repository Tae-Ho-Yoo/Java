import java.io.IOException;
import java.util.ArrayList;

public class TestControllerImpl implements TestController{
    MinPriorityQueue tQueue = new MinPriorityQueue();
    ArrayList<TestResult> pass = new ArrayList<TestResult>();
    ArrayList<TestResult> failed = new ArrayList<TestResult>();
    ArrayList<TestResult> exception = new ArrayList<TestResult>();
    String nameFile;

    public TestControllerImpl(String filename){
        nameFile = filename;
    }

    @Override
    public void addTest(Test test, double rank) {
        tQueue.enqueue(rank, test);
    }
    
    @Override
    public void runTests() {
        while (tQueue.items.size() >= 1){
            try{
                PriQueueNode currNode = (PriQueueNode)tQueue.dequeue();
                TestResult tResult = ((Test)currNode.data).runTest();
                if (tResult.isPassed()){
                    pass.add(tResult);
                } else if (tResult.isFailed()){
                    failed.add(tResult);
                }
            } catch (Exception e){
                exception.add(TestResult.createExceptionResult(e.getMessage()));
            }
        }
    }

    @Override
    public void createReport() throws IOException {
        TestReporter report = new ReportHtml(nameFile);
        report.generateHtml(pass, failed, exception);
    }
}

