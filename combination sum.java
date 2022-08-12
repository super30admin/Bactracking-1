// Time Complexity : o(n^n) exponential
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        helper(candidates,0,target,new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates,int index,int target,List<Integer> path){
     //base case
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=index;i<candidates.length; i++){
            //List<Integer> newlist = new ArrayList<>(path);
            path.add(candidates[i]);
            helper(candidates,i,target-candidates[i],path);
            path.remove(path.size()-1);
        }
    }
}