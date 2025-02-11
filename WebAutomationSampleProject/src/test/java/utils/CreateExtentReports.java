package utils;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import java.io.File;

public class CreateExtentReports {

    private static final ExtentReports extentReports = new ExtentReports();

    public static ExtentReports getReportObject() {
        // Ensure the report directory exists
        String path = System.getProperty("user.dir") + ".//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Sample Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "SW Test Academy");
        extentReports.setSystemInfo("Author", "Onur Baskirt");
        return extentReports;
    }
}
