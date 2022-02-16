package p4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DirectedGraph<V> {

	private enum Marks {UNDISCOVERED, DISCOVERED}; 
	private List<V> vertices = new ArrayList<V>();
	private List<LinkedList<Integer>> edges = new ArrayList<LinkedList<Integer>>();
	private Marks[] marks;
	private boolean cycle;

	public V getVertex(int i)
	{
		return vertices.get(i);
	}

	public int getIndex(Vertex vertex)
	{
		return vertices.indexOf(vertex);
	}

	public List<V> getVertices()
	{
		return vertices;
	}

	public List<Integer> getEdges(int i)
	{
		return edges.get(i);
	}

	public int getSize()
	{
		return vertices.size();
	}

	public void addVertex(V vertex)
	{
		vertices.add(vertex);
		edges.add(new LinkedList<>());
	}

	public void addEdge(int left, int right)
	{
		edges.get(left).add(right);
	}

	public ArrayList<V> depthFirst(int start)
	{
		ArrayList<V> list = new ArrayList<V>();
		marks = new Marks[getSize()];
		for (int i = 0; i < marks.length; i++)
			marks[i] = Marks.UNDISCOVERED;
		cycle = false;
		dfs(start, start, list);
		return list;
	}
	
	private void dfs(int previous, int current, ArrayList<V> list)
	{
		if (marks[current] == Marks.DISCOVERED)  //if s is discovered
		{
			cycle = true; //perform cycle detected action
			return; //return
		}
		list.add(vertices.get(current)); //perform add vertex action
		//perform descend action ????????????
		marks[current] = Marks.DISCOVERED; //mark s as discovered
		for (int next = 0; next < getSize(); next++) //for all adjacent vertices v
			if (next != previous && edges.get(current).contains(next)) 
				dfs(current, next, list); //depth_first_search(v)
		 //perform ascend action ?????????????
		 //mark s as finished ????????????????
	}

	public boolean isConnected()
	{
		depthFirst(0);
		for (Marks mark : marks)
			if (mark == Marks.UNDISCOVERED)
				return false;
		return true;
	}

	boolean hasCycles()
	{
		for (int vertex = 0; vertex < getSize(); vertex++)
		{
			depthFirst(vertex);
			if (cycle)
				return true;
		}
		return false;
	}
	}