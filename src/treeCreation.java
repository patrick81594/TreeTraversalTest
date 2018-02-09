import java.sql.Struct;
import java.util.EmptyStackException;
import java.util.Stack;





public class treeCreation {
	static StringBuilder inSb = new StringBuilder();
	static StringBuilder preSb = new StringBuilder();
    static StringBuilder postSb = new StringBuilder();	
    static Stack<Node> st = new Stack<Node>();

		static class Node {

		    char Value;
		    Node left, right;
			public Object inTree;
		    
		 
		    Node(char item) {
		        Value = item;
		        left = null;
		        right = null;
		         inTree = null;
		    }

		}
	    public static  Node root;
	    static Node constructTree(char[] postArray) {
	        
	    	Node test, rightNode, leftNode;
	 		int size = postArray.length;

	        for (int i = 0; i < size; i++) {
  
	            // If operation push into stack]
				System.out.println("whats going to string: " + postArray[i]);
	            if (checkString.isOperator(postArray[i])) {
	            	
		
	            		   test = new treeCreation.Node(postArray[i]);
	            		   rightNode = st.pop();
	            		   rightNode.inTree = 'r';
	                       leftNode = st.pop();
	                       leftNode.inTree = 'l';
	                       test.left = leftNode;
	                       test.right = rightNode;
	                       
	                       st.push(test);
	                
	            } else // number
	            {
	            	test = new Node(postArray[i]);
                    st.push(test);
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

