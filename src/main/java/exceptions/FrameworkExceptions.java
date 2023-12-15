package exceptions;

public class FrameworkExceptions extends RuntimeException
{
    public FrameworkExceptions(String message)
    {
        super(message);
    }

    public FrameworkExceptions(String message,Throwable cause)
    {
        super(message, cause);
    }





}
