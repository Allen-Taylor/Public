package p4;

import java.util.ArrayList;
import java.util.List;

public class Main {


	public static void main(String[] args) {
		DirectedGraph<Vertex> dg = new DirectedGraph<Vertex>();
		Vertex classA = new Vertex("ClassA");
		Vertex classB = new Vertex("ClassB");
		Vertex classC = new Vertex("ClassC");
		dg.addVertex(classA);
		dg.addVertex(classB);
		dg.addVertex(classC);
		int classA_Index = dg.getIndex(classA);
		int classB_Index = dg.getIndex(classB);
		int classC_Index = dg.getIndex(classC);
		
		dg.addEdge(classA_Index, classB_Index);
		dg.addEdge(classA_Index, classC_Index);
		
		dg.addEdge(classB_Index, classA_Index);
		dg.addEdge(classB_Index, classC_Index);
		
		dg.addEdge(classC_Index, classA_Index);
		
		ArrayList<Vertex> dfs = dg.depthFirst(0);
		
		for(Vertex v : dfs) {
			int index = dg.getIndex(v);
			for(Integer i : dg.getNeighbors(index)) {
				System.out.println(v + " -> "+dg.getVertex(i));
			}

		}
		
		
		
	}

}
