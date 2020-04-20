// Time Complexity: O(2^n) CHeck. I am not sure
// Space Complexity with recursive stack: O(2 ^ n)
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return res;
        }
        helper(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int sum, int index, List<Integer> list) {
        if(target == sum) {
            res.add(new ArrayList<>(list));
            return;
        }

        if(sum > target) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, target, sum + candidates[i], i, list);
            list.remove(list.size()-1);
        }
    }
}