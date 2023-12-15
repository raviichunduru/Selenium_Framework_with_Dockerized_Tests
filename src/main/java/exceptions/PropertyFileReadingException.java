package exceptions;

public class PropertyFileReadingException extends FrameworkExceptions
{
    public PropertyFileReadingException(String message)
    {
        super(message);
    }

    public PropertyFileReadingException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
