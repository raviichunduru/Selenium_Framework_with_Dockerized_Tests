package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import constants.FrameworkConstants;
import enums.BrowserType;
import enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport() {
    }

    private static ExtentReports extentreports;
    private static ExtentTest extenttest;

    public static void initReports() {
        if (Objects.isNull(extentreports)) {
            extentreports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtent_Report_File_Path())
                                            .viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY,ViewName.AUTHOR,ViewName.DEVICE})
                                            .apply();
            extentreports.attachReporter(spark);

            //use below only if you are configuring extent report using xml or json

            //final File CONF = new File("extent_config.xml");
            //try {spark.loadXMLConfig(CONF);} catch (IOException e) {throw new RuntimeException(e);}

            //final File CONF = new File("extent_config.json");
            //try {spark.loadJSONConfig(CONF);} catch (IOException e) {throw new RuntimeException(e);}

            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Regression Report");
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extentreports)) {
            extentreports.flush();
        }
        ExtentManager.unLoad();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtent_Report_File_Path()).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTest(String testcasename) {
        extenttest = extentreports.createTest(testcasename);
        ExtentManager.setExtent(extenttest);
    }

    public static void addAuthors(String[] authors) {
        for (String s : authors) {
            ExtentManager.getExtent().assignAuthor(s);
        }
    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType ct : categories) {
            ExtentManager.getExtent().assignCategory(ct.toString());
        }
    }

    public static void addBrowsers(BrowserType[] browsers)
    {
        for (BrowserType b : browsers)
        {
            ExtentManager.getExtent().assignDevice(b.toString());
        }
    }
}
