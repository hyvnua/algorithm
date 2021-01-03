package week7_Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Vertex_graph {
	private Node[] header;
	private int size;
	
	public Vertex_graph(int size) {
		this.header=new Node[size];
		this.size=size;
		
		for(int i=0; i<size; i++) {
			this.header[i]=null;
		}
	}
	public void add(int i, int k) { //��带 �߰��ϴ� �޼ҵ�
		Node newNodek=new Node(k); //���� ���� ��带 ����
		Node newNodei=new Node(i); //���� ���� ��带 ����
		Node p=header[i]; //������ p 
		Node q=header[k]; //������ q
		if(header[i]==null) { //header[i]�� ������� ����
			header[i]=newNodek; //header[i]�� newNode�� �־���.
		}
		else { //header[i]�� ������� �ʴ� ��쿡��
			while(p.getLink()!=null) { //p.link�� null�� ���� ã�� ���� �ݺ���
				p=p.getLink(); //p�� p.getLink()�� ���ָ鼭 �ݺ�
			} //p.link�� null�� ������ ����
			p.setLink(newNodek); //null���� newNode�� �־��ش�.
		}
		if(header[k]==null) { //header[k]�� ������� ����
			header[k]=newNodei; //header[k]�� newNode�� �־���.
		}
		else { //header[k]�� ������� �ʴ� ��쿡��
			while(q.getLink()!=null) { //q.link�� null�� ������ �ݺ�
				q=q.getLink(); //q�� q.link�� ���ָ鼭 �ݺ�
			}
			q.setLink(newNodei); //null���� newNode�� �־��ش�.
		}
		
	}
	public void delete(int i, int k) { //��带 �����ϴ� �޼ҵ�
		Node p=header[i]; //������ p
		Node q=header[k]; //������ q
		if(header[i]==null || header[k]==null) { //header[i]�� header[k]�� null�� ����
			System.out.println("This is fault delete"); //�ش��ϴ� ���� �����Ƿ� �ش繮 ���
			return; //�Լ� ����
		}
		if(p.getVertex()==k) { //p���� k�� ���� ����
			header[i]=p.getLink(); //header[i]�� p.getLink()�� ����
		}
		else{
			while(p.getLink().getVertex()!=k) { //������� �������� �� ��(p)�� ã�´�
				p=p.getLink(); //p�� p.getLink�� ����
			} //������� �������� �հ��� ã���� ���
			p.setLink(p.getLink().getLink()); //p�� ��ũ�ʵ带 ���ﰪ ���� ���� �����Ѵ�.
		}
		
		if(q.getVertex()==i) { //q���� i�� ���� ����
			header[k]=q.getLink(); //header[k]�� q.getLink()�� ����
		}
		else {
			while(q.getLink().getVertex()!=i) { //������� �������� �� ��(q)�� ã�´�
				q=q.getLink(); //q�� q.getLink�� ����
			} //������� �������� �� ���� ã���� ���
			q.setLink(q.getLink().getLink()); //q�� ��ũ�ʵ带 ���� �� ���� ���� �����Ѵ�.
		}
	}
	public void show() {
		if(this.size==0) {
			System.out.println("No Vertex");
		}
		for(int i=0; i<size; i++) {
			Node temp=header[i];
			
			System.out.print(i+" : ");
			
			while(temp!=null) {
				System.out.print(temp.getVertex()+" ");
				temp=temp.getLink();
			}
			System.out.println();
		}
	}
	public void DFS(int i) { // ���� �켱 Ž�� (���� ���)
		boolean[] visit=new boolean[header.length]; //�湮 �ߴ��� ����
		int j;
		
		for(j=0; j<header.length; j++) {
			visit[j]=false; //�湮���� �ʾ��� false�� ����
		}
		
		Stack<Integer> stack=new Stack<Integer>(); //���� ����
		stack.push(i); //���ÿ� i�� ����
		
		while(!stack.isEmpty()) { //������ ����� ������ �ݺ�
			j=stack.pop(); //stack�� pop�ؼ� j�� ����
			Node node=header[j]; //node�� ����
			
			if(visit[j]==false) { //j�� �湮���� �ʾҴٸ� 
				System.out.print(j+" "); //j ���
				visit[j]=true; //j�� true�� �ٲ�
				while(node!=null) { //�ش� ��尡 null�� �ƴ� ������ �ݺ�
					if(visit[node.getVertex()]==false) //node�� ���� �湮���� �ʾҴٸ�
						stack.push(node.getVertex()); //stack�� ��� ���� �־���
					node=node.getLink(); //node�� �� ���� ���� �ٲ�
				}
			}
		}
	}
	public void BFS(int i) { // �ʺ� �켱 Ž�� (ť ���)
		boolean[] visit=new boolean[header.length]; //�湮 �ߴ��� ����
		int idx;
		
		for(int j=0; j<header.length; j++) {
			visit[j]=false; //�湮���� �ʾ��� false�� ����
		}
		
		Queue<Integer> queue =new LinkedList<Integer>(); //ť ����
		queue.add(i); //ť�� i�� ����
		while(!queue.isEmpty()) { //ť�� ����� ������ �ݺ�
			idx=queue.remove(); //queue�� pop�ؼ� idx�� ����
			Node node=header[idx]; //node�� ����
			
			if(visit[idx]==false) { //idx�� �湮���� �ʾҴٸ�
				System.out.print(idx+" "); //idx���
				visit[idx]=true; //idx�� true�� �ٲ�
			}
			while(node!=null) { //�ش� ��尡 null�� �ƴ� ������ �ݺ�
				if(visit[node.getVertex()]==false) //����� ���� �湮���� �ʾҴٸ�
					queue.add(node.getVertex()); //ť�� node�� ����
				node=node.getLink(); //��带 �� ���� ���� �ٲ�
			}
		}
	}
}
