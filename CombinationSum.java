/*
* The time complexity of this implementation is O(N^T)*/
import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<Integer> current, List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (candidate <= target) {
                current.add(candidate);
                backtrack(candidates, target - candidate, current, result, i);
                current.remove(current.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);
    }

}
