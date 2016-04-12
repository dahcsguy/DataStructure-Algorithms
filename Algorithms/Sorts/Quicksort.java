public class Quicksort <T extends Comparable<T>>{
	public static void main(String[]args){
		
	}
	public static void QS(Comparable []array){
		QS(array,0,array.length-1);
	}
	public static void QS(Comparable [] array, int low, int high){
		if(low < high){
			int pivot = Partition(array, low, high);
			QS(array, low, pivot-1);
			QS(array, pivot+1,high);
		}
		
		
		
	}
	public static int Partition(Comparable [] array, int low, int high){
		print(array);
		swap(array,low,(low+high)/2);
		Comparable pivot = array[low];
		int i = low+1;
		int j = high;
		while (i<=j){
		
			while(array[j].compareTo(pivot)>0)
				j--;
			while(i<=j&&array[i].compareTo(pivot)<=0)
				i++;
			if(i<=j){
				swap(array,i,j);
				i++;
				j--;
			}
		}
		swap(array,low,j);
		return j;
		
	}
	public static void swap(Comparable [] array,int x, int y){
		Comparable temp = array[x];
		array[x] = array[y];
		array[y] = temp;
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