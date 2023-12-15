package utils;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import exceptions.PropertyFileReadingException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils
{
    private PropertyUtils() {}
    private static final Properties properties = new Properties();
    private static final Map<String,String> CONFIGMAP = new HashMap<>();

    static
    {
        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath()))
        {
            properties.load(fis);
            properties.entrySet().forEach(entry->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));
            /*for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); //remove the trailing and leading spaces
            }
*/
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String getValue(ConfigProperties key)
    {
      if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
          {
             throw new PropertyFileReadingException ("Property Name " +key +" Or value associated with it is not available in config file");
          }
      return CONFIGMAP.get(key.name().toLowerCase());
    }
}