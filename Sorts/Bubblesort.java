public class Bubblesort <T extends Comparable<T>> {
	public static void main(String []args){

	}
	public static void BS(Comparable [] array){
		int counter = array.length-1;
		boolean swap =  true;
		while(counter>=0&&swap){
			swap = false;
			for(int i = 0; i<counter;i++){
				if(array[i].compareTo(array[i+1])>0){
					Comparable temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					swap = true;
				}
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