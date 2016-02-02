public class Selectionsort <T extends Comparable<T>>{
	public static void main(String []args){
		
	}
	public static void IS(Comparable [] array){
		int counter = array.length;
		
		while(counter>0){
			Comparable min = array[array.length-counter];
			int position = array.length-counter;
			for(int i = array.length-counter+1;i<array.length;i++){
				if(min.compareTo(array[i])>0){
					min = array[i];
					position = i;
				}
			}
			if(position != array.length-counter){
				Comparable temp = array[array.length-counter];
				array[array.length-counter] = min;
				array[position] = temp;
			}
				counter--;
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