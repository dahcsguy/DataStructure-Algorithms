/**
*	@author Wayne Zhang
*	Algoritms CMSC 301
*	February 20, 2016
*	Brute force 3SAT Solver
*	File Names			Run Times (mili. sec.)
*	s20.cnf				322
*	s28.cnf				55884
*	s57-100.cnf			
*	s65-100.cnf
*	u15.cnf				83
*	u27.cnf				59138
*	u29.cnf				244970
*	u30.cnf				452363
*	u100.cnf
*/
import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class SATBrute{
	public static Integer variables;
	public static void main(String []args) throws IOException{
		Scanner s = new Scanner(System.in);
		String line = null;
		Integer clauses = null;
		variables = null;
		
		LinkedList<Integer>[] formula = null;
		int counter = 0;
		double currentTime;
		System.out.print("Please enter in a file name: ");
		try{
			String fileName = s.nextLine();;
			currentTime = System.currentTimeMillis();
			s = new Scanner(new BufferedReader(new FileReader(fileName)));
			while(s.hasNextLine()){
				line = s.nextLine();
				//ignores comment in file
				if(line.charAt(0)=='c')
					continue;
				//store # of variables and # of clauses
				else if(line.charAt(0)=='p'){
					String split [] = line.split("\\s+");
					variables = Integer.parseInt(split[2]);
					clauses = Integer.parseInt(split[3]);
					formula = new LinkedList[clauses];
				}
				//store variables into a linkedlist
				else{
					//deletes all leading and trailing white spaces
					String split [] = line.replaceAll("^\\s+", "").replaceAll("\\s+$", "").split("\\s+");
					int i = 0;
					while(!split[i].equals("0")){
						if(formula[counter] == null)
							formula[counter] = new LinkedList<Integer>();
						formula[counter].add(Integer.parseInt(split[i]));
						i++;
					}
					counter++;
				}
			}
		}
		finally{
			if(s != null){
				s.close();
			}
		}
		boolean andStates = false;
		//there are 2^variables combinations 
		for(long i = (long)Math.pow(2,variables)-1; i>=0;i--){
			andStates = true;
			//turns i to a binary that is the length of variables
			String binary = fullLength(Long.toString(i,2));
			
			for(int j = 0; j<formula.length;j++){
				
				boolean orStates = false;
				for(Integer num : formula[j]){
					if(num < 0){
						num*=-1;
						orStates = orStates||!checkChar(binary.charAt(num-1));
					}
					else{
						orStates = orStates||checkChar(binary.charAt(num-1));
					}
					//if there is at least 1 true in the or statement we can proceed to the next clause
					if(orStates == true)
						break;
					
				}
				andStates = andStates&&orStates;
				//if the and statement is false then we proceed to the next combination
				if(!andStates)
					break;
				
			}

			//a combination is valid
			if(andStates){
				System.out.println("Wow, it worked! (1 = True & 0 = False)");
				System.out.println("The satisfying combination is: "+binary);
				break;
			}
			
			//none of the combinations are satisfiable
			if(i==0)
				System.out.println("Darn, it's not satisfiable");
		}
		
		
		
		//amount of time it took
		System.out.print("It took "+(System.currentTimeMillis()-currentTime)+" milliseconds.");
		
	}
	public static String fullLength(String s){
		//return the 0 variables - s.length() times + s
		int originalLength = s.length();
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0; i< variables-originalLength;i++){
			sb.insert(0,"0");
			
		}
		return sb.toString();
	}
	public static boolean checkChar(char c){
		//1 = true & everything else(0) = false
		return c == '1';
	}
	
	
}