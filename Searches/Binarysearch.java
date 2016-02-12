public class Binarysearch<T extends Comparable<T>>{
	public static void main(String []args){
	}
	public static int BS(Comparable [] array, int target){
		return BS(array,targset,0, array.length);
	}
	public static int BS(Comparable [] array, Comparable target, int min, int max){
		if(max<min)
			return -1;
		int mid = (min+max)/2;
		if(target.compareTo(array[mid])<0)
			return BS(array,target,min,mid-1);
		else if(target.compareTo(array[mid])>0)
			return BS(array,target,mid+1,max);
		else
			return mid;
	}
}
