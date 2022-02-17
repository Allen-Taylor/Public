package p4;

import java.util.ArrayList;

public class Hierarchy implements DFSActions {

	String hierarchyString = new String();
	int count = 0;
	ArrayList<Integer> indentList = new ArrayList<Integer>();
	ArrayList<String> classList = new ArrayList<String>();

	@Override
	public void processVertex(Vertex vertex) {
		indentList.add(count);
		classList.add(vertex.toString());

	}

	@Override
	public void descend() {
		count = count + 4;
	}

	@Override
	public void ascend() {
		count = count - 4;
	}

	@Override
	public void cycleDetected() {

		classList.set(classList.size() - 1, classList.get(classList.size() - 1) + " *");
	}

	@Override
	public String toString() {

		for (int i = 0; i < classList.size(); i++) {
			Integer indent = indentList.get(i);
			hierarchyString = hierarchyString + indentation(indent) + classList.get(i) + "\n";
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
