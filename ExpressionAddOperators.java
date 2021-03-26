//TC:
//SC:
//TC:O(4^N)
//SC:(O(N* 4^N))
class Solution{
void dfs(List<String> ret, char[] path, int len, long left, long cur, char[] digits, int pos, int target) {
    if (pos == digits.length) {
        if (left + cur == target) ret.add(new String(path, 0, len));
        return;
    }
    long n = 0;
    int j = len + 1;
    for (int i = pos; i < digits.length; i++) {
        n = n * 10 + digits[i] - '0';
        path[j++] = digits[i];
        path[len] = '+';
        dfs(ret, path, j, left + cur, n, digits, i + 1, target);
        path[len] = '-';
        dfs(ret, path, j, left + cur, -n, digits, i + 1, target);
        path[len] = '*';
        dfs(ret, path, j, left, cur * n, digits, i + 1, target);
        if (digits[pos] == '0') break; 
    }
}
public List<String> addOperators(String num, int target) {
    List<String> ret = new LinkedList<>();
    if (num.length() == 0) return ret;
    char[] path = new char[num.length() * 2 - 1];
    char[] digits = num.toCharArray();
    long n = 0;
    for (int i = 0; i < digits.length; i++) {
        n = n * 10 + digits[i] - '0';
        path[i] = digits[i];
        dfs(ret, path, i + 1, 0, n, digits, i + 1, target);
        if (n == 0) break;
    }
    return ret;
}
} 
class Solution {
    
public List<String> addOperators(String num, int target) {

       List<String> expressions = new ArrayList<>();

       if (num == null || num.isEmpty())
           return expressions;

       char cache[] = new char[2 * num.length()];

       addOperators(num.toCharArray(), target, 0, 0, 0, cache, 0, expressions);

       return expressions;


   }

   /**
    * @param num
    * @param target
    * @param index
    * @param currentValue
    * @param lastValue
    * @param expression
    * @param result
    */
   private void addOperators(char num[], int target, int index, long currentValue, long lastValue, char[] expression, int expressionEndIndex, List<String> result) {

       /**
        * Our Constraints:
        * 1. We can't take more numbers than given in input string ( index >= input.length)
        */

       if (index == num.length) {

           /**
            * Our Goal:
            * 1. once we form a expression, if that expression evaluates to our "target" then this is our solution.
            */

           if (currentValue == target) {
               //then this is our solution.
               result.add(new String(expression, 0, expressionEndIndex));

           } //2. if not, we discard


           return;

       }

       /**
        * Find new cache length;
        * the corner case, where we have no data in cache, in this case we need to push at first index (0) otherwise at the next index
        *
        */
       int nextExpressionEndIndex = (index == 0) ? expressionEndIndex : expressionEndIndex + 1;

       long currentDigitsValue = 0;
       /**
        * Our choices:
        * 1. We can choose a single digits as operands Or multi digits as operand (  1 + 2 or 12 + 34 )
        */
       for (int i = index; i < num.length; i++) {


           /**
            * We don't consider a operand which is 0 as single digit operand, as operand like 0 or 01 , 023... does not make sense
            *  To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
            */
           if (i != index && num[index] == '0')
               break;

           currentDigitsValue = currentDigitsValue * 10 + num[i] - '0';


           /**
            * Our Constraints:
            * 4. We need two operands for a operator and operator can't be apply on single operand
            */

           if (index == 0) {
               // as this is the first digit only, then don't apply any operator
               //Append
               expression[nextExpressionEndIndex++] = num[i];


               addOperators(num, target, i + 1, currentDigitsValue, currentDigitsValue, expression, nextExpressionEndIndex, result);

           } else {
               //We have two operands, last and current
               //Append
               expression[nextExpressionEndIndex++] = num[i];

               /**
                * Plus operator application '+'; Current value become = so far value + current digit value and last value would be the current digit value
                * current Value = 12
                * last Value = 2 ( say we did like 10 + 2 )
                * currentDigitvalue = 5 then expression is 10 + 2 + 5 = 17
                * So last value would be 5
                */
               expression[expressionEndIndex] = '+';
               addOperators(num, target, i + 1, currentValue + currentDigitsValue, currentDigitsValue, expression, nextExpressionEndIndex, result);

               /**
                * Minus operator application '-'; Current value become = so far value - current digit value and last value would be the -current digit value
                * current Value = 12
                * last Value = 2 ( say we did like 10 + 2 )
                * currentDigitvalue = 5 then expression is 10 + 2 - 5 = 7
                * So last value would be -5
                */
               expression[expressionEndIndex] = '-';
               addOperators(num, target, i + 1, currentValue - currentDigitsValue, -currentDigitsValue, expression, nextExpressionEndIndex, result);

               /**
                * Multiply operator application '*'; As this has the highest precedence then + and -, we simply can't apply * on last and current value.
                * Current value become = currentValue - lastValue + last*currentDigitvalue;
                * For example
                * current value = 12 ,
                * last value = 2 ( let say we applied + as 10 + 2 )
                * currendDigitValue = 4
                * so expression become : 10 + 2 * 4
                * if we simply do 12 * 4 = 24 which is wrong as 10 + 2 * 4 = 10 + 8 = 18
                *
                * New value = 10 + 2 * 4 = 18
                * last value = 2*4 = 8
                *
                *
                */
               expression[expressionEndIndex] = '*';
               addOperators(num, target, i + 1, currentValue - lastValue + lastValue * currentDigitsValue, lastValue * currentDigitsValue, expression, nextExpressionEndIndex, result);

           }


       }


   }
}