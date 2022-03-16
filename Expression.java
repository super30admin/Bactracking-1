//Time: O(4^N + N) --> 4 operators, N -> length of nums
//Space: O(2N - 1) --> length of expression

class Solution {
    private List<String> result;
    private String nums;
    private int target;
    
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        nums = num;
        this.target = target;
        
        addOperators(0,0,0,new ArrayList<>());
        return result;
    }
    
    //we need to store the previous value used in the expression for applying multiplication later on 
    //index represents the current number we are processing
    //ops contains the expression we build
    //val is the output of the expression
    private void addOperators(int index, long val, long tail, List<String> ops) {
        //base
        //when we have processed all nums we have an expression in ops
        //add that to res if val == target
        if(index == nums.length()) {
            if(val == target) {
                StringBuilder res = new StringBuilder();
                for(String s: ops) {
                    res.append(s);
                }
                result.add(res.toString());
            }
            return;
        }
        
        //recurse
        
        
        for(int i=index; i<nums.length(); i++) {
            //get operandString as substring from index -> 1, 12, 123
            String operandStr = nums.substring(index,i+1);
            
            //get long type from string
            long operand = Long.parseLong(operandStr);
            
            //start, we have no operand(number) so get number
            //get first operand
            if(index == 0) {
                ops.add(operandStr);
                //current val and tail will be operand 
                addOperators(i+1, operand, operand, ops);
                //undo
                ops.remove(ops.size() - 1);
            } else { //we have operands, so apply operator
                
                //addition
                
                //add operandStr to ops with '+'
                ops.add("+" + operandStr);
                //val will be prev_val + operand
                //tail will be operand
                addOperators(i+1, 
                             val+operand,
                             operand,
                            ops);
                
                //undo adding operand
                ops.remove(ops.size()-1);
                
                
                //subtraction
                //add operandStr to ops with '-'
                ops.add("-" + operandStr);
                //val will be prev_val - operand
                //tail will be (-1*operand)
                addOperators(i+1,
                            val - operand,
                            (-1* operand),
                            ops);
                //undo 
                ops.remove(ops.size() - 1);
                
                //multiply

                //add operandStr to ops with '*'
                ops.add("*" + operandStr);
                //val will be (val-tail) + (tail * operand)
                //tail will be tail * operand
                addOperators(i+1,
                            (val - tail) + (tail * operand),
                             (tail * operand),
                             ops);
                             //undo
                ops.remove(ops.size() - 1);
                
            }

            //incase there is 0 like 1504
            //we should ignore that and move on to next index
            if(nums.charAt(index) == '0')
                break;
        }
        
    }
}