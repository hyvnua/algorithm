package week12_Algo;

public class Main {
	public static void main(String[] args) {
		Graph AOV=new Graph(6);
		
		AOV.insertEdge(0, 1);
		AOV.insertEdge(0, 2);
		
		AOV.insertEdge(1, 3);
		AOV.insertEdge(1, 4);
		
		AOV.insertEdge(2, 3);
		AOV.insertEdge(2, 4);
		
		AOV.insertEdge(3, 5);
		
		AOV.insertEdge(4, 5);
		
		AOV.topologicalSort();
	}
}
