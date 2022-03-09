import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportHtml implements TestReporter{
    File htmlFile;

    public ReportHtml(String filename){
        htmlFile = new  File(filename);
    }

    public void generateHtml(List<TestResult> passed, List<TestResult> failed, List<TestResult> exception) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
        bw.write("<!DOCTYPE html>\n<head>\n<title>Tae's Testing Frame with Results and Description</title></head><body><p>Tests results with the descriptions</p></body>");
        bw.write("<body><p>&nbsp</p></body>\n");
        bw.write("<body><p>&nbsp</p></body>\n");
        bw.write("<body><p>PASSED TESTS</p></body>\n");
        bw.write("<body><p>Result&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDescription</p></body>\n");
        for (int i =0; i < passed.size(); i++){
            bw.write("<body><p>" + passed.get(i).type + "&nbsp" + "&nbsp" +  "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" +  "&nbsp" + "&nbsp" + passed.get(i).description + "</p></body>" + "\n");
        }
        bw.write("<body><p>&nbsp</p></body>\n");
        bw.write("<body><p>&nbsp</p></body>\n");
        bw.write("<body><p>FAILED TESTS</p></body>\n");
        bw.write("<body><p>Result&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDescription</p></body>\n");
        for (int i =0; i < failed.size(); i++){
            bw.write("<body><p>" + failed.get(i).type + "&nbsp" + "&nbsp"  + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" +  "&nbsp" + "&nbsp" + failed.get(i).description + "</p></body>" + "\n");
        }
        bw.write("<body><p>&nbsp</p></body>\n");
        bw.write("<body><p>&nbsp</p></body>\n");
        bw.write("<body><p>EXCEPTION TESTS</p></body>\n");
        bw.write("<body><p>Result&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDescription</p></body>\n");
        for (int i =0; i < exception.size(); i++){
            bw.write("<body><p>" + exception.get(i).type + "&nbsp" + "&nbsp"  + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" +  "&nbsp" + "&nbsp" + exception.get(i).description + "</p></body>" + "\n");
        }
        bw.write("</html>");
        bw.close();
    }
}

