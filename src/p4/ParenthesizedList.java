package p4;

import java.util.LinkedList;
import java.util.Queue;

class ParenthesizedList implements DFSActions {

	Queue<String> queue = new LinkedList<>();

	@Override
	public void processVertex(Vertex vertex) {
		queue.add(vertex.toString());
	}

	@Override
	public void descend() {
		queue.add("(");
	}

	@Override
	public void ascend() {
		queue.add(")");
	}

	@Override
	public void cycleDetected() {
		queue.add("*");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("( ");
		while (queue.size() > 0) {
			String c = queue.peek(); // save String
			queue.remove(); // remove ClassA
			if (c.equals("(")) { // if its a (
				assert queue.peek() != null;
				if (queue.peek().equals(")")) {
					queue.remove();
					continue;
				} else if (queue.peek().equals("*")) {
					sb.append(queue.peek()).append(" ");
					queue.remove();
					queue.remove();
					continue;
				}
			}
			sb.append(c).append(" ");
		}

		sb.append(")\n");

		return sb.toString();

	}
}
