// Time Complexity : Exponential
// Space Complexity : O(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(target < 0 || index == candidates.length)
            return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || index == candidates.length)
            return;
        //logic
        //not choose
        helper(candidates, target, index + 1, path);
        //choose
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index,  path);
        //backtrack
        path.remove(path.size() - 1);
    }
}