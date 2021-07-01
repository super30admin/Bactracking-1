import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
TC : O(4 ^ k!) where k = length of the given string num + 3 as there will be a tree with four branches and maximum depth can be k+3
SC : O(4 ^ k!)
Leetcode : No
Problems faced : Not able to handle the zero case where 1+05 is not valid
 */
public class ExpressionAddOperators {


        public List<String> list = new ArrayList();
        public char[] tokens = new char[]{' ','+','*','-'};
        public int len =0;
        public List<String> addOperators(String num, int target) {
            len = num.length();
            helper(num, target,1);
            return list;

        }

        public void helper(String num, int target, int index)
        {

            if(evaluate(num) == target && num.length()!= len)
                list.add(new String(num));

            System.out.println("String : "+num+"value is: "+evaluate(num));
            if(evaluate(num) > target && num.length()==len && index >= len)
                return;
            if(index > num.length()-1 && num.length()!=len)
                return;





            for(int i=0; i<tokens.length; i++)
            {
                String exp = "";
                if(tokens[i] == ' ')
                {
                    exp = num;
                    helper(exp, target, index+1);
                }

                else
                {
                    exp = num.substring(0,index) + tokens[i] + num.substring(index, num.length());
                    helper(exp, target, index+2);
                }



            }

        }

        public  int evaluate(String expression) {
            char[] tokens = expression.toCharArray();

            // Stack for numbers: 'values'
            Stack<Integer> values = new Stack<Integer>();

            // Stack for Operators: 'ops'
            Stack<Character> ops = new Stack<Character>();

            for (int i = 0; i < tokens.length; i++) {

                // Current token is a number,
                // push it to stack for numbers
                if (tokens[i] >= '0' && tokens[i] <= '9') {
                    StringBuffer sbuf = new StringBuffer();

                    // There may be more than one
                    // digits in number
                    while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                        sbuf.append(tokens[i++]);

                    values.push(Integer.parseInt(sbuf.toString()));

                    // right now the i points to
                    // the character next to the digit,
                    // since the for loop also increases
                    // the i, we would skip one
                    //  token position; we need to
                    // decrease the value of i by 1 to
                    // correct the offset.
                    i--;
                }

                // Current token is an operator.
                else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*') {
                    // While top of 'ops' has same
                    // or greater precedence to current
                    // token, which is an operator.
                    // Apply operator on top of 'ops'
                    // to top two elements in values stack
                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                        values.push(applyOp(ops.pop(),values.pop(), values.pop()));

                    // Push current token to 'ops'.
                    ops.push(tokens[i]);
                }
            }

            // Entire expression has been
            // parsed at this point, apply remaining
            // ops to remaining values
            while (!ops.empty())
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));

            // Top of 'values' contains
            // result, return it
            return values.pop();
        }

        // Returns true if 'op2' has higher
        // or same precedence as 'op1',
        // otherwise returns false.
        public  boolean hasPrecedence(char op1, char op2) {

            if ((op1 == '*') &&
                    (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }

        // A utility method to apply an
        // operator 'op' on operands 'a'
        // and 'b'. Return the result.
        public  int applyOp(char op, int b, int a) {
            switch (op) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;

            }
            return 0;
        }



}
