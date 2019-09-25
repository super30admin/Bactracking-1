class ExpressionAddOperators {
    // Appraoch - Backtracking
    // Time complexity - exponential
    // Space complexity - O(N)
    // Tested in leetcode
    
    // Driver function for backtracking and cheking all posibilities of expression
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num,target,result,0,0,0,new StringBuilder());
        return result;
    }
    public void helper(String num, int target, List<String> result, int index, long prev, long sum, StringBuilder sb){
        // base case when loop reach to the end, check if sum == target, if yes then add into the final result otherwise do nothing and           // return.
        if(index == num.length()){
            System.out.print(sb.toString()+" ");
            System.out.println();
            if(target == prev)
                result.add(sb.toString());
            return;
        }
        
        //find the first operand
        for(int i=index; i<num.length(); i++){ 
            // if the first digit of the operand is 0 and other digits are non zero ie 01, 02,001 then operand is invalid.
            //  in such case come out of the loop and try to next operand otherwise folloe regular steps.
            if(num.charAt(index) == '0' && index != i)
                break;
            
            //regular steps
            // create valid operand from the given num string, store current length to undo the current while backtracing
            long curr = Long.parseLong(num.substring(index, i + 1));
            int len = sb.length();
            
            //if index is 0 means stringbuilder sb is empty, store operand first into sb, calculate equivalence of the expression on fly
            // recurse, backtrak and undo the move using stored length of sb.
            if(index == 0){
                helper(num,target,result,i+1,curr,curr,sb.append(curr));
                sb.setLength(len);
            }
            else{
                // call recursion on next operand and particular operator, build sb, calculate equivalence of the expression on the fly
                // backtrack and undo the move.
                helper(num,target,result,i+1,prev+curr,curr,sb.append("+").append(curr));
                sb.setLength(len);
                helper(num,target,result,i+1,prev-curr,-curr,sb.append("-").append(curr));
                sb.setLength(len);
                helper(num,target,result,i+1,prev-sum+sum*curr,sum*curr,sb.append("*").append(curr));
                sb.setLength(len);
            }
        }
    }
}