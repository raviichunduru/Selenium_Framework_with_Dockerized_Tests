package exceptions;

public class InvalidPathForExcelFile extends InvalidPathForFileException
{
    public InvalidPathForExcelFile(String message)
    {
        super(message);
    }

    public InvalidPathForExcelFile(String message, Throwable cause)
    {
        super(message, cause);
    }
}
