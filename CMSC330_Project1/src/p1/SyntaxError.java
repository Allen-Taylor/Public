package p1;
class SyntaxError extends Exception
{
	private static final long serialVersionUID = 1L;

	public SyntaxError(int line, String description)
    {
        super("Line: " + line + " " + description);
    }
}