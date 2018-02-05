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
		Stack<Character> opperandStack = new Stack<>();
		Stack<Integer> numStack = new Stack<>();
		Stack<Object> combStack = new Stack<>();
        int j;
        int i;
        int numOpp = countOpp(in);
        int seenOpp = 0;

		for(i=0; i < in.length(); i++) {
            j = i - 1;
            if (in.charAt(i) == '+' || in.charAt(i) == '-') {
                combStack.push(in.charAt(i));
                seenOpp++;
                while (in.charAt(j) != '/' && in.charAt(j) != '+' && in.charAt(j) != '-' && in.charAt(j) != '*' && in.charAt(j) != '^') {
                    combStack.push(Integer.parseInt(String.valueOf(in.charAt(j))));
                    j--;
                    if (j == -1) {
                        break;
                    }
                }

                j = i + 1;
                if (i == 1) {
                } else {
                    while (j < in.length() && in.charAt(j) != '/' && in.charAt(j) != '+' && in.charAt(j) != '-' && in.charAt(j) != '*' && in.charAt(j) != '^') {
                        combStack.push(Integer.parseInt(String.valueOf(in.charAt(j))));
                        j++;
                        if (j >= in.length()) {
                            break;
                        }
                    }
                }
            }
        }
        for(i=0; i < in.length(); i++) {
            j = i - 1;
            if (in.charAt(i) == '*' || in.charAt(i) == '/') {
                combStack.push(in.charAt(i));
                seenOpp++;
                while (in.charAt(j) != '/' && in.charAt(j) != '+' && in.charAt(j) != '-' && in.charAt(j) != '*' && in.charAt(j) != '^') {

                    combStack.push(Integer.parseInt(String.valueOf(in.charAt(j))));
                    j--;
                    if (j == -1) {
                        break;
                    }
                }

                j = i + 1;
                if (i == 1) {
                } else {
                    while (in.charAt(j) != '/' && in.charAt(j) != '+' && in.charAt(j) != '-' && in.charAt(j) != '*' && in.charAt(j) != '^' && j < in.length()) {
                        combStack.push(Integer.parseInt(String.valueOf(in.charAt(j))));
                        j++;
                        if (j >= in.length()) {
                            break;
                        }
                    }
                }
            }
        }
        for(i=0; i < in.length(); i++) {
            j = i - 1;
            if (in.charAt(i) == '^') {
                combStack.push(in.charAt(i));
                seenOpp++;
                while (in.charAt(j) != '/' && in.charAt(j) != '+' && in.charAt(j) != '-' && in.charAt(j) != '*' && in.charAt(j) != '^') {
                    combStack.push(Integer.parseInt(String.valueOf(in.charAt(j))));
                    j--;
                    if (j == -1) {
                        break;
                    }
                }
                j = i + 1;

                if (i == 1) {
                } else {
                    while (in.charAt(j) != '/' && in.charAt(j) != '+' && in.charAt(j) != '-' && in.charAt(j) != '*' && in.charAt(j) != '^' && j < in.length()) {
                        combStack.push(Integer.parseInt(String.valueOf(in.charAt(j))));
                        j++;
                        if (j >= in.length()) {
                            break;
                        }
                    }
                }

            }
        }






		int fullSize = combStack.size();
		Object[] test = new Object[fullSize];
		    for(int k = 0; k<fullSize; k++) {
              test[k] = combStack.pop();
              System.out.println(test[k] +" Please?");
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
}

