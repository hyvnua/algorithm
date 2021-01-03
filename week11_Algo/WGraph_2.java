package week11_Algo;

public class WGraph_2 { //이행적 폐쇄, 가중치 없는 방향 그래프
	private int vertex_size;
	private boolean[][] matrix; //경로가 존재하는지
	
	public WGraph_2(int vertex_size) {
		this.matrix=new boolean[vertex_size][vertex_size]; //배열 생성
		this.vertex_size=vertex_size; //배열 크기
		
		for(int i=0; i<this.vertex_size; i++) {
			for(int j=0; j<this.vertex_size; j++) {
				matrix[i][j]=false; //배열 false로 초기화
			}
		}
	}
	
	public void insertEdge(int i, int j) {
		if(!matrix[i][j]) { //배열이 false일 경우 
			matrix[i][j]=true; //배열을 true로 바꿔줌
		}
	}
	
	public void allShortestPath() {
		boolean[][] dist= new boolean[vertex_size][vertex_size]; //경로 배열 
		int i, j, k;
		for(i=0; i<vertex_size; i++) {
			for(j=0; j<vertex_size; j++) {
				dist[i][j]=matrix[i][j]; //배열 복사
			}
		}
		for(k=0; k<vertex_size; k++) {
			for(i=0; i<vertex_size; i++) {
				for(j=0; j<vertex_size; j++) {
					if(dist[i][k]&&dist[k][j]) //둘 다 true일 때
						dist[i][j]=true; //dist[i][j] true
				}
			}
		}
		System.out.println("============ D+ ============"); //이행적 폐쇄 행렬 (D+)
		
		for(i=0; i<vertex_size; i++) {
			for(j=0; j<vertex_size; j++) {
				System.out.printf("[ %5b ]",dist[i][j]); //D+ 결과 출력
			}
			System.out.println();
		}
		
		for(k=0; k<vertex_size; k++) {
			for(i=0; i<vertex_size; i++) {
				for(j=0; j<vertex_size; j++) {
					if(dist[i][k]|| dist[k][j]) //둘 중 하나만 true라도
						dist[i][i]=true; //dist[i][i] 자기 자신 true
				}
			}
		}
		System.out.println("============ D* ============"); //반사 이행적 폐쇄 행렬 (D*), 자기자신은 항상 true
		
		for(i=0; i<vertex_size; i++) {
			for(j=0; j<vertex_size; j++) {
				System.out.printf("[ %5b ]",dist[i][j]); //D* 결과 출력
			}
			System.out.println();
		}
	}
	
	public void print() { //배열 값 출력
		for(int i=0; i<vertex_size; i++) {
			for(int j=0; j<vertex_size; j++) {
				System.out.printf("[ %5b ]", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
