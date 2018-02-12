import java.util.Stack;

public class postFix {

    static int precedence(String g)
    {
        switch(g.charAt(0))
        {
            case '+':
            case '-':
            return 1;

            case '*':
            case '/':
            return 2;

            case '^':
            return 3;
        }

        return -1;
    }

    static Object[] toPostfix(String[] pieces)
    {
        Stack<Object> operator = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        Stack<Object> postExp = new Stack<>();
        Object [] postFix = new Object[pieces.length];
        int leftOff = 0;
        for(int i = 0; i < pieces.length; i++)
        {
            String g = pieces[i];
            System.out.println("g value: " + g.charAt(0));

            if(g.charAt(0) != '+' && g.charAt(0) != '-' && g.charAt(0) != '/' && g.charAt(0) != '*' && g.charAt(0) != '^' || g.charAt(0) == '(')
            {
            	if(g.charAt(0) == '('){	
            	postExp.push(Integer.parseInt("-" + g.substring(1, g.length()-1)));
            	}
            	else{
            		postExp.push(Integer.parseInt(g));
            	}
            }

            else
            {
                while(!operator.isEmpty() && precedence(g) <= precedence(operator.peek().toString()))
                {
                    // if current is less than top of stack, remove from stack & add to string
                	System.out.println("Whats going on with operations:" + operator.peek().toString().charAt(0));
                    postExp.push(operator.pop().toString().charAt(0));
                    System.out.println("in the array" + postFix[i] + "i value: " + i);
                }
                // if not, push into operator stack
                operator.push(g.toString().charAt(0));
            }
            leftOff = i;
        }

        
        while(!operator.isEmpty())
        {
        	postExp.push(operator.pop().toString().charAt(0));
            leftOff++;
        }
        postExp.toArray(postFix);

        // convert back to string and return

        return postFix;
    }
}
