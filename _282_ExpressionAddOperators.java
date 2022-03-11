

// Time Complexity : o(2^n-1)*n where n is length of string
// Space Complexity : o(n) length of recursive stack
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time Limit Exceeded for larger inputs

// Your code here along with comments explaining your approach
//Intution : generate all possibe expressions and evaluate them to be equal to target at end



class Solution {

    List<String> res;

    //@ means concatenate digits
    char[] arr = {'+','-','*', '@'};

    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        // fill blank spaces after every digit
        for(int i=0; i<num.length(); i++){
            sb.append(num.charAt(i));
            sb.append('.');
        }
        sb.deleteCharAt(sb.length()-1);

        dfs(sb, target, 0);

        return res;
    }

    public void dfs(StringBuilder sb, int target, int i){

        if(i == sb.length() -1) {
            String temp = sb.toString().replaceAll("@","");
            if(calculate(temp, target)){
                res.add(temp);
            }
            return;
        }

        //try all possible operators in blank places and generate different string expression
        if(sb.charAt(i) != '.' ){
            dfs(sb, target, i+1);
        }
        else{
            for(int j=0 ; j<arr.length; j++){
                sb.deleteCharAt(i);
                sb.insert(i, arr[j]);
                dfs(sb, target, i+1);
                sb.deleteCharAt(i);
                sb.insert(i, '.');
            }
        }
    }


//evaluate string expression (evaluation code works as i checked it using Basic calculator II leetcode submission)
    public boolean calculate(String s, int target) {
        s = s.replaceAll(" ","");

        Stack<String> stack = new Stack<>();

        int i = 0 ;
        while(i<s.length()){

            if(Character.isDigit(s.charAt(i))){
                long num = 0;

                // to handle 105 as 1+ 05 invalid case
                if(i< s.length()-1 && s.charAt(i)=='0' && Character.isDigit(s.charAt(i+1))){
                    return false;
                }

                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i)-'0');
                    i++;
                }

                if(!stack.isEmpty() && stack.peek().equals("*")){
                    stack.pop();
                    num = Long.parseLong(stack.pop()) * num;

                }
                else if(!stack.isEmpty() &&stack.peek().equals("/")){
                    stack.pop();
                    num = Long.parseLong(stack.pop()) / num;

                }
                else if(!stack.isEmpty() &&stack.peek().equals("-")){
                    stack.pop();
                    num *= -1;
                }
                stack.push(Long.valueOf(num).toString());
            }
            else{
               stack.push(Character.valueOf(s.charAt(i)).toString());
                i++;
            }

        }

        long prev = 0;

    		while(!stack.isEmpty()){
    			String str = stack.pop();
    			if(!(str.charAt(0) == '+')){
    				prev += Long.parseLong(str);
    			}
    		}

  		  return target == (int)prev;

    }
}

// Time Complexity : o(2^n-1)*n where n is length of string
// Space Complexity : o(n) length of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Intution : Calculate expression on the fly

/**********************************************************************************************

Given : oldVal, oldtail, currOperand

Operation                  NewVal                                             Newtail

i==0                     currOperand                                       currOperand

Add                    oldVal + currOperand                               currOperand

Subtract               oldVal - currOperand                               -currOperand

Multiply               oldVal - oldtail + oldtail * currOperand            oldtail*currOperand



***********************************************************************************************/


class Solution {

    List<String> res;

    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        dfs(num, target, 0, 0, 0, new ArrayList<>());
        return res;
    }

    public void dfs(String num, int target,
                    int index, long val, long tail,
                    List<String> currExpression){

        // base
        if(index == num.length()){

            if(target == val){
                StringBuilder sb = new StringBuilder();
                for( String expr : currExpression){
                    sb.append(expr);
                }
                res.add(sb.toString());
            }

            return;
        }

        // take action , call recursion and then undo taken action
        for(int i=index; i < num.length(); i++){

            String operandStr = num.substring(index, i+1);

            //To handle 105, 5 == 1 * 05 invalid case, ignore all operands with trailing zeros.
            if(operandStr.length() == 2 && operandStr.charAt(0) == '0') return;

            long operand = Long.parseLong(operandStr);


            if( index == 0){
                currExpression.add(operandStr);
                dfs(num, target, i+1, operand, operand , currExpression);
                currExpression.remove(currExpression.size()-1);
            }
            else{

                //Add
                currExpression.add("+"+operandStr);
                dfs(num, target, i+1, val+operand, operand , currExpression);
                currExpression.remove(currExpression.size()-1);

                //Subtract
                currExpression.add("-"+operandStr);
                dfs(num, target, i+1, val-operand, -operand , currExpression);
                currExpression.remove(currExpression.size()-1);

                //Multiply
                currExpression.add("*"+operandStr);
                dfs(num, target, i+1, val-tail + tail * operand, tail * operand , currExpression);
                currExpression.remove(currExpression.size()-1);

            }
        }
    }
}
