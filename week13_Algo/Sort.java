package week13_Algo;

public class Sort {
	public int[] mergeSort(int[] arr) { //MergeSort(합병정렬)알고리즘
		int[] temp=new int[arr.length];
		internalMergeSort(arr,temp,0,arr.length-1);
		
		return arr;
	}
	
	private void internalMergeSort(int[] arr, int[] temp, int m, int n) {
		if(m<n) { //정렬할 원소가 두개 이상인 경우 정렬
			int middle=(m+n)/2;
			internalMergeSort(arr,temp,m,middle); //재귀
			internalMergeSort(arr,temp,middle+1,n); //재귀
			merge(arr,temp,m,middle,middle+1,n); //merge호출
		}
	}
	
	private void merge(int[] arr, int[] temp, int m, int p, int q, int n) {
		int t=m;
		int numElements=n-m+1; //배열의 크기
		while(m<=p&&q<=n) { //m이 p보다 작거나 같고 q가 n보다 작거나 같을 동안
			if(arr[m]<arr[q]) //arr[m]이 arr[q]보다 작을 때
				temp[t++]=arr[m++]; //temp[t++]에 arr[m++]한 값 넣어줌
			else
				temp[t++]=arr[q++]; //temp[t++]에 arr[q++]한 값 넣어줌
		}
		while(m<=p) //왼쪽 부분 배열에 원소가 남아 있는 경우
			temp[t++]=arr[m++];
		while(q<=n) //오른쪽 부분 배열에 원소가 남아 있는 경우
			temp[t++]=arr[q++]; 
		for(int i=0; i<numElements; i++,n--)
			arr[n]=temp[n]; //배열 temp[]를 a[]로 복사
	}
	
	public int[] quickSort(int[] arr) { //QuickSort(퀵 정렬)알고리즘
		internalQuickSort(arr,0,arr.length-1);
		return arr;
	}
	private void internalQuickSort(int[] arr, int m, int n) { //배열의 부분 배열을 오름차순으로 정렬
		if(m>=n) //정렬할 원소의 수가 m이 n보다 클 때는 return
			return;
		int p=partition(arr,m,n); //p 파티션이 끝난 뒤에 사용된 pivot의 인덱스
		internalQuickSort(arr,m,p-1); //재귀
		internalQuickSort(arr,p+1,n); //재귀
	}
	private int partition(int[] arr, int m, int n) {
		int temp;
		int middle=(m+n)/2; //middle은 배열즤 중앙 인덱스 값
		int pivot=arr[middle]; //a[]의 중앙 원소값을 pivot으로 설정
		arr[middle]=arr[m]; //arr[middle]과 arr[m]를 교환
		arr[m]=pivot; //arr[m]에 pivot값 저장
		int p=m; //p는 두 파티션의 경계를 지시하는 인덱스
		
		for(int k=m+1; k<=n; k++) { //m+1인 모든 원소를 검사
			if(arr[k]<pivot) { //arr[k]가 pivot보다 작으면
				p=p+1; //p를 하나 증가시킴
				temp=arr[p]; //교환
				arr[p]=arr[k];
				arr[k]=temp;
			}
		}
		temp=arr[m]; //arr[m]과 arr[p]를 교환
		arr[m]=arr[p];
		arr[p]=temp;
		return p;
	}
}
