
import java.util.Stack;

public class Test2 {

	static String input;

	static class Node {
		Character data;
		Node left;
		Node right;
	}

	public static int countChars(String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if (currChar == c)
				count += 1;
		}
		return count;
	}

	static int findClosing(String expression, int index) {
		int i;

		if (expression.charAt(index) != '(') {

			return -1;
		}

		Stack<Integer> st = new Stack<>();

		for (i = index; i < expression.length(); i++) {

			if (expression.charAt(i) == '(') {
				st.push((int) expression.charAt(i));
			} else if (expression.charAt(i) == ')') {
				st.pop();
				if (st.empty()) {
					return i;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		input = "(1(2(4(8)(9))(5(a)(b)))(3(6)(7)))";

		System.out.println("--------------------------------------------------");
		System.out.println("Original String: " + input);


		int closing = findClosing(input, 2);
		String root = input.substring(1, 2);
		String left = input.substring(2, closing + 1);
		String right = input.substring(closing + 1, input.length() - 1);
		System.out.println("--------------------------------------------------");
		System.out.println("Root Node: " + root);
		System.out.println("Left Tree: " + left);
		System.out.println("Right Tree: " + right);
		System.out.println("--------------------------------------------------");

		closing = findClosing(left, 2);
		String left_left = left.substring(2, closing + 1);
		String left_right = left.substring(closing + 1, left.length() - 1);
		System.out.println("Left Tree Node: " + left.substring(1, 2));
		System.out.println("Left: " + left_left);
		System.out.println("Right: " + left_right);

		closing = findClosing(left_left, 2);
		String left_left_left = left_left.substring(2, closing + 1);
		String left_left_right = left_left.substring(closing + 1, left_left.length() - 1);
		System.out.println("Left Tree Node - Left Node: " + left_left.substring(1, 2));
		System.out.println("Left: " + left_left_left);
		System.out.println("Right: " + left_left_right);

		closing = findClosing(left_right, 2);
		String right_left_left = left_right.substring(2, closing + 1);
		String right_left_right = left_right.substring(closing + 1, left_right.length() - 1);
		System.out.println("Left Tree Node - Right Node: " + left_right.substring(1, 2));
		System.out.println("Left: " + right_left_left);
		System.out.println("Right: " + right_left_right);

		System.out.println("--------------------------------------------------");
		closing = findClosing(right, 2);
		String right_left = right.substring(2, closing + 1);
		String right_right = right.substring(closing + 1, right.length() - 1);
		System.out.println("Right Tree Node: " + right.substring(1, 2));
		System.out.println("Left: " + right_left);
		System.out.println("Right: " + right_right);
		System.out.println("--------------------------------------------------");
	}

}
