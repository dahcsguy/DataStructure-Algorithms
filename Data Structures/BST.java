public class BST <T extends Comparable<T>>{
	public static Node root;
	public BST(){
		this.root = null;	
	}
	
	public boolean find(Comparable n){
		Node current = root;
		while(current != null){
			if(n.equals(current.data))
				return true;
			else if(n.compareTo(current.data)>0)
				current = current.right;
			else
				current = current.left;
		}
		return false;
	}

	public void insert(Comparable n){
		
		if(root==null){
			root = new Node(n);
			return;
		}
		Node current = root;
		Node child = null;
		while(true){
			child = current;
			if(child.data.compareTo(n)>=0){				
				current = current.left;
				if(current==null){
					child.left = new Node(n);
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					child.right = new Node(n);
					return;
				}
			}
		}
	}
	public void toIn(){
		toIn(root);
		System.out.print("\n");
	}
	private static void toIn(Node root){
		if(root==null)
			return;
		toIn(root.left);
		System.out.print(root.data+" ");
		toIn(root.right);
	}
	public void toPre(){
		toPre(root);
		System.out.print("\n");
	}
	private static void toPre(Node root){
		if(root == null)
			return;
		
		System.out.print(root.data+ " ");
		toPre(root.left);
		toPre(root.right);
	}
	public void toPost(){
		toPost(root);
		System.out.print("\n");
	}
	private static void toPost(Node root){
		if(root == null)
			return;
		toPost(root.left);
		toPost(root.right);
		System.out.print(root.data+" ");
	}
	public void delete(Comparable n){
		this.root = delete(root,n);
	}
	private static Node delete(Node root, Comparable n){
		if(root == null)
			return root;
		else if(n.compareTo(root.data) > 0)
			root.right = delete(root.right,n);
		else if(n.compareTo(root.data) < 0)
			root.left = delete(root.left, n);
		else{
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else{
				
				Node leftMost = root.left;
				while(leftMost.right!=null){
					leftMost = leftMost.right;
				}
				root.data = leftMost.data;
				root.left = delete(root.left,root.data);
			}
		}
		return root;
	}
	public void massInsert(Comparable [] n){
		for(Comparable x : n){
			this.insert(x);
		}
	}
	
	
	
	
	
	private static class Node{
		Comparable data;
		Node left, right;
		public Node(Comparable data){	
			this.data = data;
			left = null;
			right = null;
		}
		
	}
	
}