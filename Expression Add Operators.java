/*
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
*/



/*

Edges Cases To be Handled:

1. If we are dealing with large number, we can encounter overflow. So use Long
2. Ignore Preceeding zeros
3. We need to follow PEDMAS

*/


// T: O(4^n) // Because we have four operators


class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> result = new ArrayList<String>();
        
        expressionEvaluation(result, "", num, target, 0, 0, 0);
        return result;
        
    }
    
    public void expressionEvaluation(List<String> result, String path, String num, int target, int index, long calculated, long tail){
        
        // Base case (calulated is equal to target)
        
        if(index == num.length()){
            
            if(calculated == target){
                result.add(path);
            }
            
            return;
        }
        
        for(int i = index; i < num.length(); i++){
            
            // To skip preceeding zeros and last zero
            if(i != index && num.charAt(index) == '0')   break;
            
            Long cur = Long.parseLong(num.substring(index, i + 1));
            
            if(index == 0){
                expressionEvaluation(result, path + cur, num, target, i + 1, cur, cur);
            }else{
                
                expressionEvaluation(result, path + "+" + cur, num, target, i + 1, calculated + cur, cur);
                expressionEvaluation(result, path + "-" + cur, num, target, i + 1, calculated - cur, -cur);
                expressionEvaluation(result, path + "*" + cur, num, target, i + 1, calculated - tail + cur * tail, cur * tail);
            }
            
        }
    }
}

// DFS Solution

class Solution {
    
    private String num;
    private int target;
    private List<String> answer;
    
    public List<String> addOperators(String num, int target) {
        
        this.num = num;
        this.target = target;
        answer = new LinkedList<>();
        
        if(num.isEmpty()) {
            return answer;
        }
        
        dfs(0, 0, ';', ';', "", 0, 0);
        return answer;
    }
    
    private int toInt(char digit){
        return digit - '0';
    }
    
    private long calculate(long a, char op, long b) {
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            default: return a * b;
        }
    }
    
    private long undoCalculate(long a, char opMade, long b) {
        return calculate(a, opMade == '+' ? '-' : '+', b);
    }
    
    private void dfs(int i, long currentNumber, char op, char previousOp, String expression, long total, long previousNumber){
    
        if(i == 0) {
            int digit = toInt(num.charAt(0));
            dfs(i + 1, currentNumber * 10 + digit, op, previousOp, expression + digit, total, previousNumber);
            return;
        }
        
        if(i < num.length() && currentNumber > 0){
            int digit = toInt(num.charAt(i));
            dfs(i + 1, currentNumber * 10 + digit, op, previousOp, expression + digit, total, previousNumber);
        }
        
        if(op == ';') {
            total = currentNumber;
            previousNumber = currentNumber;
        }
        else if(op == '*' && (previousOp == '+' || previousOp == '-')){
            total = undoCalculate(total, previousOp, previousNumber);
            previousNumber *= currentNumber;
            total = calculate(total, previousOp, previousNumber);
            op = previousOp; // remember if was summing or subtracting
        }
        else if(op == '*' && previousOp == '*'){
            total -= previousNumber;
            previousNumber *= currentNumber;
            total += previousNumber;
        }
        else {
            total = calculate(total, op, currentNumber);
            if(op == '*') {
                previousNumber = total;
            }
            else {
                previousNumber = currentNumber;
            }
        }
        
        if(i == num.length()){
            // System.out.println(expression + ':' + total);
            if(total == target) answer.add(expression);
            return;
        }
        
        int digit = toInt(num.charAt(i));
        dfs(i + 1, digit, '+', op, expression + '+' + digit, total, previousNumber);
        dfs(i + 1, digit, '-', op, expression + '-' + digit, total, previousNumber);
        dfs(i + 1, digit, '*', op, expression + '*' + digit, total, previousNumber);
        
        
        
    }
    
}

