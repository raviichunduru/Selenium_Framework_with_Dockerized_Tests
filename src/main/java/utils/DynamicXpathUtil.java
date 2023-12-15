package utils;

public final class DynamicXpathUtil
{
    private DynamicXpathUtil() {};

    // this method will accept a xpath string, replace some string and return new
    public static String getXpath(String originalString, String replaceWith)
    {
        return originalString.replace("%s%",replaceWith);
        //return String.format(originalString,replaceWith);
    }

}
