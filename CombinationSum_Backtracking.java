
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int currSum, int index, List<Integer> path) {
        if(currSum == target) {
            result.add(path);
            return;
        }

        if(currSum > target || index == candidates.length) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            currSum += candidates[i];
            helper(candidates, target, currSum, i, temp);
            currSum -= candidates[i];
        }
    }
} 
