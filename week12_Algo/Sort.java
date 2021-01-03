package week12_Algo;

public class Sort {
	private void swap(int[] a, int j, int k) { //값을 swap해주는 메소드
		int temp=a[j]; //temp에 a[j]값을 저장하고
		a[j]=a[k]; //a[j]에 a[k]값을 넣고
		a[k]=temp; //a[k]에는 temp값을 넣는다.
	}
	
	private int[] copy(int[] arr) { //배열을 복사해주는 메소드
		int[] copy=new int[arr.length]; //복사할 배열을 매개변수로 넘어온 배열의 크기로 만듬
		for(int i=0; i<arr.length; i++) {
			copy[i]=arr[i]; //arr[i]의 값을 copy[i]에 복사한다
		}
		return copy; //복사된 배열 반환
	}
	
	public int[] bubbleSort(int[] arr) { //버블 정렬(인접한 원소들을 비교해가면서 정렬)
		int[] a=copy(arr); //복사된 배열 a
		int i,j;
		for(i=a.length-1; i>=0; --i) { //배열의 크기-1 부터 0까지 i를 감소시켜가면서
			for(j=0; j<i; j++) { //j가 i보다 작을 때까지 반복
				if(a[j]>a[j+1]) //a[j]가 a[j+1]보다 크면
					swap(a,j,j+1); //둘을 바꿔줌
			}
		}
		return a; //정렬된 배열 반환
	}
	
	public int[] selectionSort(int[] arr) { //선택 정렬 (잘못된 위치에 들어가 있는 원소를 찾아 올바른 위치에 집어 넣는 방식)
		int[] a=copy(arr); //복사된 배열 a
		int i, j, min;
		for(i=0; i<a.length-1; i++) { //0부터 배열의 크기 -1까지 i를 증가시키면서
			for(j=i+1, min=i; j<a.length; j++) { //j=i+1, min=i인 상태에 j가 배열의 크기보다 작을 때까지 j를 증가시키면서 반복
				if(a[j]<a[min]) min=j; //a[j]가 a[min]보다 작을 때 min값을 j로 바꿔줌
			}
			swap(a, min, i); //min과 i를 swap
		}
		return a; //정렬된 배열 반환
	}
	
	public int[] insertionSort(int[] arr) { //삽입 정렬
		int[] a=copy(arr); //복사된 배열 a
		boolean move; //move
		int k,j;
		for(int i=1; i<a.length; i++) { //i가 1부터 i가 배열의 크기보다 작을 때까지 i를 증가시키면서 반복
			k=a[i]; //k에 a[i] (임시 저장)
			j=i; //j에 i
			if(a[j-1]>k) move=true; //a[j-1]이 k보다 크면 move는 참
			else move=false; //작으면 move는 거짓
			while(move) { //move가 참일 경우
				a[j]=a[j-1]; //a[j]에 a[j-1]를 넣음 (한자리를 이동시켜 빈자리를 만듬)
				j=j-1; //j를 1 감소
				if(j>0 && a[j-1]>k) move=true; //j가 0보다 크고 a[j-1]이 k보다 클 경우 move는 참
				else move=false; //그렇지 않으면 move는 거짓
			}
			a[j]=k; //k를 빈자리에 삽입
		}
		return a; //정렬된 배열 반환
	}
}
