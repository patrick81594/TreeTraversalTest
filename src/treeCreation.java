import java.sql.Struct;
import java.util.EmptyStackException;
import java.util.Stack;





public class treeCreation {
	static StringBuilder inSb = new StringBuilder();
	static StringBuilder preSb = new StringBuilder();
    static StringBuilder postSb = new StringBuilder();		
    public  Node root;
		class Node {

		    Object Value;
		    Node left, right;
		 
		    Node(Node left, Object item, Node right) {
		        Value = item;
		        this.left = left;
		        this.right = right;
		    }

		}

	    Node constructTree(Object[] array) {
	        Stack<Node> st = new Stack<Node>();
	        
	 		int size = array.length;
	 		int oppCount = 0;
	        for (int i = 0; i < size; i++) {
  
	            // If operation push into stack]
				System.out.println("whats going to string: " + array[i].toString());
	            if (checkString.isOperator(array[i])) {
	            	
		
	            		
	            		   Node rightNode = st.pop();

	                       Node leftNode = st.pop();
	                       st.push(new Node(leftNode, array[i], rightNode));
	                
	            } else // number
	            {
	            	st.push(new Node(null, array[i], null));
	            }
	        }
	        System.out.println("root: " + st.peek().Value);
	        //System.out.println("root: " + st.peek().left.Value);
	        //System.out.println("root: " + st.peek().right.Value);
            root = st.pop();

	 
	        return root;
	    }


	    
		static int  kWidth = 6 ;
		static void PrintSpace(int n)
		{
		  for (int i = 0; i < n; ++i)
			  System.out.print(" ");
		}

		static void PrintTree(Node root, int level)
		{
		  if (root == null) return;
		  PrintTree(root.right, level + 1);
		  PrintSpace(level * kWidth);
		  System.out.println(root.Value);
		  PrintTree(root.left, level + 1);
		}


    static String printInorder(Node node)
    {
        if (node == null)
            return null;
 
        /* first recur on left child */
        printInorder(node.left);
        inSb.append(node.Value + "");
 
        /* now recur on right child */
        printInorder(node.right);
        String Sb = inSb.toString();
        return Sb;
    }
 
    static String printPostorder(Node node)
    {
        if (node == null)
            return null;
 
        // first recur on left subtree
        printPostorder(node.left);
 
        // then recur on right subtree
        printPostorder(node.right);
 
        // now deal with the node
        postSb.append(node.Value + "");
        String Sb = postSb.toString();
        return Sb;
    }
    static String printPreorder(Node node)
    {
        if (node == null)
            return null;
 
        /* first print data of node */
        preSb.append(node.Value + "");
       
 
        /* then recur on left subtree */
        printPreorder(node.left);
 
        /* now recur on right subtree */
        printPreorder(node.right);
        String Sb = preSb.toString();
        return Sb;
    }
}

