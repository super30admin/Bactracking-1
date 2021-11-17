//Running on leetcde: yes
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int target, int index, List<Integer> path) {
        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(index == candidates.length || target < 0) {
            return;
        }
        //logic
        //do not choose
        backtrack(candidates, target, index + 1, path);
        //choose
        //action
        path.add(candidates[index]);
        //recurse
        backtrack(candidates, target - candidates[index], index, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}
