package week11_Algo;

public class WGraph {
	private int vertex_size;
	private int[][] weights;
	
	public WGraph(int vertex_size) {
		this.weights=new int[vertex_size][vertex_size]; //가중치 배열
		this.vertex_size=vertex_size; //배열 크기
		
		for(int i=0; i<this.vertex_size; i++) { //배열 초기화
			for(int j=0; j<this.vertex_size; j++) {
				if(i==j) weights[i][j]=0; // i와 j가 같을 때 가중치 0
				else weights[i][j]=999; //그렇지 않으면 0으로 초기화 
			}
		}
	}
	public void insertEdge(int i, int j, int w) {
		if(weights[i][j]==999) { //가중치가 999로 설정되어있을 경우에
			weights[i][j]=w; //매개변수로 들어온 가중치로 바꿔줌
		}
	}
	public void BellmanFord(int v) { //Bellman and Ford 알고리즘
		int[] dist=new int[vertex_size]; //최단 경로
		
		for(int i=0; i<vertex_size; i++) {
			dist[i]=weights[v][i]; //Dist를 초기화
		}
		for(int k=2; k<vertex_size; k++) { //Disk^k k를 계속해서 바꿔감
			for(int u=0; u<vertex_size; u++) {
				if(u!=v) { //u가 v가 아닐 때
					for(int i=0; i<vertex_size; i++) { //i는 u의 선행자
						if(weights[i][u]!=0||weights[i][u]!=999) { //i, u의 간선의 가중치가 0이 아니고 999가 아닐 때 
							if(dist[u]>dist[i]+weights[i][u]) { //dist[u]가 dist[i]+weights[i][u]보다 크면 (거리 다시 계산)
								dist[u]=dist[i]+weights[i][u]; //dist[u]에 dist[i]+weights[i][u]를 넣음 (최단 거리)
							}
						}
					}
				}
			}
		}
		System.out.println("\n===== Best PATH ======");
		for(int i=0; i<vertex_size; i++) { //최단 경로를 출력
			System.out.print(dist[i]+" ");
		}
		System.out.println();
	}
	
	public void allShortestPath() { //모든 정점 쌍의 최단 경로
		int [][]dist = new int[vertex_size][vertex_size];
		int i,j,k;
		
		for(i=0; i<vertex_size; i++) {
			for(j=0; j<vertex_size; j++) {
				dist[i][j]=weights[i][j]; //가중치 인접 행렬 복사
			}
		}
		
		for(k=0; k<vertex_size; k++) { //D^k 0~k-1까지 구함,, 중간 정점으로 0에서 k까지 사용하는 경로
			System.out.printf("Stage : %d\n", k);
			for(i=0; i<vertex_size; i++) { //모든 가능한 시작점
				for(j=0; j<vertex_size; j++) { //모든 가능한 종점
					if(dist[i][j]>(dist[i][k]+dist[k][j])) { //보다 짧은 경로가 발견되었는지를 검사
						dist[i][j]=dist[i][k]+dist[k][j]; //k를 거쳐가는 것으로 변경해줌
					}
					System.out.printf("[ %3d ]",dist[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public void print() { // 가중치 인접 행렬 출력
		for(int i=0; i<vertex_size; i++) {
			for(int j=0; j<vertex_size; j++) {
				System.out.printf("[ %3d ]",weights[i][j]);
			}
			System.out.println();
		}
	}
}
