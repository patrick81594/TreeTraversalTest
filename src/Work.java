import java.util.Scanner;
import java.util.Stack;

public class Work {
	static String input = "";
	static Scanner scan = new Scanner(System.in);
	


	public static String takeInput() {
		try{
		while(input != "doubleOp" || input != "inputTypeIncorrect"){
			String input = scan.next();
			input = checkString.treatString(input);
			if(input == "doubleOp"){
				System.out.println("Function has more than one operation concurrently. Please enter a valid function. ");
				takeInput();
				break;
			}
			if(input == "inputTypeIncorrect"){
				System.out.println("Function has an invalid character please enter any valid function i.e. (7*3+2-8)");
				takeInput();
				break;
			}
			else {
				break;
			}
		}
		//if (input == "doubleOp" || input == "inputTypeIncorrect") {
		//	takeInput();
		//}
		scan.close();
		}
		catch(IllegalArgumentException IAE){
			System.out.print("please re-enter a valid function ");
		}
		return input;

	}
	
	

	public static String Order(String in) {
		Stack<Character> stk = new Stack<Character>();
		for(int i = 0; i < in.length(); i++){
			while(i < in.length()){
				if(in.charAt(i) == '^'){
					
					stk.push(in.charAt(i-1));
					stk.push(in.charAt(i));
				}
				
			}
			while(i < in.length()){
				if( in.charAt(i) == '*' || in.charAt(i) == '/'){
					stk.push(in.charAt(i));
				}

			}
			while(i < in.length()){
				if(in.charAt(i) == '+' ||in.charAt(i) == '-'){
					stk.push(in.charAt(i));
				}

			}
		}
		return in;
	}
}
