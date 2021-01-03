package week9_ds;

public class UnionFind {
	int [] parent;

    public UnionFind(int n) { //n개의 독립적인 집합을 만듬 ,,, s 집합
        parent = new int[n];
        for (int i = 0; i < n; i++) 
            parent[i] = i;        
    }

    private int root(int i) { //가장 작은 가중치를 가진 간선을 찾아옴
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];    // 없어도 되나 빠른 속도 위하여
            i = parent[i];
        }
        return i;
    }

    public boolean find(int p, int q) { //같은 집합에 속하는지, 아닌지
        return root(p) == root(q);
    }

    public void union(int p, int q) { //두 집합을 하나로 묶어줌(p가 속한 집합과 q가 속한 집합을 묶어줌 si= s1 union sj
        int i = root(p);
        int j = root(q);
        parent[i] = j;
    }
}
