class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        
        backtrack(result, num, target, 0, "", 0, 0);
        
        return result;
        
    }
    private void backtrack(List<String> result, String num, int target, int index, String expression, long value, long prevSignedOperand)
    {
        if(index == num.length()){
            if(value == target){
                result.add(expression);
            }
            return;
        }
        
        for(int i=index; i<num.length(); i++){
            if(index != i && num.charAt(index) == '0') break;
            long operand=Long.parseLong(num.substring(index, i+1));
            if(index == 0){
                backtrack(result, num, target, i+1, ""+operand, operand, operand);
            } else {
            //add
            backtrack(result, num, target, i+1, expression+"+"+operand, value+operand, operand);
            //subtract
            backtrack(result, num, target, i+1, expression+"-"+operand, value-operand, -1*operand);
            //multiply
            backtrack(result, num, target, i+1, expression+"*"+operand, value-prevSignedOperand+operand*prevSignedOperand, operand*prevSignedOperand);
            }
        }
    }
}