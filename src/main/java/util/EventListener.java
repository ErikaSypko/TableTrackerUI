package util;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class EventListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test Case " + iTestResult.getName() + " is PASSED");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error("Test Case " + iTestResult.getName() + " is FAILED");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info(iTestContext.getName() + " is STARTED");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}