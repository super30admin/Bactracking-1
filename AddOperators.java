// Time Complexity :O(n(3^n))
// Space Complexity : O(n) for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> output = new ArrayList<>();
        backtracking(num,target,output,0,"",0,0);
        return output;
    }
    
    private void backtracking(String num, int target,List<String> output, int index, String expr, long prevSum, long prevAdd){
        if(index>=num.length()){
            if(prevSum==target){
                output.add(expr);
            }
            return;
        }
        
        for(int i=index;i<num.length();i++){
            long curr = Long.parseLong(num.substring(index,i+1));
            if(num.charAt(index)=='0' &&  i!=index){
                continue;
            }
                if(index==0){
                    backtracking(num,target,output,i+1,expr+curr,curr,curr);
                }else{
                    //+
                    backtracking(num,target,output,i+1,expr+'+'+curr,prevSum+curr,curr);
                    //-
                    backtracking(num,target,output,i+1,expr+'-'+curr,prevSum-curr,curr*-1);
                    //*
                    backtracking(num,target,output,i+1,expr+'*'+curr,prevAdd*curr+prevSum-prevAdd,prevAdd*curr);
                }
        }
    }
}