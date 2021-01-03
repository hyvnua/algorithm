package week4_Algo;

public class BinarySearchTree {
private TreeNode rootNode;
	private void setRootNode(TreeNode t) {
		rootNode=t;
	}
	
	
	public void BSTinsert(Object k) //매개변수로 받은 값은 삽입하는 메소드
	{
		TreeNode p = rootNode;
		TreeNode q = p; //q가 부모 p가 자식
		
		while(p != null) //입력될 위치 찾기
		{
			if(k instanceof String) //k가 문자열일 때
			{
				if(objectCompareToString(k,p.getKey())==0) //k와 같은 값이 존재할 때
					break; //반복문 종료
				q=p;// q에 p를 넣음
				if(objectCompareToString(k,p.getKey())==1)
					p=q.getRight(); //k값이 더 큰 경우에 p에 오른쪽 넣어줌
				else
					p=q.getLeft(); //k값이 더 작은 경우에 p에 왼쪽 넣어줌
					
			}
			else if(k instanceof Integer) //k가 숫자일 때
			{
				if(objectCompareToInteger(k,p.getKey())==0) { //k와 같은 값이 존재할 때
					break;  //반복문 종료
				}
				q=p; //q에 p를 넣음
				if(objectCompareToInteger(k,p.getKey())==1)
					p=p.getRight(); //k값이 더 큰 경우에 p에 오른쪽 넣어줌
				else
					p=p.getLeft(); //k값이 더 작은 경우에 p에 왼쪽 넣어줌	
			}
			else
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
				return;
			}
		}
		TreeNode newNode = new TreeNode(k); //삽입할 노드 생성
		if(rootNode == null) //root가 null일 경우에 
			rootNode = newNode; //root에 newNode를 넣어줌
		else
		{
			if(k instanceof String) //k가 문자열일 때
			{
				if(objectCompareToString(q.getKey(),newNode.getKey())==0) {
					//q와 k값이 같을 경우 종료
				}
				else if(objectCompareToString(q.getKey(),newNode.getKey())==1) {
					q.setLeft(newNode); //q값이 k값보다 큰 경우에 왼쪽에 newNode 넣음
				}
				else
					q.setRight(newNode); //q값이 k값보다 작은 경우에 오른쪽쪽에 newNode 넣음
			}
			else if(k instanceof Integer) //k가 숫자일 때
			{
				if(objectCompareToInteger(q.getKey(),newNode.getKey())==0) {
					//q와 k값이 같을 경우 종료
				}
				else if(objectCompareToInteger(q.getKey(),newNode.getKey())==1) {
					q.setLeft(newNode); //q값이 k값보다 큰 경우에 왼쪽에 newNode 넣음
				}
				else
					q.setRight(newNode); //q값이 k값보다 작은 경우에 오른쪽쪽에 newNode 넣음
			}
			else
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
				return;
			}
		}
	}
	
	
	public TreeNode BSTsearch(Object k) //매개변수로 받은 값을 찾는 메소드
	{
		TreeNode t = rootNode; //k값 비교를 위한 t
		while(t != null)
		{
			if(k instanceof String) //k가 문자열일 때
			{
				if(objectCompareToString(k,t.getKey())==0)
					return t; //같은 값을 찾았으므로 t반환
				else if(objectCompareToString(k,t.getKey())==1)
					t=t.getRight(); //k값이 t값보다 크면 t의 오른쪽으로 이동
				else
					t=t.getLeft(); //k값이 t값보다 작으므로 t의 왼쪽으로 이동
			}
			else if(k instanceof Integer) //k가 숫자일 때
			{
				if(objectCompareToInteger(k,t.getKey())==0)
					return t; //같은 값을 찾았으므로 t반환
				else if(objectCompareToInteger(k,t.getKey())==1)
					t=t.getRight(); //k값이 t값보다 크면 t의 오른쪽으로 이동
				else
					t=t.getLeft(); //k값이 t값보다 작으므로 t의 왼쪽으로 이동
			}
			else
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
				return null;
			}
		}
		return null;
	}


	private TreeNode maxNode(TreeNode root) //최대값 노드 찾는 메소드
	{
		TreeNode p = root;
		if(p.getRight() == null) //p의 오른쪽 노드가 null이면 반환
			return root;			
		else
			return maxNode(p.getRight()); //maxNode함수를 순환 호출
	}
	
	private TreeNode delete(TreeNode root, Object k)
	{
		TreeNode p = root;
		TreeNode q = p; //q가 부모 p가 자식
		while(p != null)
		{
			if(k instanceof String) //k가 문자열일 때
			{
				if(objectCompareToString(k,p.getKey())==0) { //k와 같은 값이 존재할 때
					break;  //반복문 탈출
				}
				q=p; //q에 p를 넣어줌
				if(objectCompareToString(k,p.getKey())==1)
					p=q.getRight(); //k값이 더 큰 경우에 p에 오른쪽 넣어줌
				else
					p=q.getLeft(); //k값이 더 작은 경우에 p에 왼쪽 넣어줌				
					
			}
			else if(k instanceof Integer) //k가 숫자일 때
			{
				if(objectCompareToInteger(k,p.getKey())==0) { //k와 같은 값이 존재할 때
					break;  //반복문 탈출
				}
				q=p;
				if(objectCompareToInteger(k,p.getKey())==1)
					p=q.getRight(); //k값이 더 큰 경우에 p에 오른쪽 넣어줌
				else
					p=q.getLeft(); //k값이 더 작은 경우에 p에 왼쪽 넣어줌
			}
			else
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
				return null;
			}
		}
		
		if(p == null) // 아무것도 할 수 없는 경우(tree가 null인 경우)
		{
				return null;
		}
		if((p.getLeft() == null) && (p.getRight() == null)) //삭제할 자식 노드가 없는 경우(단말노드)
		{
			if(p==root) //p가 root일 경우
				root=null; //root를 null로 바꿈
			else if(q.getLeft()==p) //p가 q의 left이면
				q.setLeft(null); //q의 left를 null로 만듬
			else //p가 q의 right이면
				q.setRight(null); //q의 right를 null로 만듬
		}
		else if((p.getLeft() == null ) || (p.getRight() == null)) //삭제할 자식 노드가 한개인 경우
		{
			if(p==root) //p가 root일 경우
				root=null; //root를 null로 바꿈
			else if(q.getLeft()==p) { //q의 왼쪽에 p가 있을 때
				if(p.getLeft()==null) //p의 자식노드가 오른쪽에 있을 때
					q.setLeft(p.getRight()); //q의 왼쪽을 p의 오른쪽으로 바꿈             p.left=thedelete(); 재귀
				else //p의 자식노드가 왼쪽에 있을 때
					q.setLeft(p.getLeft()); //q의 왼쪽을 p의 왼쪽으로 바꿈
			}
			else { //q의 오른쪽에 p가 있을 때
				if(p.getLeft()==null) //p의 자식노드가 오른쪽에 있을 때
					q.setRight(p.getRight()); //q의 오른쪽을 p의 오른쪽으로 바꿈
				else
					q.setRight(p.getLeft()); //q의 오른쪽을 p의 왼쪽으로 ㅂ꿈
			}
		}
		else //자식이 두개인 경우
		{
			if(p==root) //p가 root일 경우
				root=null; //root를 null로 바꿈
			else if(q.getLeft()==p) { //q의 왼쪽에 p가 있을 때
				q.setLeft(p.getRight()); //q의 왼쪽에 p의 오른쪽 넣음
				p.getRight().setLeft(p.getLeft()); //p의 오른쪽의 왼쪽에 p의 왼쪽을 넣음
			}
			else { //q의 오른쪽에 p가 있을 떄
				q.setRight(p.getRight()); //q의 오른쪽에 p의 오른쪽 넣음
				p.getRight().setLeft(p.getLeft()); //p의 오른쪽의 왼쪽에 p의 왼족 넣음
			}
		}
		return root; //트리 반환
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
	
	private int objectCompareToString(Object s1, Object s2) // Object의 변수 형태가 String인 경우
	{
		String a=(String)s1;
		String b=(String)s2;
		return a.compareTo(b); //같으면 0, a가 더 크면 1, a가 더 작으면 -1
	}
	
	private int objectCompareToInteger(Object s1, Object s2) // Object의 변수 형태가 int인 경우
	{
		if((Integer)s1==(Integer)s2) //같으면 0 반환
			return 0;
		else if((Integer)s1<(Integer)s2) //s2가 더 크면 -1반환
			return -1;
		else
			return 1; //s1이 더 크면 1반환
	}
	
	public boolean split (BinarySearchTree bBST, BinarySearchTree cBST, Object x) {
		TreeNode Small= new TreeNode();	//고정된 Small
		TreeNode Large=new TreeNode();	//고정된 Large
		TreeNode S= Small;	//Small의 값을 받음(이동하는 포인터)
		TreeNode L=	Large;	//Large의 값을 받음(이동하는 포인터)
		TreeNode p=this.rootNode;	//p는 root값으로 설정
		
		while(p!=null) {	//p가 null일 때까지 반복문 진행
			if(x instanceof Integer) {	//x가 int형일 때
				if(objectCompareToInteger(x,p.getKey())==0) {	//같은 값이 나오면
					S.setRight(p.getLeft());	//p의 왼쪽 값을 S의 오른쪽에 넣어준다.
					L.setLeft(p.getRight());	//p의 오른쪽 값을 L의 왼쪽에 넣어준다.
					
					bBST.setRootNode(Small.getRight());	//bBST트리의 root를 Small의 오른쪽 값으로 설정
					cBST.setRootNode(Large.getLeft());	//cBST트리의 root를 Large의 왼쪽 값으로 설정
					
					return true;	//x 위치를 찾았므로 true 리턴
				}
				else if(objectCompareToInteger(x,p.getKey())<0) {	//찾는 값보다 크다면
					L.setLeft(p);	//라지의 포인터를 옮긴다
					L=p;			//L을 p로 덮어씌움.
					p=p.getLeft();	//p의 위치를 p의 왼쪽으로 바꾼다.
				}
				else {	//찾는 값보다 작다면
					S.setRight(p);	//스몰의 포인터 값을 옮긴다
					S=p;			//S를 l로 덮어씌움.
					p=p.getRight();	//p의 위치를 p의 오른쪽으로 바꾼다.
				}
			}
		}
		S.setRight(null);	//S의 오른쪽을 null로 바꿈
		L.setLeft(null);	//L의 왼쪽을 null로 바꿈
		bBST.setRootNode(Small.getRight());	//bBST의 root를 Small의 right로 설정
		cBST.setRootNode(Large.getLeft());	//cBST의 root를 Large의 left로 설정
		return false;	//같은 값을 찾지 못했으므로 false리턴
		
	}
	
}
