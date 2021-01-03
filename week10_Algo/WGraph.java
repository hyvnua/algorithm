package week10_Algo;

public class WGraph{
	private int vertex_size;
	private int[][] weights;
	
	public WGraph(int vertex_size) {
		this.weights=new int[vertex_size][vertex_size]; //가중치 배열
		this.vertex_size=vertex_size; //간선 크기
		for(int i=0; i<this.vertex_size; i++) { //가중치 초기화
			for(int j=0; j<this.vertex_size; j++) {
				if(i==j) weights[i][j]=0; //i와 j가 같은 경우 가중치 0
				else weights[i][j]=999; //그 외는 가중치 999
			}
		}
	}
	public void insertEdge(int i, int k, int w) { //edge 삽입 메소드
		if(weights[i][k]==999) { //가중치가 999로 설정되어있는 경우에
			weights[i][k]=w; //매개변수로 들어온 가중치로 바꿔줌
		}
	}
	
	public void print() { //출력 메소드
		for(int i=0; i<vertex_size; i++) {
			for(int j=0; j<vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]);
			}
			System.out.println();
		}
	}
	
	public void shortestPath(int v) { //Dijkstra 알고리즘
		boolean[] s=new boolean[vertex_size]; //최단 경로가 발견된 정점들의 집합
		int[] dist=new int[vertex_size]; //최단 경로의 길이
		
		for(int i=0; i<vertex_size; i++) { //s와 dist를 초기화
			s[i]=false;
			dist[i]=weights[v][i];
		}
		
		s[v]=true; //매개변수로 입력받은 v를 true로 바꿔줌
		dist[v]=0; //첫 시작 v의 최단경로 0
		
		for(int i=0; i<vertex_size-2; i++) { //i가 vertex_size-2보다 작을때까지 반복
			int u=i+1;
			for(int j=0; j<vertex_size; j++) { //새로운 최단 경로 선정
				if(dist[u]>dist[j]&&s[j]==false) { //j가 u보다 작으면서 j가 false인 경우
					u=j; //u에 j를 넣어줌
				}
			}
			s[u]=true; //u가 정해지면 true로 바꿈
			for(int w=0; w<vertex_size; w++) { //dist를 다시 구함
				if(s[w]==false) {
					if(dist[w]>dist[u]+weights[u][w]) { //이전 w보다 새로운 u의 거리+u,w의 가중치가 작은 경우
						dist[w]=dist[u]+weights[u][w]; //바꿔줌
					}
				}
			}
			
			System.out.printf("==== STAGE %d ====",(i+1));
			System.out.println("\nselect vertex : "+u);
			
			for(int k=0; k<vertex_size; k++) {
				System.out.print(dist[k]+" "); //최단경로의 길이
			}
			System.out.println();
		}
		System.out.println();
	}
}