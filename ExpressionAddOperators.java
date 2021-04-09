class Solution {
    List<String> output = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        // Inital backtracking function
        backtracking(num, target, 0, 0, 0, "");
        return output;
    }
    
    private void backtracking(String num, int target, int index, long prevSum, long preAdd, String expr){
        // base case, check if prevSum is equal to target, add expr to output list
        if(index >= num.length()){
            if(prevSum == target){
                output.add(expr);
            }
            return;
        }
        
        // logic
        for(int i=index; i<num.length(); i++){
            // substring
            long curr = Long.parseLong(num.substring(index, i+1));
            
            if(num.charAt(index) == '0' && index != i){
                continue;
            }
            
            // calling backtracking function
            if(index == 0){
                backtracking(num, target, i+1, curr, curr, expr + curr);
            }else{
                //+
                backtracking(num, target, i+1, prevSum + curr, curr, expr + "+" + curr);
                //-
                backtracking(num, target, i+1, prevSum - curr, -curr, expr + "-" + curr);
                //*
                backtracking(num, target, i+1, prevSum - preAdd + preAdd * curr, preAdd * curr, expr + "*" + curr);
            }
        }
    }
}