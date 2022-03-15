package p1;
import java.io.*;

class Lexer
{
    private static final int KEYWORDS = 11;
    private StreamTokenizer tokenizer;
    private String punctuation = ",:;.()";
    private Token[] punctuationTokens =
    {
        Token.COMMA, Token.COLON, Token.SEMICOLON, Token.PERIOD, Token.LEFT_PAREN, Token.RIGHT_PAREN
    };

    public Lexer(String fileName) throws FileNotFoundException
    {
        tokenizer = new StreamTokenizer(new FileReader(fileName));
        tokenizer.ordinaryChar('.');
        tokenizer.quoteChar('"');
    }

    public Token getNextToken() throws SyntaxError, IOException
    {
        int token = tokenizer.nextToken();
        switch (token)
        {
            case StreamTokenizer.TT_NUMBER:
                return Token.NUMBER;
            case StreamTokenizer.TT_WORD:
                for (Token aToken : Token.values())
                {
                    if (aToken.ordinal() == KEYWORDS)
                        break;
                    if (aToken.name().equals(tokenizer.sval.toUpperCase()))
                        return aToken;
                }
                throw new SyntaxError(lineNo(), "Invalid token " + getStrValue());
            case StreamTokenizer.TT_EOF:
                return Token.EOF;
            case '"':
                return Token.STRING;
            default:
                for (int i = 0; i < punctuation.length(); i++)
                    if (token == punctuation.charAt(i))
                        return punctuationTokens[i];
        }
        return Token.EOF;
    }
 
    public String getStrValue()
    {
        return tokenizer.sval;
    }

    public double getNumValue()
    {
        return tokenizer.nval;
    }

    public int lineNo()
    {
        return tokenizer.lineno();
    }
}
