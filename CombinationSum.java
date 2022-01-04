// Time Complexity : O(N^target)
// Space Complexity :O(N) for recursive stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We need to check every elemnt in the array till we get target == 0;
// when target == 0 , we found target sum.
// else we explore all ways using backtracking and removing the used elements.
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates,int target,int index,List<Integer>path){
        //base
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }
        //logic
        for(int i = index; i < candidates.length;i++){
            //action
            path.add(candidates[i]);
            // List<Integer> newList = new ArrayList<>(path);
            //newList.add(candidates[i]);

            //recurse
            helper(candidates,target-candidates[i],i,path);

            //backtrack
            path.remove(path.size() - 1);
        }
    }
}