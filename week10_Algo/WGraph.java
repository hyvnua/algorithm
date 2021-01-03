package week10_Algo;

public class WGraph{
	private int vertex_size;
	private int[][] weights;
	
	public WGraph(int vertex_size) {
		this.weights=new int[vertex_size][vertex_size]; //����ġ �迭
		this.vertex_size=vertex_size; //���� ũ��
		for(int i=0; i<this.vertex_size; i++) { //����ġ �ʱ�ȭ
			for(int j=0; j<this.vertex_size; j++) {
				if(i==j) weights[i][j]=0; //i�� j�� ���� ��� ����ġ 0
				else weights[i][j]=999; //�� �ܴ� ����ġ 999
			}
		}
	}
	public void insertEdge(int i, int k, int w) { //edge ���� �޼ҵ�
		if(weights[i][k]==999) { //����ġ�� 999�� �����Ǿ��ִ� ��쿡
			weights[i][k]=w; //�Ű������� ���� ����ġ�� �ٲ���
		}
	}
	
	public void print() { //��� �޼ҵ�
		for(int i=0; i<vertex_size; i++) {
			for(int j=0; j<vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]);
			}
			System.out.println();
		}
	}
	
	public void shortestPath(int v) { //Dijkstra �˰���
		boolean[] s=new boolean[vertex_size]; //�ִ� ��ΰ� �߰ߵ� �������� ����
		int[] dist=new int[vertex_size]; //�ִ� ����� ����
		
		for(int i=0; i<vertex_size; i++) { //s�� dist�� �ʱ�ȭ
			s[i]=false;
			dist[i]=weights[v][i];
		}
		
		s[v]=true; //�Ű������� �Է¹��� v�� true�� �ٲ���
		dist[v]=0; //ù ���� v�� �ִܰ�� 0
		
		for(int i=0; i<vertex_size-2; i++) { //i�� vertex_size-2���� ���������� �ݺ�
			int u=i+1;
			for(int j=0; j<vertex_size; j++) { //���ο� �ִ� ��� ����
				if(dist[u]>dist[j]&&s[j]==false) { //j�� u���� �����鼭 j�� false�� ���
					u=j; //u�� j�� �־���
				}
			}
			s[u]=true; //u�� �������� true�� �ٲ�
			for(int w=0; w<vertex_size; w++) { //dist�� �ٽ� ����
				if(s[w]==false) {
					if(dist[w]>dist[u]+weights[u][w]) { //���� w���� ���ο� u�� �Ÿ�+u,w�� ����ġ�� ���� ���
						dist[w]=dist[u]+weights[u][w]; //�ٲ���
					}
				}
			}
			
			System.out.printf("==== STAGE %d ====",(i+1));
			System.out.println("\nselect vertex : "+u);
			
			for(int k=0; k<vertex_size; k++) {
				System.out.print(dist[k]+" "); //�ִܰ���� ����
			}
			System.out.println();
		}
		System.out.println();
	}
}