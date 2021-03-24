//Time Complexity: O(N^3)
//Space Complexity: O(N) asymptotically

//Code
class Solution {
    private List<String> output = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        backtracking(num,target, 0, 0 ,0 ,"");
        return output;
    }
    
    private void backtracking(String num,int target,int ind,long prevSum, long prevAdd, String exp){
        //base case 
        if(ind >= num.length()){
            if(prevSum == target){
                output.add(exp);
            }
            return;
        }
        
        
        
        //logic
        for(int i=ind;i<num.length();i++){
            long curr = Long.parseLong(num.substring(ind, i+1));
            if((num.charAt(ind) == '0') && ind != i){
                continue;
            }
            if(ind == 0){
                backtracking(num, target, i+1, curr, curr, exp + curr);
            }
            else{
                //+
                backtracking(num, target, i+1, prevSum + curr, curr, exp+ '+' +curr);
                //-
                backtracking(num, target, i+1, prevSum - curr, -curr, exp+ '-' +curr);
                //*
                backtracking(num, target, i+1, prevSum - prevAdd + prevAdd * curr, prevAdd *curr, exp+ '*' +curr);
            }
        }
    }
}