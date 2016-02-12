import java.util.*;
public class Stack{
	public static void main(String []args){

	}
	private int top;
	private Object array [];
	public Stack(){
		top = -1;
		array = new Object[10];
	}
	public Stack(int n){
		top = -1;
		array = new Object[n];
	}
	public void push(Object item){
		if(top == array.length-1){
			this.resize();
			array[++top] = item;
		}
		else
			array[++top] = item;
	}
	public Object peek(){
		if(top < 0){
			throw new EmptyStackException();
		}
		else
			return array[top];
	}
	public void pop(){
		if(top < 0)
			throw new EmptyStackException();
		else
			top--;
		
	}
	public void print(){
		for(int i = top;i>=0;i--){
			if(i==0)
				System.out.println(array[i]);
			else
				System.out.print(array[i]+" ");
		}
	}

	private void resize(){
		array = Arrays.copyOf(array,2*array.length);
	}
	
}