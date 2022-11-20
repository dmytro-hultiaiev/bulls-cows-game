import java.util.Scanner;

class Number {
	private int number;
	private int numberArray[];
  
	Number(){
		number = (int)(Math.random()*9000 + 1000);
		numberArray = new int[4];
		int number_tmp = number;
		
		for(int i = 3; i >= 0; i--) {
			numberArray[i] = number_tmp % 10;
			number_tmp /= 10;
		}
	}
	
	Number(int num){
		number = num;
		numberArray = new int[4];
		int number_tmp = number;
		
		for(int i = numberArray.length - 1; i >= 0; i--) {
			numberArray[i] = number_tmp % 10;
			number_tmp /= 10;
		}
	}
  
	public int getNumber() {
		return number;
	}
	
	public int[] getNumberArray(){
		return numberArray;
	}
  
	public int mechanics(int num){
		
		if(((int)(Math.log10(num))+1) == 4) {
		     Number b = new Number(num); 
		     int tmp = 0;
		     int tmp_num;
		     
		     for(int i = 0; i < b.getNumberArray().length; i++) {
		    	 
		    	 tmp_num = 0;
		    	 int j = 0;
		    	 boolean check = true;
		    	 
		    	 while(j < numberArray.length && check == true) {
		    		 if(b.getNumberArray()[i] == numberArray[j]) {
		    			 if(i == j) {
		    				 System.out.println("Number " + numberArray[j] + " is bull");
		    				 tmp++;
		    				 check = false;
		    			 }
		    			 else {
		    				 System.out.println("Number " + numberArray[j] + " is cow");
		    			 }
		    		 }
		    		 
		    		 j++;
		    	 }
		    	 
		     }
		     
		     if(tmp == 4) {
		    	 return 2;
		     } else {
		    	 return 1;
		     }
		}
		else {
			return 0;
		}
	}
}

public class Game {
	public static void main(String[] args) {
		Number a = new Number();
		boolean game = true;
		int attempts = 0;
	    
	    while(game){
	    	
	        Scanner in = new Scanner(System.in);
	        System.out.println("");
	        System.out.print("Input a number: ");
	        int num = in.nextInt();
	    	
	    	int tmp = a.mechanics(num);
	    	
	    	switch (tmp){
	    		case 0: 
	    			System.out.println("Error! Enter a four-digit number");
	    			break;
	    		case 1:
	    			System.out.println("Try again");
	    			attempts++;
	    			break;
	    		case 2:
	    			attempts++;
	    			game = false;
	    			break;
	    		default:
	    			System.out.println("System error!");
	    	}
	    }
    
	    System.out.println("");
	    System.out.println("You are win! Guessed number was " + a.getNumber() + ". Your number of attempts is " + attempts);
  }
}