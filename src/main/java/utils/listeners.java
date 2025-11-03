package utils;

import BaseClass.baseClass;
import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners extends baseClass implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance(); // ✅ Use your ExtentManager
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((baseClass) testClass).getDriver();

        test.get().log(Status.PASS, "✅ Test Passed: " + result.getName());
        String path = screenShort.takeScreenshot(driver, result.getName() + "_PASS");
        test.get().addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((baseClass) testClass).getDriver();

        test.get().log(Status.FAIL, "❌ Test Failed: " + result.getThrowable());
        String path = screenShort.takeScreenshot(driver, result.getName() + "_FAIL");
        test.get().addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "⚠️ Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("🧪 Test Execution Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // ✅ Generates the ExtentReport.html
        System.out.println("📄 Extent Report generated successfully!");
    }
}