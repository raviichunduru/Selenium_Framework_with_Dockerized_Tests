package utils;

import constants.FrameworkConstants;
import exceptions.FrameworkExceptions;
import exceptions.InvalidPathForExcelFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils
{
    private ExcelUtils() {}

    public static List<Map<String,String>> getTestDetails(String sheetName)
    {
        List<Map<String, String>> list = null;

        try(FileInputStream fis = new FileInputStream((FrameworkConstants.getExcelPath())))
        {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();

            Map<String, String> map = null;
            list = new ArrayList<>();

            for (int i = 1; i <= rowCount; i++)
            {
                map = new HashMap<>();
                for (int j = 0; j < columnCount; j++)
                {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        }
        catch (FileNotFoundException e)
        {
            throw new InvalidPathForExcelFile("Test Data excel file mentioned is not found");
        }
        catch (IOException e)
        {
            throw new FrameworkExceptions("Error while reading data from test data file");
        }
        return list;
    }
}
