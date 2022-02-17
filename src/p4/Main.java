package p4;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		DirectedGraph<Vertex> dg = new DirectedGraph<Vertex>();
		Vertex classA = new Vertex("ClassA");
		Vertex classB = new Vertex("ClassB");
		Vertex classC = new Vertex("ClassC");
		Vertex classD = new Vertex("ClassD");
		Vertex classE = new Vertex("ClassE");
		Vertex classF = new Vertex("ClassF");
		Vertex classG = new Vertex("ClassG");
		Vertex classH = new Vertex("ClassH");
		Vertex classI = new Vertex("ClassI");
		Vertex classJ = new Vertex("ClassJ");

		dg.addVertex(classA);
		dg.addVertex(classB);
		dg.addVertex(classC);
		dg.addVertex(classD);
		dg.addVertex(classE);
		dg.addVertex(classF);
		dg.addVertex(classG);
		dg.addVertex(classH);
		dg.addVertex(classI);
		dg.addVertex(classJ);

		int classA_Index = dg.getIndex(classA);
		int classB_Index = dg.getIndex(classB);
		int classC_Index = dg.getIndex(classC);
		int classD_Index = dg.getIndex(classD);
		int classE_Index = dg.getIndex(classE);
		int classF_Index = dg.getIndex(classF);
		int classG_Index = dg.getIndex(classG);
		int classH_Index = dg.getIndex(classH);
		int classI_Index = dg.getIndex(classI);
		int classJ_Index = dg.getIndex(classJ);

		// ClassA
		dg.addEdge(classA_Index, classC_Index);
		dg.addEdge(classA_Index, classE_Index);
		dg.addEdge(classA_Index, classJ_Index);

		// ClassB
		dg.addEdge(classB_Index, classD_Index);
		dg.addEdge(classB_Index, classG_Index);

		// ClassC
		dg.addEdge(classC_Index, classA_Index);

		// ClassE
		dg.addEdge(classE_Index, classB_Index);
		dg.addEdge(classE_Index, classF_Index);
		dg.addEdge(classE_Index, classH_Index);

		// ClassJ
		dg.addEdge(classJ_Index, classB_Index);

		// ClassJ
		dg.addEdge(classI_Index, classC_Index);

		// DFS 
		dg.depthFirst();

		// print parenthesizedList
		String parenthesizedList = dg.getParenthesizedList().toString();
		System.out.println("Parenthesized List Representation:\n");
		System.out.println(parenthesizedList+"\n");

		// print hierarchy
		String hierarchy = dg.getHierarchy().toString();
		System.out.println("Hierarchy Representation:\n");
		System.out.println(hierarchy+"\n");

		System.out.println("Unreachable Classes:\n");
		List<Vertex> urc = dg.unreachableClasses();
		for(Vertex v : urc) {
			System.out.println(v.toString());
		}
	}

}