import java.util.Scanner;
import java.util.Stack;
import checkString;
public class Work {
	static String input = "";
	static Scanner scan = new Scanner(System.in);
	


	public static String takeInput() {
		try{
		while(input != null){
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
			
		}
		scan.close();
		}
		catch(IllegalArgumentException IAE){
			System.out.print("please re-enter a valid function ");
		}
		return input;

	}
	
	class TreeConstruct {
		
		class Node {
			 
		    char value;
		    Node left, right;
		 
		    Node(char item) {
		        value = item;
		        left = right = null;
		    }
		}
	 

	    // Utility function to do inorder traversal
	    void inorder(Node t) {
	        if (t != null) {
	            inorder(t.left);
	            System.out.print(t.value + " ");
	            inorder(t.right);
	        }
	    }
	 
	    // Returns root of constructed tree for given
	    // inCharArray expression
	    Node constructTree(char inCharArray[]) {
	        Stack<Node> st = new Stack<Node>();
	        Node t, t1, t2;
	 
	        for (int i = 0; i < inCharArray.length; i++) {
	        	
   	
	        	
	 
	            // If number push into stack
	            if (!checkString.isOperator(inCharArray[i])) {
	                t = new Node(inCharArray[i]);
	                st.push(t);
	            } else // operation
	            {
	                t = new Node(inCharArray[i]);
	 
	                // Pop two top nodes
	                // Store top
	                t1 = st.pop();      // Remove top
	                t2 = st.pop();
	 
	                //  make them children
	                t.right = t1;
	                t.left = t2;
	 
	                // System.out.println(t1 + "" + t2);
	                // Add this subexpression to stack
	                st.push(t);
	            }
	        }
	 
	        //  only element will be root of expression
	        // tree
	        t = st.peek();
	        st.pop();
	 
	        return t;
	    }
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
