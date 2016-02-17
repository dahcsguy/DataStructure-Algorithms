import java.util.Stack;
public class BST <T extends Comparable<T>>{
	public static Node root;
	public BST(){
		this.root = null;	
	}
	public static void main(String []args){
		BST b = new BST();
		b.massInsert(new Integer[]{1,3,34,45,2,3,5,2,2,545,4});
		b.toPre();
		b.toPre2();
		System.out.println();
		b.toPost2();
		b.toPost();
		System.out.println();
		b.toIn();
		b.toIn2();
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
	public void toIn2(){
		toIn2(root);
		System.out.println();
	}
	private static void toIn2(Node root){
		Node current = root;
		if(root == null)
			return;
		Stack s = new Stack();
		
		while(current != null){
			s.push(current);
			current = current.left;
		}
		while(!s.empty()){
			current = (Node)s.pop();
			System.out.print(current.data+ " ");
			if(current.right != null){
				current = current.right;
				while(current != null){
					s.push(current);
					current = current.left;
				}
			}
		}
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
	public void toPre2(){
		toPre2(root);
		System.out.println();
	}
	private static void toPre2(Node root){
		Node current = root;
		if(root == null)
			return;
		Stack s = new Stack();
		s.push(current);
		while(!s.empty()){
			current = (Node)s.pop();
			System.out.print(current.data+" ");
			if(current.right!=null)
				s.push(current.right);
			if(current.left!=null)
				s.push(current.left);
		}
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
	public void toPost2(){
		toPost2(root);
		System.out.println();
	}
	private static void toPost2(Node root){
		Node current = root;
		if(root == null)
			return;
		Stack s = new Stack();
		Stack s2 = new Stack();
		s.push(current);
		while(!s.empty()){
			s2.push(s.peek());
			current = (Node)s.pop();
			if(current.left !=null)
				s.push(current.left);
			if(current.right!=null)
				s.push(current.right);
			
		}
		while(!s2.empty()){
			current = (Node)s2.pop();
			System.out.print(current.data + " ");
			
		}
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