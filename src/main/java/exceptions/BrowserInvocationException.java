package exceptions;

public class BrowserInvocationException extends FrameworkExceptions
{
    public BrowserInvocationException(String message)
    {
        super(message);
    }

    public BrowserInvocationException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
