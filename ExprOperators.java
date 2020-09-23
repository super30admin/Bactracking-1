// Time Complexity : O(n^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Backtracking
class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        if(num==null || num.length()==0)
            return res;
        
        backtracking(num, target,"",0,0,0);
        return res;
    }
    
    private void backtracking(String num, int target, String path, long calc, long tail,int index){
        //base case
        if(index == num.length()){
            if(target == calc){
                res.add(path);
            }
            return;
        }
        
        //recursion
        for(int i=index; i<num.length(); i++){
            // preceding zero
            if(num.charAt(index) == '0' && index != i) break;
            long curr = Long.parseLong(num.substring(index, i+ 1)); 
            if(index == 0){
                backtracking(num, target, path + curr, curr, curr, i+ 1);
            } else {
                // +
                backtracking(num,target, path + "+" + curr, calc + curr, curr, i+ 1);
                // -
                backtracking(num,target, path + "-" + curr, calc - curr, -curr, i+ 1);
                // *
                backtracking(num,target, path + "*" + curr, calc - tail + tail * curr, tail*curr, i+1);
            }
        }
        
    }
}