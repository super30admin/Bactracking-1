// Time complexity: 2 ^ (m + n)
// Space complexity: 2 ^ (m + n)

// Approach: Use for loop dfs to get all possible sums

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList();
        dfs(0, candidates, target, new ArrayList());
        return res;
    }

    private void dfs(int index, int[] candidates, int target, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}