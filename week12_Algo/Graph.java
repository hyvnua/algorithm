package week12_Algo;
import java.util.*;

public class Graph {
	private Queue<Integer>[] Q; //정점 i의 직속후속자를 저장하는 큐
	private Queue<Integer> ZeroPredQ; //선행자가 없는 정점들을 저장하는 큐
	private LinkedList<Integer> sortedList; //위상 정렬 결과를 보관하는 리스트
	
	private int[] indegree; //정점 i의 진입차수
	private int n; //정점 수  
	
	public Graph(int vertex) { //Graph의 생성자
		n=vertex; //정점 수를 매개변수로 받은 vertex로 초기화
		Q=new Queue[n]; //큐 Q 배열 생성
		ZeroPredQ=new LinkedList<Integer>(); //ZeroPredQ 연결리스트 생성
		sortedList=new LinkedList<Integer>(); //sortedList 연결리스트 생성
		
		for(int i=0; i<n; i++) {
			Q[i]=new LinkedList<Integer>(); //각 Q[i]에 대해 초기화
		}
		indegree=new int[n]; //진입차수 배열 생성
	}
	
	public void insertEdge(int head, int tail) { //인접리스트를 큐 배열로 표현
		Q[head].add(tail); //Q에 head에 tail을 추가해준다.
		indegree[tail]++; //선행자수를 늘려준다
		
	}
	public void topologicalSort() { //위상정렬
		int i,v, successor;
		for(i=0; i<n; i++) {
			if(indegree[i]==0) //선행자가 없을 경우
				ZeroPredQ.add(i); //ZeroPredQ에 넣음
		}
		if(ZeroPredQ.isEmpty()) { //사이클이 있을 경우
			System.out.println("network has a cycle");
			return;
		}
		while(!ZeroPredQ.isEmpty()) { //ZeroPredQ가 비어있지 않을 경우
			v=ZeroPredQ.remove(); //큐에서 하나 제거해 v에 넣는다. v(indegree가 0인 정점)
			sortedList.add(v); //sortedList에 v를 넣는다.
			if(Q[v].isEmpty()) continue; //정점 v의 후속자가 없으면 밖의 while루프로 
			else successor=Q[v].remove(); //후속자가 있으면, 그 후속자를 successor로 설정
			while(true) { 
				indegree[successor]--; //v의 후속자 정점의 진입차수를 감소시킴
				if(indegree[successor]==0) //후속자 정점의 진입차수가 0이 되면
					ZeroPredQ.add(successor); //ZeroPredQ에 삽입
				if(!Q[v].isEmpty()) successor=Q[v].remove(); //Q[v]가 비어있지 않으면 succsessor에 Q의 값을 제거해 넣음
				else break; //비어있다면 무한루프 탈출
			}
		}
		System.out.println("Topological Order is : ");
		while(!sortedList.isEmpty()) //sortedList가 비어있지 않을 때까지
			System.out.print(sortedList.remove()+" "); //sortedList에서 값을 삭제해가며 출력
		System.out.println();
		System.out.println("End.");
	}
	
}
