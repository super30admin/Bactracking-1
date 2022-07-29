// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }
    void helper(int[] candidates,int target,int index, List<Integer> path){
        if(target<0 || index == candidates.length){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        helper(candidates,target,index+1,path);
        path.add(candidates[index]);
        helper(candidates,target - candidates[index],index,path);
        path.remove(path.size()-1);
    }
}