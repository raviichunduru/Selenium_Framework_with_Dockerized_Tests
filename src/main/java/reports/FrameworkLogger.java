// This class is to demonstrate use of java 8 concepts in writing simple code
// we used ExtentLogger to log user actions into extent reports

package reports;

import enums.LogType;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public final class FrameworkLogger
{
    private FrameworkLogger() {}
    private static Consumer<String> PASS = (message)->ExtentManager.getExtent().pass(message);
    private static Consumer<String> FAIL = (message)->ExtentManager.getExtent().fail(message);
    private static Consumer<String> SKIP = (message)->ExtentManager.getExtent().skip(message);
    private static Consumer<String> INFO = (message)->ExtentManager.getExtent().info(message);
    private static Consumer<String> CONSOLE = (message)-> System.out.println(message);


    private static Map<LogType,Consumer<String>> MAP = new HashMap<>();

    static
    {
        MAP.put(LogType.PASS,PASS);
        MAP.put(LogType.FAIL,FAIL);
        MAP.put(LogType.SKIP,SKIP);
        MAP.put(LogType.INFO,INFO);
        MAP.put(LogType.CONSOLE,CONSOLE);
    }

    public static void log(LogType status, String message)
    {
        MAP.get(status).accept(message);
    }
}
