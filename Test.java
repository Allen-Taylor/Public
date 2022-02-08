
import java.util.ArrayList;

public class Test {

	static ArrayList<Node> nodeList = new ArrayList<>();
	static String input;
	static Node root;
	
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

	public static void findAndStrip() {
		// create nodes
		Node node = new Node();
		Node left_child = new Node();
		Node right_child = new Node();

		char ch[] = input.toCharArray(); // create char arr
		Character parent = null; // parent char
		Character left = null; // left child char
		Character right = null; // right child char
		
		if(input.length() == 6) {
			left_child.data = ch[1];
			right_child.data = ch[4];
			node = root;
			node.left = left_child;
			node.right = right_child;
			nodeList.add(node);
			input = "";
			
		} else {
			
			for (int i = 0; i < input.length(); i++) {
				if (ch[i] == '(' && ch[i + 2] == ')') { // find inner most child
					if (i == 0) {
						//pass because all left nodes are found 
					} else {
						parent = ch[i - 1]; // this is parent node to the left
						left = ch[i + 1]; // this is left child
						if (ch[i + 3] == '(' && ch[i + 5] == ')') { // check for right child
							right = ch[i + 4]; // this is the right child
							System.out.println("Trim: " + ch[i] + ch[i + 1] + ch[i + 2] + ch[i + 3] + ch[i + 4] + ch[i + 5]);
							input = input.replace("" + ch[i] + ch[i + 1] + ch[i + 2] + ch[i + 3] + ch[i + 4] + ch[i + 5], ""); // erase from input string
						} else {
							right = ' '; // no right child
							System.out.println("" + ch[i] + ch[i + 1] + ch[i + 2]);
							input = input.replace("Trim: " + ch[i] + ch[i + 1] + ch[i + 2], ""); // erase from input string
						}

						
						// add data
						node.data = parent;
						left_child.data = left;
						right_child.data = right;

						// add children to new node
						node.left = left_child;
						node.right = right_child;

						// add to list
						nodeList.add(node);
						break; // break out 
					}
				}
			}
			
		}
		
		


	}

	public static void clearRoot() {
		input =  input.substring(1);
	}

	public static void stripBothParenthesis() {
		input = input.substring(1);
		input = input.substring(0, input.length() - 1);
	
	}

	public static void main(String[] args) {

		input = "(1(2(4(8)(9))(5))(3(6)(7)))";


		int spaceCount = countChars(input, ' '); // no spaces

		if (spaceCount == 0) {
			System.out.println("Spaces Check: Valid");
		} else {
			System.out.println("Spaces Check: Invalid");
		}

		int numOfNodes = countChars(input, '(');
		int leftParCount = countChars(input, '(');
		int rightParCount = countChars(input, ')');

		if (leftParCount == rightParCount) {
			System.out.println("Parenthesis Check: Valid");
		} else {
			System.out.println("Parenthesis Check: Invalid");
		}
		
		System.out.println("Nodes: " + numOfNodes);
		
		Node root_node = new Node();
		root_node.data = input.charAt(1); // root node
		root = root_node; // assign to global var 
		stripBothParenthesis(); // clear parenthesis on outside
		clearRoot(); // delete root node from string 
		
		
		while(input.length() != 0) {
			System.out.println(input);
			findAndStrip();
		}
		
		System.out.println("\n");
		for(Node n : nodeList) {
		System.out.println(n.data + " " + n.left.data + " " + n.right.data);
		 }

	}

}
