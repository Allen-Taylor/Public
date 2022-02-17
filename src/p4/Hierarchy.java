package p4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hierarchy implements DFSActions {

	String str = new String();
	String hierarchyString = new String();

	@Override
	public void processVertex(Vertex vertex) {
		str = str.concat(vertex.toString() + " ");

	}

	@Override
	public void descend() {
		str = str.concat("( ");
	}

	@Override
	public void ascend() {
		str = str.concat(") ");
	}

	@Override
	public void cycleDetected() {
		str = str.concat("* ");
	}

	@Override
	public String toString() {
		// String Formatting
		str = str.replace("( * )", "*").replace("( ) ", "");
		String onlyClasses = str.replace("( ", "").replace(") ", "");
		String[] classes = onlyClasses.split("\s");
		List<String> classList = new ArrayList<String>(Arrays.asList(classes));

		// List of indentation size for each Class
		ArrayList<Integer> spaces = new ArrayList<Integer>();

		// Split all String tokens into ArrayList
		String[] arr = str.split("\s");
		List<String> allStrTokens = new ArrayList<String>(Arrays.asList(arr));

		// Format * character
		for (int i = 0; i < classList.size(); i++) {
			if (classList.get(i).equals("*")) {
				classList.set(i - 1, classList.get(i - 1) + " *");
				classList.remove(i);
			}
		}

		// Populate the list of indents for each Class
		int count = 0;
		for (String s : allStrTokens) {
			if (s.equals("(")) {
				count = count + 4;
			} else if (s.equals(")")) {
				count = count - 4;
			} else if (s.equals("*")) {
				continue;
			} else {
				spaces.add(count);
			}
		}

		// Add indents to each Class
		for (int i = 0; i < classList.size(); i++) {
			Integer s = spaces.get(i);
			hierarchyString = hierarchyString + indentation(s) + classList.get(i) + "\n";
		}
		return hierarchyString;
	}

	private static String indentation(int size) {
		StringBuilder builder = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			builder.append(' ');
		}
		return builder.toString();
	}

}
