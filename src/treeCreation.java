import java.util.Stack;

public class treeCreation {
		
		class Node {
			 
		    char value;
		    Node left, right;
		 
		    Node(char item) {
		        value = item;
		        left = right = null;
		    }
		}
	 

	    // Utility function to do inorder traversal
	 
	    // Returns root of constructed tree for given
	    // inCharArray expression
	    Node constructTree(char inCharArray[]) {
	        Stack<Node> st = new Stack<Node>();
	        Node t = null, t1, t2;
	 
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
	    static void inorder(Node t) {
	        if (t != null) {
	            inorder(t.left);
	            System.out.print(t.value + " ");
	            inorder(t.right);
	        }
	    }
}

