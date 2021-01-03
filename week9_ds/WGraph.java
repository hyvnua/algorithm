package week9_ds;

public class WGraph {
	private int vertex_size; //배열의 사이즈
	private int e; //에지의 갯수
	private int[][] weights; //가중치 배열 선언
	
	public WGraph(int vertex_size) { //매개변수로 받은 만큼의 가중치 그래프 생성
		this.weights=new int[vertex_size][vertex_size]; //가중치 배열 생성
		this.vertex_size=vertex_size; //그래프의 크기 = 입력받은 size크기
		e=0; //에지의 개수는 0
		for(int i=0; i<this.vertex_size; i++) { //반복문을 돌려서
			for(int j=0; j<this.vertex_size; j++) {
				if(i==j) weights[i][j]=0; //[0][0],[1][1],... 같은 경우는 0으로 초기화
				else weights[i][j]=-1; //그 외는 -1로 초기화
			}
		}
	}
	public void insertEdge(int i, int k, int w) { //에지를 추가하는 메소드
		if(weights[i][k]==-1 && weights[k][i]==-1) { //가중치 값이 -1일 때 즉, 삽입된 적이 없는 경우에
			weights[i][k]=w; // 매개변수로 받은 가중치 값을 넣어줌
			weights[k][i]=w; // 매개변수로 받은 가중치 값을 넣어줌(무방향그래프)
			e++; //에지의 수 증가
		}
	}
	public void print() { //출력하는 메소드
		for(int i=0; i<vertex_size; i++) {
			for(int j=0; j<vertex_size; j++) {
				System.out.printf("[ %3d ]",weights[i][j]); //가중치 값을 출력
			}
			System.out.println();
		}
	}
	
	public Edge[] kruskal() { //크루스칼 알고리즘
		Edge[] T =new Edge[(vertex_size-1)]; //에지(간선) T를 생성
		MinHeap edgeList=new MinHeap(); //최소힙 edgeList 생성
		
		//비어있지 않은(가중치가 -1)이지 않은 경우에 edgeList(minheap)에 Edge값 추가
		for(int i=0; i<vertex_size; i++) { 
			for(int j=i+1; j<vertex_size; j++) {
				if(weights[i][j]!=-1) { //비어있지 않는 경우에
					Edge item=new Edge(i,j,weights[i][j]); // 해당 엣지 item을 만듬
					edgeList.insert(item); //edgeList에 item값 추가
				}
			}
		}
		UnionFind u= new UnionFind(vertex_size); //UnionFind생성
		int p=-1;
		
		while(p<vertex_size -2 && edgeList.numberElements()>0) { //에지리스트의 값이 0보다 크고 p의 값이 사이즈 -2보다 작을 동안 반복
			Edge e= edgeList.delete(); //히프에서 가장 작은 값을 e를 반환
			if(!u.find(e.getStart(),e.getEnd())) { //시작값과 끝 값이 같은 집합에 속하지 않으면
				p++; //p를 증가
				T[p]=e; //간선에 에지e를 넣음
				u.union(e.getStart(), e.getEnd()); //두 집합을 하나로 묶어줌
			}
		}
		return T; //에지T 반환
	}
	public Edge[] prim(int i) { //프림 알고리즘
	      Edge[] T= new Edge[vertex_size-1]; //에지(간선) T를 생성
	      int Tptr = -1;
	      
	      MinHeap edgeList=new MinHeap(); //최소힙 edgeList 생성
	      
	      UnionFind uf= new UnionFind(vertex_size); //UnionFind생성
	      
	      for(int j=0; j<vertex_size; j++) { //i는 매개변수 값으로
	         if(weights[i][j]!=-1) //가중치가 비어있지 않는 경우에
	            edgeList.insert(new Edge(i,j,weights[i][j])); //최소힙에 추가
	      }
	     
	      while(Tptr<vertex_size-2) { // insert도 이루어짐
	            Edge e= edgeList.delete(); //최소힙에서 가장 작은 값 e에 저장
	            if(!uf.find(e.getStart(), e.getEnd())) { //e가 같은 집합에 속하는지 아닌지 구함, 같은 집합에 속하지 않으면
	               Tptr++; 
	               T[Tptr]=e; //간선에 T에 추가
	               uf.union(e.getStart(), e.getEnd()); //uf에 e묶어줌
	            /*}
	            else { //같은집합에 속하면
	               if(edgeList.numberElements()>0) //최소힙에 데이터가 있을 때
	                  continue; //반복문 다시 실행
	            }
	            int t=e.getEnd(); 
	            for(int j=0; j<vertex_size; j++) {
	               if(weights[t][j]!=-1) { //가중치가 비어있지 않는 경우에
	                 edgeList.insert(new Edge(t,j,weights[t][j])); //최소힙에 추가
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
