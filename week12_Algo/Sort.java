package week12_Algo;

public class Sort {
	private void swap(int[] a, int j, int k) { //���� swap���ִ� �޼ҵ�
		int temp=a[j]; //temp�� a[j]���� �����ϰ�
		a[j]=a[k]; //a[j]�� a[k]���� �ְ�
		a[k]=temp; //a[k]���� temp���� �ִ´�.
	}
	
	private int[] copy(int[] arr) { //�迭�� �������ִ� �޼ҵ�
		int[] copy=new int[arr.length]; //������ �迭�� �Ű������� �Ѿ�� �迭�� ũ��� ����
		for(int i=0; i<arr.length; i++) {
			copy[i]=arr[i]; //arr[i]�� ���� copy[i]�� �����Ѵ�
		}
		return copy; //����� �迭 ��ȯ
	}
	
	public int[] bubbleSort(int[] arr) { //���� ����(������ ���ҵ��� ���ذ��鼭 ����)
		int[] a=copy(arr); //����� �迭 a
		int i,j;
		for(i=a.length-1; i>=0; --i) { //�迭�� ũ��-1 ���� 0���� i�� ���ҽ��Ѱ��鼭
			for(j=0; j<i; j++) { //j�� i���� ���� ������ �ݺ�
				if(a[j]>a[j+1]) //a[j]�� a[j+1]���� ũ��
					swap(a,j,j+1); //���� �ٲ���
			}
		}
		return a; //���ĵ� �迭 ��ȯ
	}
	
	public int[] selectionSort(int[] arr) { //���� ���� (�߸��� ��ġ�� �� �ִ� ���Ҹ� ã�� �ùٸ� ��ġ�� ���� �ִ� ���)
		int[] a=copy(arr); //����� �迭 a
		int i, j, min;
		for(i=0; i<a.length-1; i++) { //0���� �迭�� ũ�� -1���� i�� ������Ű�鼭
			for(j=i+1, min=i; j<a.length; j++) { //j=i+1, min=i�� ���¿� j�� �迭�� ũ�⺸�� ���� ������ j�� ������Ű�鼭 �ݺ�
				if(a[j]<a[min]) min=j; //a[j]�� a[min]���� ���� �� min���� j�� �ٲ���
			}
			swap(a, min, i); //min�� i�� swap
		}
		return a; //���ĵ� �迭 ��ȯ
	}
	
	public int[] insertionSort(int[] arr) { //���� ����
		int[] a=copy(arr); //����� �迭 a
		boolean move; //move
		int k,j;
		for(int i=1; i<a.length; i++) { //i�� 1���� i�� �迭�� ũ�⺸�� ���� ������ i�� ������Ű�鼭 �ݺ�
			k=a[i]; //k�� a[i] (�ӽ� ����)
			j=i; //j�� i
			if(a[j-1]>k) move=true; //a[j-1]�� k���� ũ�� move�� ��
			else move=false; //������ move�� ����
			while(move) { //move�� ���� ���
				a[j]=a[j-1]; //a[j]�� a[j-1]�� ���� (���ڸ��� �̵����� ���ڸ��� ����)
				j=j-1; //j�� 1 ����
				if(j>0 && a[j-1]>k) move=true; //j�� 0���� ũ�� a[j-1]�� k���� Ŭ ��� move�� ��
				else move=false; //�׷��� ������ move�� ����
			}
			a[j]=k; //k�� ���ڸ��� ����
		}
		return a; //���ĵ� �迭 ��ȯ
	}
}
