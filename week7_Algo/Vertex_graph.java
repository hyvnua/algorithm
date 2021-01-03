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
	public void add(int i, int k) { //노드를 추가하는 메소드
		Node newNodek=new Node(k); //새로 넣을 노드를 생성
		Node newNodei=new Node(i); //새로 넣을 노드를 생성
		Node p=header[i]; //포인터 p 
		Node q=header[k]; //포인터 q
		if(header[i]==null) { //header[i]가 비어있을 때는
			header[i]=newNodek; //header[i]에 newNode를 넣어줌.
		}
		else { //header[i]가 비어있지 않는 경우에는
			while(p.getLink()!=null) { //p.link가 null일 때를 찾기 위해 반복문
				p=p.getLink(); //p에 p.getLink()를 해주면서 반복
			} //p.link가 null을 만나면 종료
			p.setLink(newNodek); //null값에 newNode를 넣어준다.
		}
		if(header[k]==null) { //header[k]가 비어있을 때는
			header[k]=newNodei; //header[k]에 newNode를 넣어줌.
		}
		else { //header[k]가 비어있지 않는 경우에는
			while(q.getLink()!=null) { //q.link가 null일 때까지 반복
				q=q.getLink(); //q에 q.link를 해주면서 반복
			}
			q.setLink(newNodei); //null값에 newNode를 넣어준다.
		}
		
	}
	public void delete(int i, int k) { //노드를 삭제하는 메소드
		Node p=header[i]; //포인터 p
		Node q=header[k]; //포인터 q
		if(header[i]==null || header[k]==null) { //header[i]나 header[k]가 null일 때는
			System.out.println("This is fault delete"); //해당하는 값이 없으므로 해당문 출력
			return; //함수 종료
		}
		if(p.getVertex()==k) { //p값이 k와 같을 때는
			header[i]=p.getLink(); //header[i]에 p.getLink()를 넣음
		}
		else{
			while(p.getLink().getVertex()!=k) { //지우려는 데이터의 앞 값(p)을 찾는다
				p=p.getLink(); //p에 p.getLink를 넣음
			} //지우려는 데이터의 앞값을 찾았을 경우
			p.setLink(p.getLink().getLink()); //p의 링크필드를 지울값 뒤의 노드로 연결한다.
		}
		
		if(q.getVertex()==i) { //q값이 i와 같을 때는
			header[k]=q.getLink(); //header[k]에 q.getLink()를 넣음
		}
		else {
			while(q.getLink().getVertex()!=i) { //지우려는 데이터의 앞 값(q)을 찾는다
				q=q.getLink(); //q에 q.getLink를 넣음
			} //지우려는 데이터의 앞 값을 찾았을 경우
			q.setLink(q.getLink().getLink()); //q의 링크필드를 지울 값 뒤의 노드로 연결한다.
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
	public void DFS(int i) { // 깊이 우선 탐색 (스택 사용)
		boolean[] visit=new boolean[header.length]; //방문 했는지 여부
		int j;
		
		for(j=0; j<header.length; j++) {
			visit[j]=false; //방문하지 않았음 false로 설정
		}
		
		Stack<Integer> stack=new Stack<Integer>(); //스택 생성
		stack.push(i); //스택에 i를 넣음
		
		while(!stack.isEmpty()) { //스택이 비었을 때까지 반복
			j=stack.pop(); //stack을 pop해서 j에 넣음
			Node node=header[j]; //node값 설정
			
			if(visit[j]==false) { //j가 방문하지 않았다면 
				System.out.print(j+" "); //j 출력
				visit[j]=true; //j를 true로 바꿈
				while(node!=null) { //해당 노드가 null이 아닐 때까지 반복
					if(visit[node.getVertex()]==false) //node의 값에 방문하지 않았다면
						stack.push(node.getVertex()); //stack에 노드 값이 넣어줌
					node=node.getLink(); //node를 그 다음 노드로 바꿈
				}
			}
		}
	}
	public void BFS(int i) { // 너비 우선 탐색 (큐 사용)
		boolean[] visit=new boolean[header.length]; //방문 했는지 여부
		int idx;
		
		for(int j=0; j<header.length; j++) {
			visit[j]=false; //방문하지 않았음 false로 설정
		}
		
		Queue<Integer> queue =new LinkedList<Integer>(); //큐 생성
		queue.add(i); //큐에 i를 넣음
		while(!queue.isEmpty()) { //큐가 비었을 때까지 반복
			idx=queue.remove(); //queue를 pop해서 idx에 넣음
			Node node=header[idx]; //node값 설정
			
			if(visit[idx]==false) { //idx에 방문하지 않았다면
				System.out.print(idx+" "); //idx출력
				visit[idx]=true; //idx를 true로 바꿈
			}
			while(node!=null) { //해당 노드가 null이 아닐 때까지 반복
				if(visit[node.getVertex()]==false) //노드의 값에 방문하지 않았다면
					queue.add(node.getVertex()); //큐에 node를 넣음
				node=node.getLink(); //노드를 그 다음 노드로 바꿈
			}
		}
	}
}
