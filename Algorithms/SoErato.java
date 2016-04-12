import java.util.*;
public class SoErato{
	public static void main(String []args){
		
	}
	public static ArrayList generateP(int n) {
		ArrayList<Integer> prime = new ArrayList();
		boolean[] numbers = new boolean[n + 1];
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (!numbers[i]) {
				prime.add(i);
				for (int j = (int)Math.pow(i,2); j <= n; j += i)
					numbers[j] = true;
			}
		}
		for (int i = (int)Math.sqrt(n)+1; i<= n; i++){
			if (!numbers[i])
			prime.add(i);
		}
		return prime;
	}

}