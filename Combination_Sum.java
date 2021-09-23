// Time Complexity : O(2^n), We have 2 choices at every level(choose and not choose) and hence becomes 2^n in recursion.
// Space Complexity : O(n)=O(n), Length of the candidates list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || index == candidates.length)return;
        //logic
        //not choose
        helper(candidates,target,index+1,path);
        //choose
        path.add(candidates[index]);
        helper(candidates,target-candidates[index],index,path);
        path.remove(path.size()-1);
    }   
}

