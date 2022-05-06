//simple recursive approach
// this approach is extremely slow because we are creating new list every iteration

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        //base
        if(target == 0) {
            result.add(path);
            return;
        }
        if(index == candidates.length || target < 0) {
            return;
        }
        //logic
        //0 case not choose
        helper(candidates, target, index + 1, new ArrayList<>(path));
        //1 case choose
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, new ArrayList<>(path));
    }
}