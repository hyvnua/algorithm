package week9_ds;

public class UnionFind {
	int [] parent;

    public UnionFind(int n) { //n���� �������� ������ ���� ,,, s ����
        parent = new int[n];
        for (int i = 0; i < n; i++) 
            parent[i] = i;        
    }

    private int root(int i) { //���� ���� ����ġ�� ���� ������ ã�ƿ�
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];    // ��� �ǳ� ���� �ӵ� ���Ͽ�
            i = parent[i];
        }
        return i;
    }

    public boolean find(int p, int q) { //���� ���տ� ���ϴ���, �ƴ���
        return root(p) == root(q);
    }

    public void union(int p, int q) { //�� ������ �ϳ��� ������(p�� ���� ���հ� q�� ���� ������ ������ si= s1 union sj
        int i = root(p);
        int j = root(q);
        parent[i] = j;
    }
}
