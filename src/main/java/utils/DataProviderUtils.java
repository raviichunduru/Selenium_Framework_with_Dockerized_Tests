package utils;

import constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils
{
    private DataProviderUtils() {}

    private static List<Map<String, String>> totalList = new ArrayList<>();

    @DataProvider(parallel=true)
    public static Object[] getData(Method method)
    {
        String testCaseName = method.getName();

        if (totalList.isEmpty())
        {
            totalList = ExcelUtils.getTestDetails(FrameworkConstants.getDataSheet());
        }

        List<Map<String, String>> filteredList = new ArrayList<>();

        for (int i = 0; i < totalList.size(); i++)
        {
            if (totalList.get(i).get("testcase").equalsIgnoreCase(testCaseName)
                    && totalList.get(i).get("execute").equalsIgnoreCase("yes"))
            {
                filteredList.add(totalList.get(i));
            }
        }
      return filteredList.toArray();
    }
}