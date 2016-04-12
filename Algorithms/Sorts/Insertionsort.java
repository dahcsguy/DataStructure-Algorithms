public class Insertionsort<T extends Comparable<T>>{
	public static void main(String []args){

	}
	public static void IS(Comparable []  array){
		int counter = 1;
		while(counter<array.length){
			print(array);
			for(int i = counter; i>0; i--){
				if(array[i].compareTo(array[i-1])<0){
					Comparable temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
				}
				else
					break;
			}
			counter++;
			
		}
	}
	public static void print(Comparable []array){
		for(int i = 0; i< array.length;i++){
			if(i!=array.length-1)
				System.out.print(array[i]+", ");
			else
				System.out.print(array[i]+"\n");
		}
	}
}