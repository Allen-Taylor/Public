package p1;

import java.io.IOException;
import java.util.Stack;

public class Recursive_Decent {
	
	private static Stack<GUI_Token> readFile(String fileLocation) throws SyntaxError, IOException{
		Stack<GUI_Token> gtStack = new Stack<GUI_Token>();
		Lexer lexer = new Lexer(fileLocation);
		while (true) {
			Token token = lexer.getNextToken();
			String tokenStr = lexer.getStrValue();
			Double tokenNum = lexer.getNumValue();
			gtStack.add(new GUI_Token(token, tokenStr, tokenNum));
			if (token == Token.EOF)
				break;
		}
		return gtStack;
	}
	
	public static void main(String[] args) throws SyntaxError, IOException{
		//"./src/input.txt"
		Stack<GUI_Token> gtStack = readFile("./src/input.txt");
		System.out.println(gtStack);
		
	}

}
