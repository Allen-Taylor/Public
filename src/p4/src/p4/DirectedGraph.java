package p4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DirectedGraph<V> {

	Set<V> dfsDiscovered = new HashSet<>();
	Set<V> dfsVisited = new HashSet<>();

	private List<V> vertices = new ArrayList<V>();
	private List<LinkedList<Integer>> edges = new ArrayList<LinkedList<Integer>>();

	boolean cycle;
	
	ParenthesizedList parenthesizedList = new ParenthesizedList();
	Hierarchy hierarchy = new Hierarchy();
	
	public V getVertex(int i) {
		return vertices.get(i);
	}

	public int getIndex(V v) {
		return vertices.indexOf(v);
	}

	public List<V> getVertices() {
		return vertices;
	}

	public List<Integer> getEdge(int i) {
		return edges.get(i);
	}

	public List<LinkedList<Integer>> getEdges() {
		return edges;
	}

	public ParenthesizedList getParenthesizedList() {
		return parenthesizedList;
	}
	
	public Hierarchy getHierarchy() {
		return hierarchy;
	}

	public Set<V> getDfsVisited() {
		return dfsVisited;
	}

	public int getSize() {
		return vertices.size();
	}

	public void addVertex(V vertex) {
		vertices.add(vertex);
		edges.add(new LinkedList<>());
	}

	public void addEdge(int left, int right) {
		edges.get(left).add(right);
	}

	public void depthFirst() {
		cycle = false;
		dfs(getVertex(0));
	}

	private void dfs(V v) {
		if (dfsDiscovered.contains(v)) {
			cycle = true;
			
			parenthesizedList.cycleDetected();
			hierarchy.cycleDetected();
			
			return;
		}
		
		parenthesizedList.processVertex((Vertex) v);
		hierarchy.processVertex((Vertex) v);
		
		parenthesizedList.descend();
		hierarchy.descend();
		
		dfsVisited.add(v);
		dfsDiscovered.add(v);
		
		LinkedList<Integer> list = getEdges().get(getIndex(v));

		if (list != null) {
			for (Integer i : list)
				dfs(getVertex(i));
		}
		
		parenthesizedList.ascend();
		hierarchy.ascend();
		
		dfsDiscovered.remove(v);
	}



	public List<V> unreachableClasses() {
		Set<V> discovered = getDfsVisited();
		List<V> verts = getVertices();
		verts.removeAll(discovered);
		return verts;

	}

}