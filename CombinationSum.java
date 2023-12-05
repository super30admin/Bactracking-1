
// Time complexity : O(2^m+n) , n-> no of elements in array , m -> target sum
// Space complexity : O(n*k), n-> no of elements in array , k -> average length of the combinations
import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = { 2, 3, 5 };
        int target = 8;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] candidates, int idx, int target, List<Integer> path, List<List<Integer>> result) {

        // base
        if (idx == candidates.length || target < 0)
            return;

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        // not choose
        helper(candidates, idx + 1, target, path, result);

        // choose
        path.add(candidates[idx]);
        helper(candidates, idx, target - candidates[idx], path, result);

        // Backtrack
        path.remove(path.size() - 1);

    }
}