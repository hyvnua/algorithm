package week2_Algo;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree root;
		BinaryTree copyTree;
		BinaryTree LeftTemp;
		BinaryTree RightTemp;
		
		BinaryTree LeftSubroot;
		BinaryTree RightSubroot;
		
		BinaryTree empty=new BinaryTree();
		
		LeftTemp=new BinaryTree(empty,'2',empty);
		RightTemp=new BinaryTree(empty,'3',empty);
		
		LeftSubroot=new BinaryTree(LeftTemp,'+',RightTemp);
		
		LeftTemp=new BinaryTree(empty,'2',empty);
		RightTemp=new BinaryTree(empty,'1',empty);
		
		RightSubroot=new BinaryTree(LeftTemp,'/',RightTemp);
		
		copyTree=RightSubroot;
		
		root=new BinaryTree(LeftSubroot,'*',RightSubroot);
		
		System.out.println("=====root 출력=====");
		System.out.println("=====In Order=====");
		root.inOrder_recursion();
		System.out.println("\n=====Pre Order=====");
		root.preOrder_recursion();
		
		System.out.println("\n=====Post Order=====");
		root.postOrder_recursion();
		System.out.println("\n=====copyroot 출력=====");
		System.out.println("=====In Order=====");
		copyTree.inOrder_recursion();
		System.out.println("\n=====Pre Order=====");
		copyTree.preOrder_recursion();
		
		System.out.println("\n=====Post Order=====");
		copyTree.postOrder_recursion();
		
		if(root.equals(copyTree)) {
			System.out.println("\nroot and copy are the same!!!");
		}
		else {
			System.out.println("\nroot and copy are the not same!!!");
		}
		copyTree=root.copy();
		
		
		if(root.equals(copyTree)) {
			System.out.println("\nroot and copy are the same!!!");
		}
		else {
			System.out.println("\nroot and copy are the not same!!!");
		}
		
		System.out.println(copyTree.height());
		System.out.println();
		root.postOrder_recursion();
		root.swap();
		System.out.println();
		root.postOrder_recursion();
		
	}
}
