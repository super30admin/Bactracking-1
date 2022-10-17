// Time Complexity: O(2 ^N)
// Space Complexity: O(N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // base case
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        // initialize result
        result = new ArrayList<>();
        // start recursive call
        dfs(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void dfs(int[] array, int index, int target, List<Integer> temp) {
        // base case
        if (target < 0 || index == array.length) return;

        if (target == 0)  {
            result.add(new ArrayList<>(temp));
            return;
        }

        //logic
        //dont' choose
        dfs(array, index + 1, target, temp);
        // choose
        temp.add(array[index]);
        dfs(array, index, target - array[index], temp);
        //back track
        temp.remove(temp.size()-1);

    }
}
