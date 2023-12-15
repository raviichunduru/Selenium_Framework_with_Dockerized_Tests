package listeners;

import enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer
{
    private  int count = 0;
    private  int retryCount = 1;

    @Override
    public boolean retry(ITestResult result)
    {
        boolean value=false;

        if(PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
        {
            value = count < retryCount;
            count++;
        }
        return value;
    }
}
