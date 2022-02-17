package p4;

class ParenthesizedList implements DFSActions {

	String str = new String();

	@Override
	public void processVertex(Vertex vertex) {
		str = str.concat(vertex.toString()+" ");
	
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

	
	public void printStr() {

	}

	@Override
	public String toString() {
		str = "( "+str+ ")";
		str = str.replace("( * )", "*").replace("( ) ", "");
		return str;

	}
}
