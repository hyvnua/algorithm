package week4_Algo;

public class BinarySearchTree {
private TreeNode rootNode;
	private void setRootNode(TreeNode t) {
		rootNode=t;
	}
	
	
	public void BSTinsert(Object k) //�Ű������� ���� ���� �����ϴ� �޼ҵ�
	{
		TreeNode p = rootNode;
		TreeNode q = p; //q�� �θ� p�� �ڽ�
		
		while(p != null) //�Էµ� ��ġ ã��
		{
			if(k instanceof String) //k�� ���ڿ��� ��
			{
				if(objectCompareToString(k,p.getKey())==0) //k�� ���� ���� ������ ��
					break; //�ݺ��� ����
				q=p;// q�� p�� ����
				if(objectCompareToString(k,p.getKey())==1)
					p=q.getRight(); //k���� �� ū ��쿡 p�� ������ �־���
				else
					p=q.getLeft(); //k���� �� ���� ��쿡 p�� ���� �־���
					
			}
			else if(k instanceof Integer) //k�� ������ ��
			{
				if(objectCompareToInteger(k,p.getKey())==0) { //k�� ���� ���� ������ ��
					break;  //�ݺ��� ����
				}
				q=p; //q�� p�� ����
				if(objectCompareToInteger(k,p.getKey())==1)
					p=p.getRight(); //k���� �� ū ��쿡 p�� ������ �־���
				else
					p=p.getLeft(); //k���� �� ���� ��쿡 p�� ���� �־���	
			}
			else
			{
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");
				return;
			}
		}
		TreeNode newNode = new TreeNode(k); //������ ��� ����
		if(rootNode == null) //root�� null�� ��쿡 
			rootNode = newNode; //root�� newNode�� �־���
		else
		{
			if(k instanceof String) //k�� ���ڿ��� ��
			{
				if(objectCompareToString(q.getKey(),newNode.getKey())==0) {
					//q�� k���� ���� ��� ����
				}
				else if(objectCompareToString(q.getKey(),newNode.getKey())==1) {
					q.setLeft(newNode); //q���� k������ ū ��쿡 ���ʿ� newNode ����
				}
				else
					q.setRight(newNode); //q���� k������ ���� ��쿡 �������ʿ� newNode ����
			}
			else if(k instanceof Integer) //k�� ������ ��
			{
				if(objectCompareToInteger(q.getKey(),newNode.getKey())==0) {
					//q�� k���� ���� ��� ����
				}
				else if(objectCompareToInteger(q.getKey(),newNode.getKey())==1) {
					q.setLeft(newNode); //q���� k������ ū ��쿡 ���ʿ� newNode ����
				}
				else
					q.setRight(newNode); //q���� k������ ���� ��쿡 �������ʿ� newNode ����
			}
			else
			{
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");
				return;
			}
		}
	}
	
	
	public TreeNode BSTsearch(Object k) //�Ű������� ���� ���� ã�� �޼ҵ�
	{
		TreeNode t = rootNode; //k�� �񱳸� ���� t
		while(t != null)
		{
			if(k instanceof String) //k�� ���ڿ��� ��
			{
				if(objectCompareToString(k,t.getKey())==0)
					return t; //���� ���� ã�����Ƿ� t��ȯ
				else if(objectCompareToString(k,t.getKey())==1)
					t=t.getRight(); //k���� t������ ũ�� t�� ���������� �̵�
				else
					t=t.getLeft(); //k���� t������ �����Ƿ� t�� �������� �̵�
			}
			else if(k instanceof Integer) //k�� ������ ��
			{
				if(objectCompareToInteger(k,t.getKey())==0)
					return t; //���� ���� ã�����Ƿ� t��ȯ
				else if(objectCompareToInteger(k,t.getKey())==1)
					t=t.getRight(); //k���� t������ ũ�� t�� ���������� �̵�
				else
					t=t.getLeft(); //k���� t������ �����Ƿ� t�� �������� �̵�
			}
			else
			{
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");
				return null;
			}
		}
		return null;
	}


	private TreeNode maxNode(TreeNode root) //�ִ밪 ��� ã�� �޼ҵ�
	{
		TreeNode p = root;
		if(p.getRight() == null) //p�� ������ ��尡 null�̸� ��ȯ
			return root;			
		else
			return maxNode(p.getRight()); //maxNode�Լ��� ��ȯ ȣ��
	}
	
