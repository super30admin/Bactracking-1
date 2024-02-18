// Time Complexity : O(2^m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<Integer>> ans;
    private void helper(int[] candidates, int target, int pivot, List<Integer> path){
        //base
        if(target < 0)
            return;
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = pivot; i < candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates,target-candidates[i],i,path);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.ans = new ArrayList<List<Integer>>();
        helper(candidates,target,0,new ArrayList<>());
        


        return ans;
    }
}