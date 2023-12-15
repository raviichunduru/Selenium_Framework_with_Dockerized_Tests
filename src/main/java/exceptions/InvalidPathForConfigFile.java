package exceptions;

public class InvalidPathForConfigFile extends InvalidPathForFileException
{
    public InvalidPathForConfigFile(String message)
    {
        super(message);
    }

    public InvalidPathForConfigFile(String message, Throwable cause)
    {
        super(message, cause);
    }
}