	private TreeNode delete(TreeNode root, Object k)
	{
		TreeNode p = root;
		TreeNode q = p; //q�� �θ� p�� �ڽ�
		while(p != null)
		{
			if(k instanceof String) //k�� ���ڿ��� ��
			{
				if(objectCompareToString(k,p.getKey())==0) { //k�� ���� ���� ������ ��
					break;  //�ݺ��� Ż��
				}
				q=p; //q�� p�� �־���
				if(objectCompareToString(k,p.getKey())==1)
					p=q.getRight(); //k���� �� ū ��쿡 p�� ������ �־���
				else
					p=q.getLeft(); //k���� �� ���� ��쿡 p�� ���� �־���				
					
			}
			else if(k instanceof Integer) //k�� ������ ��
			{
				if(objectCompareToInteger(k,p.getKey())==0) { //k�� ���� ���� ������ ��
					break;  //�ݺ��� Ż��
				}
				q=p;
				if(objectCompareToInteger(k,p.getKey())==1)
					p=q.getRight(); //k���� �� ū ��쿡 p�� ������ �־���
				else
					p=q.getLeft(); //k���� �� ���� ��쿡 p�� ���� �־���
			}
			else
			{
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");
				return null;
			}
		}
		
		if(p == null) // �ƹ��͵� �� �� ���� ���(tree�� null�� ���)
		{
				return null;
		}
		if((p.getLeft() == null) && (p.getRight() == null)) //������ �ڽ� ��尡 ���� ���(�ܸ����)
		{
			if(p==root) //p�� root�� ���
				root=null; //root�� null�� �ٲ�
			else if(q.getLeft()==p) //p�� q�� left�̸�
				q.setLeft(null); //q�� left�� null�� ����
			else //p�� q�� right�̸�
				q.setRight(null); //q�� right�� null�� ����
		}
		else if((p.getLeft() == null ) || (p.getRight() == null)) //������ �ڽ� ��尡 �Ѱ��� ���
		{
			if(p==root) //p�� root�� ���
				root=null; //root�� null�� �ٲ�
			else if(q.getLeft()==p) { //q�� ���ʿ� p�� ���� ��
				if(p.getLeft()==null) //p�� �ڽĳ�尡 �����ʿ� ���� ��
					q.setLeft(p.getRight()); //q�� ������ p�� ���������� �ٲ�             p.left=thedelete(); ���
				else //p�� �ڽĳ�尡 ���ʿ� ���� ��
					q.setLeft(p.getLeft()); //q�� ������ p�� �������� �ٲ�
			}
			else { //q�� �����ʿ� p�� ���� ��
				if(p.getLeft()==null) //p�� �ڽĳ�尡 �����ʿ� ���� ��
					q.setRight(p.getRight()); //q�� �������� p�� ���������� �ٲ�
				else
					q.setRight(p.getLeft()); //q�� �������� p�� �������� ����
			}
		}
		else //�ڽ��� �ΰ��� ���
		{
			if(p==root) //p�� root�� ���
				root=null; //root�� null�� �ٲ�
			else if(q.getLeft()==p) { //q�� ���ʿ� p�� ���� ��
				q.setLeft(p.getRight()); //q�� ���ʿ� p�� ������ ����
				p.getRight().setLeft(p.getLeft()); //p�� �������� ���ʿ� p�� ������ ����
			}
			else { //q�� �����ʿ� p�� ���� ��
				q.setRight(p.getRight()); //q�� �����ʿ� p�� ������ ����
				p.getRight().setLeft(p.getLeft()); //p�� �������� ���ʿ� p�� ���� ����
			}
		}
		return root; //Ʈ�� ��ȯ
	}
	
	public void BSTdelete(Object k)
	{
		rootNode = delete(rootNode,k);
	}
	
	private void printNode(TreeNode n)
	{
		if(n != null)
		{
			System.out.print("(");
			printNode(n.getLeft());
			System.out.print(" " + n.getKey() + " ");
			printNode(n.getRight());
			System.out.print(")");
		}
	}
	
	public void print()
	{
		printNode(rootNode);
		System.out.println();
	}
	
	private int objectCompareToString(Object s1, Object s2) // Object�� ���� ���°� String�� ���
	{
		String a=(String)s1;
		String b=(String)s2;
		return a.compareTo(b); //������ 0, a�� �� ũ�� 1, a�� �� ������ -1
	}
	
	private int objectCompareToInteger(Object s1, Object s2) // Object�� ���� ���°� int�� ���
	{
		if((Integer)s1==(Integer)s2) //������ 0 ��ȯ
			return 0;
		else if((Integer)s1<(Integer)s2) //s2�� �� ũ�� -1��ȯ
			return -1;
		else
			return 1; //s1�� �� ũ�� 1��ȯ
	}
	
	public boolean split (BinarySearchTree bBST, BinarySearchTree cBST, Object x) {
		TreeNode Small= new TreeNode();	//������ Small
		TreeNode Large=new TreeNode();	//������ Large
		TreeNode S= Small;	//Small�� ���� ����(�̵��ϴ� ������)
		TreeNode L=	Large;	//Large�� ���� ����(�̵��ϴ� ������)
		TreeNode p=this.rootNode;	//p�� root������ ����
		
		while(p!=null) {	//p�� null�� ������ �ݺ��� ����
			if(x instanceof Integer) {	//x�� int���� ��
				if(objectCompareToInteger(x,p.getKey())==0) {	//���� ���� ������
					S.setRight(p.getLeft());	//p�� ���� ���� S�� �����ʿ� �־��ش�.
					L.setLeft(p.getRight());	//p�� ������ ���� L�� ���ʿ� �־��ش�.
					
					bBST.setRootNode(Small.getRight());	//bBSTƮ���� root�� Small�� ������ ������ ����
					cBST.setRootNode(Large.getLeft());	//cBSTƮ���� root�� Large�� ���� ������ ����
					
					return true;	//x ��ġ�� ã�ҹǷ� true ����
				}
				else if(objectCompareToInteger(x,p.getKey())<0) {	//ã�� ������ ũ�ٸ�
					L.setLeft(p);	//������ �����͸� �ű��
					L=p;			//L�� p�� �����.
					p=p.getLeft();	//p�� ��ġ�� p�� �������� �ٲ۴�.
				}
				else {	//ã�� ������ �۴ٸ�
					S.setRight(p);	//������ ������ ���� �ű��
					S=p;			//S�� l�� �����.
					p=p.getRight();	//p�� ��ġ�� p�� ���������� �ٲ۴�.
				}
			}
		}
		S.setRight(null);	//S�� �������� null�� �ٲ�
		L.setLeft(null);	//L�� ������ null�� �ٲ�
		bBST.setRootNode(Small.getRight());	//bBST�� root�� Small�� right�� ����
		cBST.setRootNode(Large.getLeft());	//cBST�� root�� Large�� left�� ����
		return false;	//���� ���� ã�� �������Ƿ� false����
		
	}
	
}
