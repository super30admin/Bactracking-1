/**
 * time complexity is exponential
 * space complexity is exponential
 * 
 * all test cases don't pass -  time limit exceeds
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    char[] operators = {'+', '-', '*'};
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(num, target, 1, sb.append(num.charAt(0)));
        //System.out.println(checkValidity("00"));
        return result;
    }
    
    private void helper(String num, int target, int index, StringBuilder path) {
        if(index == num.length()) {
            if(checkValidity(path.toString()) && target == evaluate(path.toString())) {
                result.add(path.toString());
            }
            return;
        }
        for(char op : operators) {
            path.append(op);
            path.append(num.charAt(index));
            helper(num, target, index+1, path);
            path.deleteCharAt(path.length()-1);
            path.deleteCharAt(path.length()-1);
        }
        path.append(num.charAt(index));
        helper(num, target, index+1, path);
        path.deleteCharAt(path.length()-1);
    }

    // eliminates expressions with trailing zeros
    private boolean checkValidity(String exp) {
        exp = "+"+exp;
        for(int i = 0; i < exp.length()-2; i++) {
            char ch = exp.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                if(exp.charAt(i+1) == '0' && Character.isDigit(exp.charAt(i+2))) {
                    return false;
                }
            }
        }
        return true;
    }

    private int evaluate(String exp) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        
        char[] chars = exp.toCharArray();
        
        for(int i = 0; i < exp.length(); i++) {
            Character ch = chars[i];
            if(ch == '+' || ch == '-' || ch == '*') {
                ops.push(ch);
            }
            else {
                int num = 0;
                while(i < exp.length() && Character.isDigit(chars[i])) {
                    num = num*10 + (chars[i]-'0');
                    i++;
                }
                //System.out.println(num);
                i--;
                nums.push(num);
                if(!ops.isEmpty() && ops.peek() == '*') {
                    ops.pop();
                    int a = nums.pop();
                    int b = nums.pop();
                    nums.push(a*b);
                }
                else if(!ops.isEmpty() && ops.peek() == '-') {
                    ops.pop();
                    int a = nums.pop();
                    nums.push(-1*a);
                    ops.push('+');
                }
            }
        }
        
        while(!ops.isEmpty()) {
            int a = nums.pop();
            int b = nums.pop();
            char op = ops.pop();
            if(op == '+') {
                nums.push(a+b);
            }
            else {
                nums.push(b-a);
            }
        }
        return nums.pop();
    }
    
}