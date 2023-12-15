package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import enums.ConfigProperties;
import utils.PropertyUtils;

import static utils.ScreenshotUtils.getBase64Image;

public final class ExtentLogger
{
    private ExtentLogger(){}

    private static void pass(String value)
    {
        ExtentManager.getExtent().pass(value);
    }

    public static void fail(String value)
    {
        ExtentManager.getExtent().fail(value);
    }

    private static void skip(String value)
    {
        ExtentManager.getExtent().skip(value);
    }


    public static void pass(String value,boolean isScreenshotNeeded)
    {
        if (PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded)
        {
            ExtentManager.getExtent().pass(value, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
        else pass(value);
    }

    public static void fail(String value,boolean isScreenshotNeeded)
    {
        if (PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded)
        {
            ExtentManager.getExtent().fail(value, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
        else fail(value);
    }

    public static void skip(String value,boolean isScreenshotNeeded)
    {
        if (PropertyUtils.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded)
        {
            ExtentManager.getExtent().skip(value, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
        else skip(value);
    }

    /*public static void testPass(String value,boolean isScreenshotNeeded)
    {
        if (PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded)
        {
            ExtentManager.getExtent().pass((Throwable) MarkupHelper.createLabel(value, ExtentColor.GREEN),MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
        else pass(value);
    }

    public static void testFail(String value,boolean isScreenshotNeeded)
    {
        if (PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded)
        {
            ExtentManager.getExtent().fail((Throwable) MarkupHelper.createLabel(value, ExtentColor.RED),MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
        else pass(value);
    }*/
}
