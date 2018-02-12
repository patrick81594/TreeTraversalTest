import java.util.Scanner;
import java.util.Stack;

import java.util.Arrays;

public class Work {
	static String input;
	static String checked;
	public static Scanner scan = new Scanner(System.in);
	


	public static String takeInput() {
		try{
		while(input != "doubleOp" || input != "inputTypeIncorrect"){
			input = Testt.inputTxt.getText();
			System.out.print(input);
			checked = checkString.treatString(input);

			if(checked == "doubleOp"){
				System.out.println("Function has more than one operation concurrently. Please enter a valid function. ");
				takeInput();
				break;
			}
			if(checked == "inputTypeIncorrect"){
				System.out.println("Function has an invalid character please enter any valid function i.e. (7*3+2-8)");
				takeInput();
				break;
			}
			if(checked == "goodInput"){
				break;
			}

		}
		if (checked == "doubleOp" || checked == "inputTypeIncorrect") {
			takeInput();
		}
		scan.close();
		return input;
		}
		catch(IllegalArgumentException IAE){
			System.out.print("please re-enter a valid function ");
		}
		return input;

	}
	
	

	public static Object[] Order(String in) {

		Stack<Object> combStack = new Stack<>();




		int fullSize = combStack.size();
		Object[] test = new Object[fullSize];
		    for(int k = 0; k<fullSize; k++) {
		    	System.out.println(combStack.peek());
		    	test[k] = combStack.pop();

            }


		return test;
	}
    public static int countOpp(String in){
	    int count = 0;
        for(int i = 0; i< in.length();i++) {
            if (checkString.isOperator(in.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    public static double answer = 0;

	static void calculation(treeCreation.Node node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        calculation(node.left);
        switch(node.Value) {
        	case '+':
        		if(node.left.isOp) {
        			answer = (answer + node.right.intValue);
        		}
        		else{
        			answer = answer + (node.left.intValue + node.right.intValue);
        		}
        		Testt.result = answer;
        	return;
        	case '-':
        		if(node.left.isOp) {
        			answer = (answer - node.right.intValue);
        		}
        		else{
        			answer = answer + (node.left.intValue - node.right.intValue);
        		}
        		Testt.result = answer;
        	return;
        	case '*':
        		if(node.left.isOp) {
        			answer = (answer * node.right.intValue);
        			System.out.println("checkval does right: " +answer);
        		}
        		else{
        			answer = answer + (node.left.intValue * node.right.intValue);
        			System.out.println("checkval in right: " +answer + "left" + node.left.intValue + "right" + node.right.intValue);
        		}
        		Testt.result = answer;
        	return;
        	case '/':
        		if(node.left.isOp) {
        			answer = (answer / node.right.intValue);
        			System.out.println("checkdiv does right: " +answer + "left" + node.left.intValue + "right" + node.right.intValue);
        		}
        		else{
        			answer = answer + (node.left.intValue / node.right.intValue);
        			System.out.println("checkdiv in right: " +answer + "left" + node.left.intValue + "right" + node.right.intValue);
        		}
        		Testt.result = answer;
        	return;
        	case '^':
        		if(node.left.isOp) {
        			answer = Math.pow(answer, node.right.intValue);
        		}
        		else{
        			answer = answer + Math.pow(node.left.intValue, node.right.intValue);
        		}
        		Testt.result = answer;
        	return;
      
        }
        calculation(node.right);
       
        System.out.println("answer" + answer);
        Testt.result = answer;

    }





}

