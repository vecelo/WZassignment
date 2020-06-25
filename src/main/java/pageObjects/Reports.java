package pageObjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
    static ExtentReports exte;

    public static ExtentReports getReportObj(){
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter repo = new ExtentSparkReporter(path);
        repo.config().setReportName("Assignment Automation Results");
        repo.config().setDocumentTitle("Test Report");
        exte = new ExtentReports();
        exte.attachReporter(repo);
//        exte.setSystemInfo("Hung Trinh");
        return exte;
    }
}
