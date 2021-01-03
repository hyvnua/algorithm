package week14_Algo;

public class HeapSort {
	public int[] heapSort(int[] arr) { //히프 정렬
		int n=arr.length-1; //히프 크기
		int i;
		for(i=n/2; i>=1; i--) { //arr[0]은 사용하지 않음
			heapify(arr,i,n); //배열을 히프로 변환
		}
		for(i=n-1; i>=1; i--) { //배열을 오름차순으로 정렬
			int temp=arr[1]; //arr[1] 가장 큰 원소
			arr[1]=arr[i+1]; //arr[1]과 arr[i+1] 교환
			arr[i+1]=temp;
			heapify(arr,1,i); //힙
		}
		return arr; //히프 정렬된 배열 반환
	}
	private void heapify(int[] arr, int h, int m) { //h에서 m까지를 힙으로 만들어줌
		int ah=arr[h]; //ah에 arr[h]를 넣음
		int j; // j 왼쪽 자식
		for(j=2*h; j<=m; j*=2) {
			if(j<m) { //자식이 있으면
				if(arr[j]<arr[j+1]) //오른쪽 자식과 비교
					j++; //j가 더 큰 자식
			}
			if(ah>=arr[j]) //ah가 arr[j]보다 크거나 같으면
				break; //반복문 탈출
			else //그렇지 않으면 
				arr[j/2]=arr[j]; //a[j]를 부모 노드에 올림
		}
		arr[j/2]=ah; //ah값을 arr[j/2]에 넣음 (교환 효과)
	}
}
