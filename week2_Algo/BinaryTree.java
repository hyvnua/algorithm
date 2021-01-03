package week2_Algo;

public class BinaryTree {
	private TreeNode root = new TreeNode();

	public BinaryTree() { // ������
		this.root = null;
	}

	public BinaryTree(BinaryTree left, Object item, BinaryTree right) { // ������
		this.root.setItem(item);
		this.root.setLeft(left.root);
		this.root.setRight(right.root);
	}

	public boolean isEmpty() { // root�� ����ִ��� Ȯ���ϴ� �޼ҵ�
		if (this.root == null)
			return true;
		else
			return false;
	}

	public Object rootData() { // root�� �����͸� ��ȯ
		if (this.isEmpty()) {
			System.out.println("Tree is Empty!!!");
			return null;
		} else
			return root.getItem();
	}

	public BinaryTree leftSubTree() { // root�� left tree�� ��ȯ
		if (this.root.getLeft() == null) { // root�� left tree�� null�̸� �����Ƿ� null ��ȯ
			return null;
		} else { // null�� �ƴ϶��
			BinaryTree left = new BinaryTree(); // left���� ����
			left.root = this.root.getLeft(); // root�� left���� ������
			return left;
		}
	}

	public BinaryTree rightSubTree() { // root�� right tree�� ��ȯ
		if (this.root.getRight() == null) { // root�� right tree�� null�̸� �����Ƿ� null ��ȯ
			return null;
		} else { // null�� �ƴ϶��
			BinaryTree right = new BinaryTree();
			right.root = this.root.getRight();
			return right;
		}
	}

	public void show() { // root, left, right�� ������ִ� �޼ҵ�
		BinaryTree right = this.rightSubTree();
		BinaryTree left = this.leftSubTree();

		System.out.println("root item : " + this.rootData());
		System.out.println("left item : " + left.root.getItem());
		System.out.println("right item : " + right.root.getItem());
	}

	// ���� ��ȸ root-left-right
	public void preOrder_recursion() {
		preOrder_recursion_methods(this.root);
	}

	private void preOrder_recursion_methods(TreeNode T) {
		if (T != null) { //T(root)�� null �ƴ� �� 
			System.out.print(T.getItem()+" "); //T�� ������ ���� ���
			preOrder_recursion_methods(T.getLeft()); //T�� left�� ���ȣ��
			preOrder_recursion_methods(T.getRight()); //T�� right�� ���ȣ��

		}
	}

	// ������ȸ left-root-right
	public void inOrder_recursion() {
		inOrder_recursion_methods(this.root);
	}

	private void inOrder_recursion_methods(TreeNode T) {
		if (T != null) { //T(root)�� null �ƴ� �� 
			inOrder_recursion_methods(T.getLeft()); //T�� left�� ���ȣ��
			System.out.print(T.getItem()+" "); //T�� ������ ���� ���
			inOrder_recursion_methods(T.getRight()); //T�� right�� ���ȣ��
		}
	}

	// ���� ��ȸ left-right-root
	public void postOrder_recursion() {
		postOrder_recursion_methods(this.root);
	}

	private void postOrder_recursion_methods(TreeNode T) {
		if (T != null) { //T(root)�� null �ƴ� �� 
			postOrder_recursion_methods(T.getLeft()); //T�� left�� ���ȣ��
			postOrder_recursion_methods(T.getRight()); //T�� right�� ���ȣ��
			System.out.print(T.getItem()+" "); //T�� ������ ���� ���
		}
	}

	public BinaryTree copy() { //tree�� copy�ϴ� �޼ҵ�
		BinaryTree newTree = new BinaryTree(); //copy�ϱ� ���� binarytree�� ���� ����
		newTree.root = theCopy(root); //���ο� newTree�� theCopy�Լ��� ȣ��
		return newTree; //����� newTree�� return �Ѵ�.
	}

	private TreeNode theCopy(TreeNode t) {
		if (t == null) //root�� null�̶�� �ƹ��͵� ���� ���̱� ������
			return null; //null�� ȣ���Ѵ�
		else { //null���� �ƴ϶��
			TreeNode l = theCopy(t.getLeft()); //left���� �����ͼ� null�� �ƴ϶�� l�� �־��ش�. (���)
			TreeNode r = theCopy(t.getRight()); //right���� �����ͼ� r�� �־��ش�. (���)
			TreeNode newTree = new TreeNode(l, t.getItem(), r); //������ ������ newTree�� �����ڿ� �־��ش�.
			return newTree; //����� newTree�� ��ȯ�Ѵ�.
		}
	}

	public boolean equals(BinaryTree tr) { //�Ű������� ���� tree�� ������ tree�� ������ ���ϴ� �޼ҵ�
		return theEqual(this.root, tr.root);
	}

	private boolean theEqual(TreeNode s, TreeNode t) {
		if (s == null && t == null) { //s�� t�� �� �� null�̶�� ���� ������
			return true; //true�� ��ȯ���ش�.
		} else if (s != null && t != null) { //s�� t�� ��� null�� �ƴ϶��
			if (s.getItem().equals(t.getItem())) { //s�� t�� data���� �����ͼ� ���Ѵ�.
				if (theEqual(s.getLeft(),t.getLeft())) { //s�� t�� left���� �����ͼ� ���Ѵ�. (���)
					if (theEqual(s.getRight(),t.getRight())) { //s�� t�� right���� �����ͼ� ���Ѵ�. (���)
						return true; //data, left, right���� ��� ���� ������ true�� ��ȯ�Ѵ�.
					} else
						return false; //s�� t���� �ٸ��ٸ� false���� return
				} else
					return false; //s�� t���� �ٸ��ٸ� false���� return
			} else
				return false; //s�� t���� �ٸ��ٸ� false���� return
		} else { //s�� t�� �ϳ��� null�̰� �ٸ� �ϳ��� null�� �ƴ϶�� ���� �ʱ� ������
			return false; //false�� ��ȯ�Ѵ�.
		}
	}
	public int height() {
		return theHeight(root);
	}
	private int theHeight(TreeNode t) {
		int height,hl,hr;
		if(t==null) {
			return 0;
		}
		else {
			hl=theHeight(t.getLeft());
			hr=theHeight(t.getRight());
			if(hl>=hr) 
				height=hl+1;
			else
				height=hr+1;
			return height;
			
		}
	}
	public void swap() {
		theSwap(root); 
	}
	public TreeNode theSwap(TreeNode t) {
		TreeNode stree;
		TreeNode ltree;
		TreeNode rtree;
		
		stree=new TreeNode();
		if(t!=null) {
			ltree=theSwap(t.getRight());
			rtree=theSwap(t.getLeft());
			stree=new TreeNode(ltree,t.getItem(),rtree);
		}
		return stree;
	}

}
