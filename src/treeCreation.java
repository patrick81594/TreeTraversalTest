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
		    int intValue;
		    Node left, right;
			public Object inTree;
		    Boolean isOp;
		 
		    Node(char item) {
		        Value = item;
		        left = null;
		        right = null;
		         inTree = null;
		         isOp = true;
		    }
		    Node(int item){
		    	intValue = item;
		        left = null;
		        right = null;
		         inTree = null;
		    	isOp = false;
		    }

		}
	    public static  Node root;
	    static Node constructTree(Object[] toTree) {
	        
	    	Node test, rightNode, leftNode;
	 		int size = toTree.length;

	        for (int i = 0; i < size; i++) {
  
	            // If operation push into stack]
				System.out.println("whats going to string: " + toTree[i]);
	            if (checkString.isOperator(toTree[i].toString().charAt(0)) && toTree[i].toString().length() <= 1) {
	            	
		
	            		   test = new treeCreation.Node(toTree[i].toString().charAt(0));
	            		   rightNode = st.pop();
	            		   rightNode.inTree = 'r';
	                       leftNode = st.pop();
	                       leftNode.inTree = 'l';
	                       test.left = leftNode;
	                       test.right = rightNode;
	                       test.isOp = true;
	                       st.push(test);
	                
	            } else // number
	            {
	            	System.out.println("where here at the number thing: " + Integer.parseInt(toTree[i].toString()) );
	            	test = new Node(Integer.parseInt(toTree[i].toString()));
	            	System.out.print("node value" + test.intValue);
	            	test.isOp = false;
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
		  if(root.isOp == true) {
			  System.out.println("(" + root.Value + ")"); 
		  }else {
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
        if(node.isOp == true)
        inSb.append(node.Value + " ");
        else
        	inSb.append(node.intValue + " ");
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
        if(node.isOp == true)
        postSb.append(node.Value + " ");
        else
        	postSb.append(node.intValue + " ");
        String Sb = postSb.toString();
        return Sb;
    }
    static String printPreorder(Node node)
    {
        if (node == null)
            return null;
 
        /* first print data of node */
        if(node.isOp == true)
        preSb.append(node.Value + " ");
        else
        	preSb.append(node.intValue + " ");
       
 
        /* then recur on left subtree */
        printPreorder(node.left);
 
        /* now recur on right subtree */
        printPreorder(node.right);
        String Sb = preSb.toString();
        return Sb;
    }
}

