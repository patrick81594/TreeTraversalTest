import java.sql.Struct;
import java.util.EmptyStackException;
import java.util.Stack;





public class treeCreation {
	static StringBuilder inSb = new StringBuilder();
	static StringBuilder preSb = new StringBuilder();
    static StringBuilder postSb = new StringBuilder();	
    static Stack<Node> st = new Stack<Node>();
    
    static void clearSB() {
    	inSb = new StringBuilder();
    	preSb = new StringBuilder();
    	postSb = new StringBuilder();
    }
		static class Node {

		    char Value;
		    Node left, right;
			public Object inTree;
			int intValue;
			boolean isOp;
		    
		 
		    Node(char postArray) {
		        Value = postArray;
		        left = null;
		        right = null;
		         inTree = null;
		         isOp = true;
		    }
		    Node(int postArray) {
		        intValue = postArray;
		        left = null;
		        right = null;
		         inTree = null;
		         isOp = false;
		    }

		}
		
	    public static  Node root;
	    static Node constructTree(Object[] postArray) {
	        
	    	Node test, rightNode, leftNode;
	 		int size = postArray.length;

	        for (int i = 0; i < size; i++) {
  
	            // If operation push into stack]
				System.out.println("whats going to string: " + postArray[i]);
				System.out.println(postArray[i].toString().charAt(0));
	            if (checkString.isOperator(postArray[i].toString().charAt(0)) && postArray[i].toString().length() <= 1) {
	            	
	            		System.out.println(postArray[i].toString().charAt(0));
	            		
	            		   test = new treeCreation.Node(postArray[i].toString().charAt(0));
	            		   rightNode = st.pop();
	            		   rightNode.inTree = 'r';
	                       leftNode = st.pop();
	                       leftNode.inTree = 'l';
	                       test.left = leftNode;
	                       test.right = rightNode;
	                       
	                       st.push(test);
	                
	            } else // number
	            {
	            	test = new Node(Integer.parseInt(postArray[i].toString()));
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
		static void PrintSpace(int n, Node root)
		{
		  for (int i = 0; i < n; ++i)
		      if(i == (n-2)) {
		    	  
		      
			  switch((char)root.inTree)
		        {
		            case 'l':
		            System.out.print("\\");
		            return;
		            case 'r':
		            System.out.print("/");
		            return;


		        }
		      }
		      else {
			  System.out.print(" ");
		      }
}

		static void PrintTree(Node root, int level)
		{
	
		  if (root == null) return;
		  PrintTree(root.right, level + 1);
		  PrintSpace(level * kWidth, root);
		  if(root.isOp){
		  System.out.println("(" + root.Value + ")");
		  }
		  else{
			  System.out.println("(" + root.intValue + ")"); 
		  }
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

