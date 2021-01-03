package week2_Algo;

public class TreeNode {
	private Object item;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode() {
		this.item=null;
		this.left=null;
		this.right=null;
	}
	public TreeNode(Object item) {
		this.item=item;
		this.left=null;
		this.right=null;
	}
	public TreeNode(TreeNode left, Object item, TreeNode right) {
		this.item=item;
		this.left=left;
		this.right=right;
	}
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item=item;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left=left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right=right;
	}
}
