import java.util.EmptyStackException;
import java.util.Stack;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class treeCreation {
	static StringBuilder inSb = new StringBuilder();
	static StringBuilder preSb = new StringBuilder();
    static StringBuilder postSb = new StringBuilder();		
		class Node {

		    Object Value;
		    Node left, right;
		 
		    Node(Object item) {
		        Value = item;
		        left = right = null;
		    }

		}

	    Node constructTree(Object[] array,int countOpp) {
	        Stack<Node> st = new Stack();
	        Node t, t1, t2;
	        int seenOpp = 0;
	        int count = countOpp;
	 		int size = array.length;
	        for (int i = 0; i < size; i++) {
	        	
   	
	        	
	 
	            // If number push into stack]
				System.out.println("whats going to string: " + array[i].toString());
	            if (!checkString.isOperator(array[i])) {
	                t = new Node((int)array[i]);
	                st.push(t);
	                
	            } else // operation
	            {
	            	seenOpp++;
	                t = new Node(array[i]);
	 
	                // Pop two top nodes
	                // Store top
	                t1 = st.pop();      // Remove top

	                t2 = st.pop();
	                t.right = t2;
	                
	                //  make them children

	                t.left = t1;
	 
	                // System.out.println(t1 + "" + t2);
	                // Add this subexpression to stack
	                st.push(t);
	            }
	        }
	 
	        //  only element will be root of expression
	        // tree
	        System.out.print("root:" + st.peek().Value);
	        t = st.peek();
	        st.pop();
	 
	        return t;
	    }
	    static String inorder(Node t) {
	        if (t != null) {
	            inorder(t.left);
	            
	            inSb.append((t.Value + " "));
	            System.out.println("tval: " + t.Value);
	            inorder(t.right);

	        }
	        String Sb = inSb.toString();
	        return Sb;
	    }

    static String preOrder(Node t) {

		    if (t != null) {
            inorder(t.left);
            inorder(t.right);
            preSb.append((t.Value + " "));
        }
		    String Sb = preSb.toString();
		    return Sb;
    }
}

