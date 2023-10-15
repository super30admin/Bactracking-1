/* 

Combination Sum (https://leetcode.com/problems/combination-sum/)

Time Complexity : O(2^n)
Space Complexity : O(2^n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }

        List<Integer> path = new ArrayList<>();
        recursive(candidates, target, 0, path);
        return result;
    }

    private void recursive(int[] candidates, int target, int index, List<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
        }
        for(int i = index; i < candidates.length; i++){
            path.add(candidates[i]);
            recursive(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }

    }
}