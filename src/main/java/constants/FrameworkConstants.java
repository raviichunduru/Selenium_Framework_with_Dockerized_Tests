package constants;

import enums.ConfigProperties;
import utils.PropertyUtils;

public class FrameworkConstants
{
    private FrameworkConstants() {}

    private final static String RESOURCE_PATH = System.getProperty("user.dir")+"/src/test/resources";
    private final static String CONFIG_FILE_PATH =  RESOURCE_PATH+"/config/config.properties";
    private final static String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir")+"/extent-output/";
    private static String extent_report_file_path = "";
    private final static String EXCEL_PATH = RESOURCE_PATH+"/excel/testdata.xlsx";
    private final static String RUN_MANAGER_SHEET = "RUNMANAGER";
    private final static String DATA_SHEET = "DATA";
    private final static int EXPLICIT_WAIT_TIMEOUT = 10;

    public static String getExcelPath()
    {
        return EXCEL_PATH;
    }

    public static String getConfigFilePath()
    {
        return CONFIG_FILE_PATH;
    }

    public static int getExplicitWaitTimeout()
    {
        return EXPLICIT_WAIT_TIMEOUT;
    }

    public static String getExtent_Report_File_Path()
    {
        if (extent_report_file_path.isEmpty())
        {
            extent_report_file_path=createReportPath();
        }
        return  extent_report_file_path;
    }

    private static String createReportPath()
    {
        if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
        {
            return EXTENT_REPORT_FOLDER_PATH+System.currentTimeMillis()+"/Index.html";
        }
        else return EXTENT_REPORT_FOLDER_PATH+"/Index.html";
    }

    public static String getRunManagerSheet()
    {
        return RUN_MANAGER_SHEET;
    }

    public static String getDataSheet()
    {
        return DATA_SHEET;
    }

}

