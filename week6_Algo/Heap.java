package week6_Algo;

public class Heap {
	private int nNode;
	private int maxSize;
	private int heap[];
	
	public Heap() {
		nNode=0;
		maxSize=0;
		heap=new int[maxSize];
	}
	
	public Heap(int[] tree) {
		nNode=tree.length;
		maxSize=tree.length;
		heap=tree;
	}
	private void heapFull() {
		maxSize++;
		int tempHeap[]=new int[maxSize];
		
		for(int i=0; i<maxSize-1; i++) {
			tempHeap[i]=heap[i];
		}
		heap=tempHeap;
	}
	public void insert(int item) {//마지막으로 삽입하고 부모와 비교(역순)
		if(nNode==maxSize) heapFull(); //히프가 다 찼으면 확장
		
		int i;
		for(i=nNode;;) {
			if(i==0) break; //nNode가 0인 경우 그곳에 삽입하면 되기때문에 break
			if(item<=heap[(i-1)/2]) break; //item이 heap값보다 작을 경우에 그곳에 삽입하면 되기 때문에 break
			heap[i]=heap[(i-1)/2]; //부모노드를 자식노드에 넣음
			i=(i-1)/2; //i를 i의 부모노드로 바꿔줌
		}
		heap[i]=item; //heap에 item을 넣어줌
		
		nNode++; //insert 되었으니 node값 하나 증가
	}
	public int delete() {//root부터 비교
	      if(nNode==0) //공백히프일 경우 에러
	         return -1;
	      int item=heap[0]; // item에 root를 넣음
	      int temp=heap[nNode-1]; //마지막 원소를 temp에 넣는다
	      nNode--; //노드를 하나 지운다
	      int i=0; 
	      int j=1; //j는 i의 왼쪽 자식 노드
	      while(j<=nNode-1) { //j가 nNode-1보다 작을 때까지 반복문 반복
	         if(j<nNode-1) { //j가 nNode-1보다 작을 때
	            if(heap[j]<heap[j+1]) //같은 레벨에 있는 원소끼리 비교해서 더 큰 원소를 j에 넣는다
	               j=j+1;
	         }
	         if(temp>=heap[j]) break; //temp값이 heap[j]보다 크면 그 자리에 넣으면 되기때문에 반복문 탈출
	         heap[i]=heap[j]; //자식을 한 레벨 위로 이동
	         i=j; //i를 j위치로 옮김
	         j=(j*2)+1; //j는 j의 자식으로 이동
	      }
	      heap[i]=temp; //heap[i]에 temp를 넣어줌
	      maxSize--; //배열 사이즈 줄임
	      return item; //지워진 값 반환
	   }
	
	public void makeTreeHeap() { //완전이진트리를 히프로 바꿔주는 메소드
		int p,temp;
		for(int i=(nNode-2)/2; i>=0; i--) { //레벨 역순으로 i=(노드-2)/2부터 하나씩 감소하면서 반복
			p=i; //p에 i를 넣음
			for(int j=2*p+1; j<=nNode-2; j=j*2+1) { //j 자식노드, j를 한 레벨씩 증가
				if(j<nNode-2) { //j가 nNode-2보다 작으면
					if(heap[j]<heap[j+1]) { //j와 j+1을 비교하고 j+1가 더 크면
						j=j+1; //j에 j+1를 넣는다.
					}
				}
				if(heap[p]>=heap[j]) break; //히프의 부모노드가 히프의 자식노드보다 크면 바꿀 필요없으므로 break
				temp=heap[p]; //히프와 부모 노드와 자식노드를 바꿈, 임시변수에 부모를 넣고
				heap[p]=heap[j]; //부모에 자식을 넣고
				heap[j]=temp; //자식에 부모가 담긴 temp를 넣는다.
				
				p=j; //부모 노드를 한 레벨 밑으로 이동
			}
		}
	
	}
	
	
	public void show() {
		for(int i=0; i<maxSize; i++) {
			System.out.print(heap[i]+" | ");
		}
		System.out.println();
	}
}
