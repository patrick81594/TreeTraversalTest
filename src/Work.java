import java.util.Scanner;

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
	
	


    public static int countOpp(String in){
	    int count = 0;
        for(int i = 0; i< in.length();i++) {
            if (checkString.isOperator(in.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    static double answer = 0;

    
   
	static void calculation(treeCreation.Node node)
    {
        if (node == null)
            return;
 
     
        calculation(node.left);
        switch(node.Value.toString().charAt(0)) {
    	case '+':
    	answer = answer + ((int)node.left.Value + (int)node.right.Value);
    	System.out.println("ans: " +answer);
    	return;
    	case '-':
    	answer = answer + ((int)node.left.Value - (int)node.right.Value);
    	return;
    	case '*':
    		answer = answer + Math.multiplyExact(Integer.parseInt(node.left.Value.toString()), Integer.parseInt(node.right.Value.toString()));

    	return;
    	case '/':
    		answer = answer + (Integer.parseInt(node.left.Value.toString()) / Integer.parseInt(node.right.Value.toString()));
    	return;
    	case '^':
    	answer = answer + (Math.pow((int)node.left.Value, (int)node.right.Value));
    	return;
  
    }
        //System.out.println(answer);
        calculation(node.right);
        switch(node.Value.toString().charAt(0)) {
    	case '+':
    	answer = answer + ((int)node.left.Value + (int)node.right.Value);
    	System.out.println("ans: " +answer);
    	return;
    	case '-':
    	answer = answer + ((int)node.left.Value - (int)node.right.Value);
    	return;
    	case '*':
    		answer = answer + Math.multiplyExact((int)node.left.Value, (int)node.right.Value);

    	return;
    	case '/':
    		answer = answer + ((int)node.left.Value / (int)node.right.Value);
    	return;
    	case '^':
    	answer = answer + (Math.pow((int)node.left.Value, (int)node.right.Value));
    	return;
  
    }
        Testt.result = answer;

    }



	private static int checkValue(char value) {
		// TODO Auto-generated method stub
		switch(value) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		}
		return 0;
	}

}

