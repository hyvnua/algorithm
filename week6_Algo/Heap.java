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
	public void insert(int item) {//���������� �����ϰ� �θ�� ��(����)
		if(nNode==maxSize) heapFull(); //������ �� á���� Ȯ��
		
		int i;
		for(i=nNode;;) {
			if(i==0) break; //nNode�� 0�� ��� �װ��� �����ϸ� �Ǳ⶧���� break
			if(item<=heap[(i-1)/2]) break; //item�� heap������ ���� ��쿡 �װ��� �����ϸ� �Ǳ� ������ break
			heap[i]=heap[(i-1)/2]; //�θ��带 �ڽĳ�忡 ����
			i=(i-1)/2; //i�� i�� �θ���� �ٲ���
		}
		heap[i]=item; //heap�� item�� �־���
		
		nNode++; //insert �Ǿ����� node�� �ϳ� ����
	}
	public int delete() {//root���� ��
	      if(nNode==0) //���������� ��� ����
	         return -1;
	      int item=heap[0]; // item�� root�� ����
	      int temp=heap[nNode-1]; //������ ���Ҹ� temp�� �ִ´�
	      nNode--; //��带 �ϳ� �����
	      int i=0; 
	      int j=1; //j�� i�� ���� �ڽ� ���
	      while(j<=nNode-1) { //j�� nNode-1���� ���� ������ �ݺ��� �ݺ�
	         if(j<nNode-1) { //j�� nNode-1���� ���� ��
	            if(heap[j]<heap[j+1]) //���� ������ �ִ� ���ҳ��� ���ؼ� �� ū ���Ҹ� j�� �ִ´�
	               j=j+1;
	         }
	         if(temp>=heap[j]) break; //temp���� heap[j]���� ũ�� �� �ڸ��� ������ �Ǳ⶧���� �ݺ��� Ż��
	         heap[i]=heap[j]; //�ڽ��� �� ���� ���� �̵�
	         i=j; //i�� j��ġ�� �ű�
	         j=(j*2)+1; //j�� j�� �ڽ����� �̵�
	      }
	      heap[i]=temp; //heap[i]�� temp�� �־���
	      maxSize--; //�迭 ������ ����
	      return item; //������ �� ��ȯ
	   }
	
	public void makeTreeHeap() { //��������Ʈ���� ������ �ٲ��ִ� �޼ҵ�
		int p,temp;
		for(int i=(nNode-2)/2; i>=0; i--) { //���� �������� i=(���-2)/2���� �ϳ��� �����ϸ鼭 �ݺ�
			p=i; //p�� i�� ����
			for(int j=2*p+1; j<=nNode-2; j=j*2+1) { //j �ڽĳ��, j�� �� ������ ����
				if(j<nNode-2) { //j�� nNode-2���� ������
					if(heap[j]<heap[j+1]) { //j�� j+1�� ���ϰ� j+1�� �� ũ��
						j=j+1; //j�� j+1�� �ִ´�.
					}
				}
				if(heap[p]>=heap[j]) break; //������ �θ��尡 ������ �ڽĳ�庸�� ũ�� �ٲ� �ʿ�����Ƿ� break
				temp=heap[p]; //������ �θ� ���� �ڽĳ�带 �ٲ�, �ӽú����� �θ� �ְ�
				heap[p]=heap[j]; //�θ� �ڽ��� �ְ�
				heap[j]=temp; //�ڽĿ� �θ� ��� temp�� �ִ´�.
				
				p=j; //�θ� ��带 �� ���� ������ �̵�
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
