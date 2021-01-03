package week12_Algo;
import java.util.*;

public class Graph {
	private Queue<Integer>[] Q; //���� i�� �����ļ��ڸ� �����ϴ� ť
	private Queue<Integer> ZeroPredQ; //�����ڰ� ���� �������� �����ϴ� ť
	private LinkedList<Integer> sortedList; //���� ���� ����� �����ϴ� ����Ʈ
	
	private int[] indegree; //���� i�� ��������
	private int n; //���� ��  
	
	public Graph(int vertex) { //Graph�� ������
		n=vertex; //���� ���� �Ű������� ���� vertex�� �ʱ�ȭ
		Q=new Queue[n]; //ť Q �迭 ����
		ZeroPredQ=new LinkedList<Integer>(); //ZeroPredQ ���Ḯ��Ʈ ����
		sortedList=new LinkedList<Integer>(); //sortedList ���Ḯ��Ʈ ����
		
		for(int i=0; i<n; i++) {
			Q[i]=new LinkedList<Integer>(); //�� Q[i]�� ���� �ʱ�ȭ
		}
		indegree=new int[n]; //�������� �迭 ����
	}
	
	public void insertEdge(int head, int tail) { //��������Ʈ�� ť �迭�� ǥ��
		Q[head].add(tail); //Q�� head�� tail�� �߰����ش�.
		indegree[tail]++; //�����ڼ��� �÷��ش�
		
	}
	public void topologicalSort() { //��������
		int i,v, successor;
		for(i=0; i<n; i++) {
			if(indegree[i]==0) //�����ڰ� ���� ���
				ZeroPredQ.add(i); //ZeroPredQ�� ����
		}
		if(ZeroPredQ.isEmpty()) { //����Ŭ�� ���� ���
			System.out.println("network has a cycle");
			return;
		}
		while(!ZeroPredQ.isEmpty()) { //ZeroPredQ�� ������� ���� ���
			v=ZeroPredQ.remove(); //ť���� �ϳ� ������ v�� �ִ´�. v(indegree�� 0�� ����)
			sortedList.add(v); //sortedList�� v�� �ִ´�.
			if(Q[v].isEmpty()) continue; //���� v�� �ļ��ڰ� ������ ���� while������ 
			else successor=Q[v].remove(); //�ļ��ڰ� ������, �� �ļ��ڸ� successor�� ����
			while(true) { 
				indegree[successor]--; //v�� �ļ��� ������ ���������� ���ҽ�Ŵ
				if(indegree[successor]==0) //�ļ��� ������ ���������� 0�� �Ǹ�
					ZeroPredQ.add(successor); //ZeroPredQ�� ����
				if(!Q[v].isEmpty()) successor=Q[v].remove(); //Q[v]�� ������� ������ succsessor�� Q�� ���� ������ ����
				else break; //����ִٸ� ���ѷ��� Ż��
			}
		}
		System.out.println("Topological Order is : ");
		while(!sortedList.isEmpty()) //sortedList�� ������� ���� ������
			System.out.print(sortedList.remove()+" "); //sortedList���� ���� �����ذ��� ���
		System.out.println();
		System.out.println("End.");
	}
	
}
