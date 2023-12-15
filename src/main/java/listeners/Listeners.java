package listeners;


import annotations.FrameworkAnnotations;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentLogger;
import reports.ExtentReport;
import utils.ELKUtils;

import java.util.Arrays;

public class Listeners implements ITestListener, ISuiteListener
{
    @Override
    public void onStart(ISuite suite)
    {
       ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite)
    {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).Author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).Category());
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        ExtentLogger.pass(result.getMethod().getMethodName() + " testcase is passed", true);
        ELKUtils.SendResultsToELK(result.getMethod().getMethodName(),"pass");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        ExtentLogger.fail(result.getMethod().getMethodName() + " testcase is failed",true);
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        ELKUtils.SendResultsToELK(result.getMethod().getMethodName(),"fail");

    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        ExtentLogger.skip(result.getMethod().getMethodName() + " testcase is skipped",true);
        ELKUtils.SendResultsToELK(result.getMethod().getMethodName(),"skip");

    }
 }
