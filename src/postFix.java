import java.util.Stack;

public class postFix {

    static int precedence(char g)
    {
        switch(g)
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

    static String toPostfix(String infix)
    {
        Stack<Character> operator = new Stack<>();
        StringBuilder postfix = new StringBuilder();


        for(int i = 0; i < infix.length(); i++)
        {
            char g = infix.charAt(i);

            if(Character.isLetterOrDigit(g))
            {
                postfix.append(g);
            }

            else
            {
                while(!operator.isEmpty() && precedence(g) <= precedence(operator.peek()))
                {
                    // if current is less than top of stack, remove from stack & add to string
                    postfix.append(operator.pop());
                }
                // if not, push into operator stack
                operator.push(g);
            }
        }

        // pop the remaining operators
        while(!operator.isEmpty())
        {
            postfix.append(operator.pop());
        }

        // convert back to string and return
        return postfix.toString();
    }
}
