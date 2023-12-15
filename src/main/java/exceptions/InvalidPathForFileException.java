package exceptions;

public class InvalidPathForFileException extends FrameworkExceptions
{
    public InvalidPathForFileException(String message)
    {
        super(message);
    }

    public InvalidPathForFileException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
