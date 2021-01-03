package week13_Algo;

public class Sort {
	public int[] mergeSort(int[] arr) { //MergeSort(�պ�����)�˰���
		int[] temp=new int[arr.length];
		internalMergeSort(arr,temp,0,arr.length-1);
		
		return arr;
	}
	
	private void internalMergeSort(int[] arr, int[] temp, int m, int n) {
		if(m<n) { //������ ���Ұ� �ΰ� �̻��� ��� ����
			int middle=(m+n)/2;
			internalMergeSort(arr,temp,m,middle); //���
			internalMergeSort(arr,temp,middle+1,n); //���
			merge(arr,temp,m,middle,middle+1,n); //mergeȣ��
		}
	}
	
	private void merge(int[] arr, int[] temp, int m, int p, int q, int n) {
		int t=m;
		int numElements=n-m+1; //�迭�� ũ��
		while(m<=p&&q<=n) { //m�� p���� �۰ų� ���� q�� n���� �۰ų� ���� ����
			if(arr[m]<arr[q]) //arr[m]�� arr[q]���� ���� ��
				temp[t++]=arr[m++]; //temp[t++]�� arr[m++]�� �� �־���
			else
				temp[t++]=arr[q++]; //temp[t++]�� arr[q++]�� �� �־���
		}
		while(m<=p) //���� �κ� �迭�� ���Ұ� ���� �ִ� ���
			temp[t++]=arr[m++];
		while(q<=n) //������ �κ� �迭�� ���Ұ� ���� �ִ� ���
			temp[t++]=arr[q++]; 
		for(int i=0; i<numElements; i++,n--)
			arr[n]=temp[n]; //�迭 temp[]�� a[]�� ����
	}
	
	public int[] quickSort(int[] arr) { //QuickSort(�� ����)�˰���
		internalQuickSort(arr,0,arr.length-1);
		return arr;
	}
	private void internalQuickSort(int[] arr, int m, int n) { //�迭�� �κ� �迭�� ������������ ����
		if(m>=n) //������ ������ ���� m�� n���� Ŭ ���� return
			return;
		int p=partition(arr,m,n); //p ��Ƽ���� ���� �ڿ� ���� pivot�� �ε���
		internalQuickSort(arr,m,p-1); //���
		internalQuickSort(arr,p+1,n); //���
	}
	private int partition(int[] arr, int m, int n) {
		int temp;
		int middle=(m+n)/2; //middle�� �迭�p �߾� �ε��� ��
		int pivot=arr[middle]; //a[]�� �߾� ���Ұ��� pivot���� ����
		arr[middle]=arr[m]; //arr[middle]�� arr[m]�� ��ȯ
		arr[m]=pivot; //arr[m]�� pivot�� ����
		int p=m; //p�� �� ��Ƽ���� ��踦 �����ϴ� �ε���
		
		for(int k=m+1; k<=n; k++) { //m+1�� ��� ���Ҹ� �˻�
			if(arr[k]<pivot) { //arr[k]�� pivot���� ������
				p=p+1; //p�� �ϳ� ������Ŵ
				temp=arr[p]; //��ȯ
				arr[p]=arr[k];
				arr[k]=temp;
			}
		}
		temp=arr[m]; //arr[m]�� arr[p]�� ��ȯ
		arr[m]=arr[p];
		arr[p]=temp;
		return p;
	}
}
