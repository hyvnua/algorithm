package week2_Algo;

public class BinaryTree {
	private TreeNode root = new TreeNode();

	public BinaryTree() { // 생성자
		this.root = null;
	}

	public BinaryTree(BinaryTree left, Object item, BinaryTree right) { // 생성자
		this.root.setItem(item);
		this.root.setLeft(left.root);
		this.root.setRight(right.root);
	}

	public boolean isEmpty() { // root가 비어있는지 확인하는 메소드
		if (this.root == null)
			return true;
		else
			return false;
	}

	public Object rootData() { // root의 데이터를 반환
		if (this.isEmpty()) {
			System.out.println("Tree is Empty!!!");
			return null;
		} else
			return root.getItem();
	}

	public BinaryTree leftSubTree() { // root의 left tree를 반환
		if (this.root.getLeft() == null) { // root의 left tree가 null이면 없으므로 null 반환
			return null;
		} else { // null이 아니라면
			BinaryTree left = new BinaryTree(); // left값을 생성
			left.root = this.root.getLeft(); // root의 left값을 가져옴
			return left;
		}
	}

	public BinaryTree rightSubTree() { // root의 right tree를 반환
		if (this.root.getRight() == null) { // root의 right tree가 null이면 없으므로 null 반환
			return null;
		} else { // null이 아니라면
			BinaryTree right = new BinaryTree();
			right.root = this.root.getRight();
			return right;
		}
	}

	public void show() { // root, left, right를 출력해주는 메소드
		BinaryTree right = this.rightSubTree();
		BinaryTree left = this.leftSubTree();

		System.out.println("root item : " + this.rootData());
		System.out.println("left item : " + left.root.getItem());
		System.out.println("right item : " + right.root.getItem());
	}

	// 전위 순회 root-left-right
	public void preOrder_recursion() {
		preOrder_recursion_methods(this.root);
	}

	private void preOrder_recursion_methods(TreeNode T) {
		if (T != null) { //T(root)가 null 아닐 때 
			System.out.print(T.getItem()+" "); //T의 데이터 값을 출력
			preOrder_recursion_methods(T.getLeft()); //T의 left를 재귀호출
			preOrder_recursion_methods(T.getRight()); //T의 right를 재귀호출

		}
	}

	// 중위순회 left-root-right
	public void inOrder_recursion() {
		inOrder_recursion_methods(this.root);
	}

	private void inOrder_recursion_methods(TreeNode T) {
		if (T != null) { //T(root)가 null 아닐 때 
			inOrder_recursion_methods(T.getLeft()); //T의 left를 재귀호출
			System.out.print(T.getItem()+" "); //T의 데이터 값을 출력
			inOrder_recursion_methods(T.getRight()); //T의 right를 재귀호출
		}
	}

	// 후위 순회 left-right-root
	public void postOrder_recursion() {
		postOrder_recursion_methods(this.root);
	}

	private void postOrder_recursion_methods(TreeNode T) {
		if (T != null) { //T(root)가 null 아닐 때 
			postOrder_recursion_methods(T.getLeft()); //T의 left를 재귀호출
			postOrder_recursion_methods(T.getRight()); //T의 right를 재귀호출
			System.out.print(T.getItem()+" "); //T의 데이터 값을 출력
		}
	}

	public BinaryTree copy() { //tree를 copy하는 메소드
		BinaryTree newTree = new BinaryTree(); //copy하기 위한 binarytree를 새로 생성
		newTree.root = theCopy(root); //새로운 newTree에 theCopy함수를 호출
		return newTree; //복사된 newTree를 return 한다.
	}

	private TreeNode theCopy(TreeNode t) {
		if (t == null) //root가 null이라면 아무것도 없는 것이기 때문에
			return null; //null을 호출한다
		else { //null값이 아니라면
			TreeNode l = theCopy(t.getLeft()); //left값을 가져와서 null이 아니라면 l에 넣어준다. (재귀)
			TreeNode r = theCopy(t.getRight()); //right값을 가져와서 r에 넣어준다. (재귀)
			TreeNode newTree = new TreeNode(l, t.getItem(), r); //가져온 값들을 newTree의 생성자에 넣어준다.
			return newTree; //복사된 newTree를 반환한다.
		}
	}

	public boolean equals(BinaryTree tr) { //매개변수로 받은 tree와 기존의 tree가 같은지 비교하는 메소드
		return theEqual(this.root, tr.root);
	}

	private boolean theEqual(TreeNode s, TreeNode t) {
		if (s == null && t == null) { //s와 t가 둘 다 null이라면 같기 때문에
			return true; //true를 반환해준다.
		} else if (s != null && t != null) { //s와 t가 모두 null이 아니라면
			if (s.getItem().equals(t.getItem())) { //s와 t의 data값을 가져와서 비교한다.
				if (theEqual(s.getLeft(),t.getLeft())) { //s와 t의 left값을 가져와서 비교한다. (재귀)
					if (theEqual(s.getRight(),t.getRight())) { //s와 t의 right값을 가져와서 비교한다. (재귀)
						return true; //data, left, right값이 모두 같기 떄문에 true를 반환한다.
					} else
						return false; //s와 t값이 다르다면 false값을 return
				} else
					return false; //s와 t값이 다르다면 false값을 return
			} else
				return false; //s와 t값이 다르다면 false값을 return
		} else { //s와 t가 하나가 null이고 다른 하나는 null이 아니라면 같지 않기 때문에
			return false; //false를 반환한다.
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
