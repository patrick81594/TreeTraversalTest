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
        Stack<Character> operator = new Stack<>();

        Stack<Object> postFix = new Stack<>();
        Object[] postArr = new String[pieces.length];

        for(int i = 0; i < pieces.length; i++)
        {
            String g = pieces[i];

            if(g.toString().charAt(0) != '+' && g.toString().charAt(0) != '-' && g.toString().charAt(0) != '*' && g.toString().charAt(0) != '/' && g.toString().charAt(0) != '^' || g.toString().charAt(0) == '(')
            {
            	if(g.toString().charAt(0) == '(')
                postFix.push("-" + Integer.parseInt(g.substring(1, g.length()-1)));
            	else {
            		postFix.push(Integer.parseInt(g));
            	}
            }

            else
            {
                while(!operator.isEmpty() && precedence(g) <= precedence(operator.peek().toString()))
                {
                    // if current is less than top of stack, remove from stack & add to string
                    postFix.push(operator.pop());
                }
                // if not, push into operator stack
                operator.push(g.charAt(0));
            }
        }

        // pop the remaining operators
        while(!operator.isEmpty())
        {
            postFix.push(operator.pop());
        }
        postArr = postFix.toArray();
        System.out.print("postArr" + postArr[0].toString() + postArr[1].toString());
        // convert back to string and return
        return postArr;
    }
}
