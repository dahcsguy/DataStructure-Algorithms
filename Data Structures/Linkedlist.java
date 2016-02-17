public class Linkedlist{
	public static Node head;
	public Linkedlist(){
		this.head = null;
	}
	public void add(int data){
		if(head == null){
			Node n = new Node(data);
			n.next = head;
			head = n;
		}
		else{
			Node n = new Node(data);
			Node current = head;
			while(current.next!=null){
				current = current.next;
			}
			current.next = n;
		}
	}
	public int size(){
		int size = 0;
		Node temp = head;
		while(temp!=null){
			size++;
			temp = temp.next;
		}
		return size;
	}
	public void addBegin(int data){
		Node n = new Node(data);
		n.next = head;
		head = n;
	}
	public void reverse1(){
		reverse1(head);
	}
	private static void reverse1(Node n){
		
		if(n== null){
			return;
		}
		if(n.next == null){
			head = n;
			return;
		}
		reverse1(n.next);
		n.next.next = n;
		n.next = null;
		
	}
	public static void reverse2(){
		Node current, prev, next;
		current = head;
		
		prev = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	public void reversePrint(){
		reversePrint(head);
		System.out.println();
	}
	private static void reversePrint(Node n){
		if(n == null)
			return;
		reversePrint(n.next);
		System.out.print(n.data+" ");
	}
	public int elementAt(int num){
		Node temp = head;
		int counter = 0;
		while(counter<=num&&temp!=null){
			if(counter == num)
				return temp.data;
			counter++;
			temp = temp.next;
		}
		return -1;
	}
	
	
	public void print(){
		Node current = head;
		while(current!=null){
			
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println("");
	}
	
	public static void main(String []args){

	}
	private static class Node{
		int data;
		Node next;
		public Node(int data){	
			this.data = data;
			next = null;
		}
		
	}
}