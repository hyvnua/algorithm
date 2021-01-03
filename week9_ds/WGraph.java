package week9_ds;

public class WGraph {
	private int vertex_size; //�迭�� ������
	private int e; //������ ����
	private int[][] weights; //����ġ �迭 ����
	
	public WGraph(int vertex_size) { //�Ű������� ���� ��ŭ�� ����ġ �׷��� ����
		this.weights=new int[vertex_size][vertex_size]; //����ġ �迭 ����
		this.vertex_size=vertex_size; //�׷����� ũ�� = �Է¹��� sizeũ��
		e=0; //������ ������ 0
		for(int i=0; i<this.vertex_size; i++) { //�ݺ����� ������
			for(int j=0; j<this.vertex_size; j++) {
				if(i==j) weights[i][j]=0; //[0][0],[1][1],... ���� ���� 0���� �ʱ�ȭ
				else weights[i][j]=-1; //�� �ܴ� -1�� �ʱ�ȭ
			}
		}
	}
	public void insertEdge(int i, int k, int w) { //������ �߰��ϴ� �޼ҵ�
		if(weights[i][k]==-1 && weights[k][i]==-1) { //����ġ ���� -1�� �� ��, ���Ե� ���� ���� ��쿡
			weights[i][k]=w; // �Ű������� ���� ����ġ ���� �־���
			weights[k][i]=w; // �Ű������� ���� ����ġ ���� �־���(������׷���)
			e++; //������ �� ����
		}
	}
	public void print() { //����ϴ� �޼ҵ�
		for(int i=0; i<vertex_size; i++) {
			for(int j=0; j<vertex_size; j++) {
				System.out.printf("[ %3d ]",weights[i][j]); //����ġ ���� ���
			}
			System.out.println();
		}
	}
	
	public Edge[] kruskal() { //ũ�罺Į �˰���
		Edge[] T =new Edge[(vertex_size-1)]; //����(����) T�� ����
		MinHeap edgeList=new MinHeap(); //�ּ��� edgeList ����
		
		//������� ����(����ġ�� -1)���� ���� ��쿡 edgeList(minheap)�� Edge�� �߰�
		for(int i=0; i<vertex_size; i++) { 
			for(int j=i+1; j<vertex_size; j++) {
				if(weights[i][j]!=-1) { //������� �ʴ� ��쿡
					Edge item=new Edge(i,j,weights[i][j]); // �ش� ���� item�� ����
					edgeList.insert(item); //edgeList�� item�� �߰�
				}
			}
		}
		UnionFind u= new UnionFind(vertex_size); //UnionFind����
		int p=-1;
		
		while(p<vertex_size -2 && edgeList.numberElements()>0) { //��������Ʈ�� ���� 0���� ũ�� p�� ���� ������ -2���� ���� ���� �ݺ�
			Edge e= edgeList.delete(); //�������� ���� ���� ���� e�� ��ȯ
			if(!u.find(e.getStart(),e.getEnd())) { //���۰��� �� ���� ���� ���տ� ������ ������
				p++; //p�� ����
				T[p]=e; //������ ����e�� ����
				u.union(e.getStart(), e.getEnd()); //�� ������ �ϳ��� ������
			}
		}
		return T; //����T ��ȯ
	}
	public Edge[] prim(int i) { //���� �˰���
	      Edge[] T= new Edge[vertex_size-1]; //����(����) T�� ����
	      int Tptr = -1;
	      
	      MinHeap edgeList=new MinHeap(); //�ּ��� edgeList ����
	      
	      UnionFind uf= new UnionFind(vertex_size); //UnionFind����
	      
	      for(int j=0; j<vertex_size; j++) { //i�� �Ű����� ������
	         if(weights[i][j]!=-1) //����ġ�� ������� �ʴ� ��쿡
	            edgeList.insert(new Edge(i,j,weights[i][j])); //�ּ����� �߰�
	      }
	     
	      while(Tptr<vertex_size-2) { // insert�� �̷����
	            Edge e= edgeList.delete(); //�ּ������� ���� ���� �� e�� ����
	            if(!uf.find(e.getStart(), e.getEnd())) { //e�� ���� ���տ� ���ϴ��� �ƴ��� ����, ���� ���տ� ������ ������
	               Tptr++; 
	               T[Tptr]=e; //������ T�� �߰�
	               uf.union(e.getStart(), e.getEnd()); //uf�� e������
	            /*}
	            else { //�������տ� ���ϸ�
	               if(edgeList.numberElements()>0) //�ּ����� �����Ͱ� ���� ��
	                  continue; //�ݺ��� �ٽ� ����
	            }
	            int t=e.getEnd(); 
	            for(int j=0; j<vertex_size; j++) {
	               if(weights[t][j]!=-1) { //����ġ�� ������� �ʴ� ��쿡
	                 edgeList.insert(new Edge(t,j,weights[t][j])); //�ּ����� �߰�
	               }
	            }*/
	               for(int j=0; j<vertex_size; j++) {
	            	   if(weights[e.getEnd()][j]!=-1)
	            		   edgeList.insert(new Edge(e.getEnd(),j,weights[e.getEnd()][j]));
	               }
	            }
	         }
	      return T;
	   }
}
