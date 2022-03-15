package p1;

public class GUI_Token {
	Token token;
	String strValue;
	Double numValue;

	/**
	 * @param token
	 * @param strValue
	 * @param numValue
	 */
	public GUI_Token(Token token, String strValue, Double numValue) {
		this.token = token;
		this.strValue = strValue;
		this.numValue = numValue;
	}

	public Token getToken() {
		return token;
	}

	public String getStrValue() {
		return strValue;
	}

	public Double getNumValue() {
		return numValue;
	}

	@Override
	public String toString() {
		return token.toString();
	}
}