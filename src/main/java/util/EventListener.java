package util;

import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.service.ReportPortal;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Date;

@Slf4j
public class EventListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test Case " + iTestResult.getName() + " is PASSED");
        ReportPortal.emitLog("Test PASSED", LogLevel.INFO.name(), new Date());


    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error("Test Case " + iTestResult.getName() + " is FAILED");
        ReportPortal.emitLog("Test FAILED", LogLevel.ERROR.name(), new Date());
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
        ReportPortal.emitLog("Test STARTED", LogLevel.INFO.name(), new Date());

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}