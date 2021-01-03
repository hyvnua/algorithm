package week11_Algo;

public class WGraph {
	private int vertex_size;
	private int[][] weights;
	
	public WGraph(int vertex_size) {
		this.weights=new int[vertex_size][vertex_size]; //����ġ �迭
		this.vertex_size=vertex_size; //�迭 ũ��
		
		for(int i=0; i<this.vertex_size; i++) { //�迭 �ʱ�ȭ
			for(int j=0; j<this.vertex_size; j++) {
				if(i==j) weights[i][j]=0; // i�� j�� ���� �� ����ġ 0
				else weights[i][j]=999; //�׷��� ������ 0���� �ʱ�ȭ 
			}
		}
	}
	public void insertEdge(int i, int j, int w) {
		if(weights[i][j]==999) { //����ġ�� 999�� �����Ǿ����� ��쿡
			weights[i][j]=w; //�Ű������� ���� ����ġ�� �ٲ���
		}
	}
	public void BellmanFord(int v) { //Bellman and Ford �˰���
		int[] dist=new int[vertex_size]; //�ִ� ���
		
		for(int i=0; i<vertex_size; i++) {
			dist[i]=weights[v][i]; //Dist�� �ʱ�ȭ
		}
		for(int k=2; k<vertex_size; k++) { //Disk^k k�� ����ؼ� �ٲ㰨
			for(int u=0; u<vertex_size; u++) {
				if(u!=v) { //u�� v�� �ƴ� ��
					for(int i=0; i<vertex_size; i++) { //i�� u�� ������
						if(weights[i][u]!=0||weights[i][u]!=999) { //i, u�� ������ ����ġ�� 0�� �ƴϰ� 999�� �ƴ� �� 
							if(dist[u]>dist[i]+weights[i][u]) { //dist[u]�� dist[i]+weights[i][u]���� ũ�� (�Ÿ� �ٽ� ���)
								dist[u]=dist[i]+weights[i][u]; //dist[u]�� dist[i]+weights[i][u]�� ���� (�ִ� �Ÿ�)
							}
						}
					}
				}
			}
		}
		System.out.println("\n===== Best PATH ======");
		for(int i=0; i<vertex_size; i++) { //�ִ� ��θ� ���
			System.out.print(dist[i]+" ");
		}
		System.out.println();
	}
	
	public void allShortestPath() { //��� ���� ���� �ִ� ���
		int [][]dist = new int[vertex_size][vertex_size];
		int i,j,k;
		
		for(i=0; i<vertex_size; i++) {
			for(j=0; j<vertex_size; j++) {
				dist[i][j]=weights[i][j]; //����ġ ���� ��� ����
			}
		}
		
		for(k=0; k<vertex_size; k++) { //D^k 0~k-1���� ����,, �߰� �������� 0���� k���� ����ϴ� ���
			System.out.printf("Stage : %d\n", k);
			for(i=0; i<vertex_size; i++) { //��� ������ ������
				for(j=0; j<vertex_size; j++) { //��� ������ ����
					if(dist[i][j]>(dist[i][k]+dist[k][j])) { //���� ª�� ��ΰ� �߰ߵǾ������� �˻�
						dist[i][j]=dist[i][k]+dist[k][j]; //k�� ���İ��� ������ ��������
					}
					System.out.printf("[ %3d ]",dist[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public void print() { // ����ġ ���� ��� ���
		for(int i=0; i<vertex_size; i++) {
			for(int j=0; j<vertex_size; j++) {
				System.out.printf("[ %3d ]",weights[i][j]);
			}
			System.out.println();
		}
	}
}
