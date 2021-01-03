package week11_Algo;

public class WGraph_2 { //������ ���, ����ġ ���� ���� �׷���
	private int vertex_size;
	private boolean[][] matrix; //��ΰ� �����ϴ���
	
	public WGraph_2(int vertex_size) {
		this.matrix=new boolean[vertex_size][vertex_size]; //�迭 ����
		this.vertex_size=vertex_size; //�迭 ũ��
		
		for(int i=0; i<this.vertex_size; i++) {
			for(int j=0; j<this.vertex_size; j++) {
				matrix[i][j]=false; //�迭 false�� �ʱ�ȭ
			}
		}
	}
	
	public void insertEdge(int i, int j) {
		if(!matrix[i][j]) { //�迭�� false�� ��� 
			matrix[i][j]=true; //�迭�� true�� �ٲ���
		}
	}
	
	public void allShortestPath() {
		boolean[][] dist= new boolean[vertex_size][vertex_size]; //��� �迭 
		int i, j, k;
		for(i=0; i<vertex_size; i++) {
			for(j=0; j<vertex_size; j++) {
				dist[i][j]=matrix[i][j]; //�迭 ����
			}
		}
		for(k=0; k<vertex_size; k++) {
			for(i=0; i<vertex_size; i++) {
				for(j=0; j<vertex_size; j++) {
					if(dist[i][k]&&dist[k][j]) //�� �� true�� ��
						dist[i][j]=true; //dist[i][j] true
				}
			}
		}
		System.out.println("============ D+ ============"); //������ ��� ��� (D+)
		
		for(i=0; i<vertex_size; i++) {
			for(j=0; j<vertex_size; j++) {
				System.out.printf("[ %5b ]",dist[i][j]); //D+ ��� ���
			}
			System.out.println();
		}
		
		for(k=0; k<vertex_size; k++) {
			for(i=0; i<vertex_size; i++) {
				for(j=0; j<vertex_size; j++) {
					if(dist[i][k]|| dist[k][j]) //�� �� �ϳ��� true��
						dist[i][i]=true; //dist[i][i] �ڱ� �ڽ� true
				}
			}
		}
		System.out.println("============ D* ============"); //�ݻ� ������ ��� ��� (D*), �ڱ��ڽ��� �׻� true
		
		for(i=0; i<vertex_size; i++) {
			for(j=0; j<vertex_size; j++) {
				System.out.printf("[ %5b ]",dist[i][j]); //D* ��� ���
			}
			System.out.println();
		}
	}
	
	public void print() { //�迭 �� ���
		for(int i=0; i<vertex_size; i++) {
			for(int j=0; j<vertex_size; j++) {
				System.out.printf("[ %5b ]", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
