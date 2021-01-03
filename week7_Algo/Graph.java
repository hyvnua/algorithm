package week7_Algo;

public class Graph {
	private int [][] matrix;
	private int size;
	
	public Graph(int size) {
		this.matrix=new int[size][size];
		this.size=size;
	}
	public void add(int i, int k) { //��Ŀ� ���� �߰��ϴ� �޼ҵ�
		matrix[i][k]=1; //�ش� ���� ������ 1�� �ٲ���
		matrix[k][i]=1; //�ش� ���� ������ 1�� �ٲ��� (������ �׷����̱� ������ ��Ī)
	}
	public void delete(int i, int k) { //��Ŀ� ���� �����ϴ� �޼ҵ�
		matrix[i][k]=0; //�ش� ���� �����ϸ� 0���� �ٲ���
		matrix[k][i]=0; //�ش� ���� �����ϸ� 0���� �ٲ��� (������ �׷����̱� ������ ��Ī)
	}
	public void show() {
		if(this.size==0) {
			System.out.println("No Matrix");
			return;
		}
		for(int i=0; i<size; i++) {
			String temp="";
			for(int j=0; j<size; j++) {
				if(this.matrix[i][j]==1) {
					temp+=j+" ";
				}
			}
			if(!temp.equals("")) {
				System.out.println(i+" : "+temp);
			}
		}
	}
	
}
