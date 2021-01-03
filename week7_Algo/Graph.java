package week7_Algo;

public class Graph {
	private int [][] matrix;
	private int size;
	
	public Graph(int size) {
		this.matrix=new int[size][size];
		this.size=size;
	}
	public void add(int i, int k) { //행렬에 값을 추가하는 메소드
		matrix[i][k]=1; //해당 값을 넣으면 1로 바꿔줌
		matrix[k][i]=1; //해당 값을 넣으면 1로 바꿔줌 (무방향 그래프이기 때문에 대칭)
	}
	public void delete(int i, int k) { //행렬에 값을 삭제하는 메소드
		matrix[i][k]=0; //해당 값을 삭제하면 0으로 바꿔줌
		matrix[k][i]=0; //해당 값을 삭제하면 0으로 바꿔줌 (무방향 그래프이기 때문에 대칭)
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
