package week14_Algo;

public class HeapSort {
	public int[] heapSort(int[] arr) { //���� ����
		int n=arr.length-1; //���� ũ��
		int i;
		for(i=n/2; i>=1; i--) { //arr[0]�� ������� ����
			heapify(arr,i,n); //�迭�� ������ ��ȯ
		}
		for(i=n-1; i>=1; i--) { //�迭�� ������������ ����
			int temp=arr[1]; //arr[1] ���� ū ����
			arr[1]=arr[i+1]; //arr[1]�� arr[i+1] ��ȯ
			arr[i+1]=temp;
			heapify(arr,1,i); //��
		}
		return arr; //���� ���ĵ� �迭 ��ȯ
	}
	private void heapify(int[] arr, int h, int m) { //h���� m������ ������ �������
		int ah=arr[h]; //ah�� arr[h]�� ����
		int j; // j ���� �ڽ�
		for(j=2*h; j<=m; j*=2) {
			if(j<m) { //�ڽ��� ������
				if(arr[j]<arr[j+1]) //������ �ڽİ� ��
					j++; //j�� �� ū �ڽ�
			}
			if(ah>=arr[j]) //ah�� arr[j]���� ũ�ų� ������
				break; //�ݺ��� Ż��
			else //�׷��� ������ 
				arr[j/2]=arr[j]; //a[j]�� �θ� ��忡 �ø�
		}
		arr[j/2]=ah; //ah���� arr[j/2]�� ���� (��ȯ ȿ��)
	}
}
