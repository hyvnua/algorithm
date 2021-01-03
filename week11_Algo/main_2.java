package week11_Algo;

public class main_2 {
	public static void main(String[] args) {
		WGraph_2 graph=new WGraph_2(4);
		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(1, 2);
		graph.insertEdge(2, 3);
		graph.insertEdge(2, 1);
		graph.insertEdge(2, 3);
		
		System.out.println("Print Graph");
		graph.print();
		
		System.out.println("Transitive Closure");
		graph.allShortestPath();
		
	}
}
