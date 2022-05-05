// Time Complexity : O(2^n)
// Space Complexity : O(target/min(nums)) Stack size would be height of the tree, which would be equal to the minimum element in nums divided by target
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates==null||candidates.length==0)
            return result;
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    private void helper(int[]candidates,int target, int index, List<Integer> path){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0)
            return;
        for(int i = index;i<candidates.length;i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates,target-candidates[i],i,path);
            //remove
            path.remove(path.size()-1);
        }
    }
}