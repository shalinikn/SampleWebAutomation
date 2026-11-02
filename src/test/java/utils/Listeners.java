package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    ExtentTest test;

    ExtentReports extent = CreateExtentReports.getReportObject();
    @Override
    public void onTestStart(ITestResult result)
    {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS ,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test.fail(iTestResult.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context)
    {
        extent.flush();
    }

}
